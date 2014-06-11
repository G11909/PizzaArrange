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
            resp.getWriter().println("<p>あなたは" +
            						user.getNickname() +
                                     "という名前でログインしています。<a href=\"" +
                                     userService.createLogoutURL(thisURL) +
                                     "\">サインアウト</a>.</p>");
            resp.getWriter().println("<a href=\"add2.html\">ピザを注文する</a>");            
        } else {
            resp.getWriter().println("<p>こちらから<a href=\"" +
                                     userService.createLoginURL(thisURL) +
                                     "\">サインイン</a>してください</p>");
        }
        
    }
}