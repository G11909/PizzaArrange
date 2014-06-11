package test;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.api.users.*;

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
    	resp.setContentType("text/html; charset=UTF-8");
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String thisURL = req.getRequestURI();

        resp.setContentType("text/html");
        if (user != null ) {
            resp.getWriter().println("<p>���Ȃ���" +
            						user.getNickname() +
                                     "�Ƃ������O�Ń��O�C�����Ă��܂��B<a href=\"" +
                                     userService.createLogoutURL(thisURL) +
                                     "\">�T�C���A�E�g</a>.</p>");
            resp.getWriter().println("<a href=\"add2.html\">�s�U�𒍕�����</a>");            
        } else {
            resp.getWriter().println("<p>�����炩��<a href=\"" +
                                     userService.createLoginURL(thisURL) +
                                     "\">�T�C���C��</a>���Ă�������</p>");
        }
        
    }
}