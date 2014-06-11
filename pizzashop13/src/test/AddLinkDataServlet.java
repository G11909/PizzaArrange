package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.Message.*;
import javax.mail.internet.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AddLinkDataServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String m="";
        String name = req.getParameter("title");
        String url = req.getParameter("url");
        String count1 = req.getParameter("count1");
        int num1 = Integer.parseInt(count1);
         int num2=num1*2400;
         if(num1!=0){
        	 m+="・クワトロ："+num1+"個　"+num2+"円\n";
         }
        String count2 = req.getParameter("count2");
        int num3 = Integer.parseInt(count2);
        int num4 = num3*3000;
        if(num3!=0){
       	 m+="・チーズメルト："+num3+"個　"+num4+"円\n";
        }
        String count3 = req.getParameter("count3");
        int num5 = Integer.parseInt(count3);
        int num6 = num5*2700;
        if(num5!=0){
          	 m+="・カマンベールミルフィーユ："+num5+"個　"+num6+"円\n";
           }
        String count4 = req.getParameter("count4");
        int num7 = Integer.parseInt(count4);
        int num8 = num7*3400;
        if(num7!=0){
         	 m+="・リストランテ："+num7+"個　"+num8+"円\n\n";
          }
        int num9 = num2+num4+num6+num8;
        String total = String.valueOf(num9);

        LinkData data = new LinkData(name,url,count1,count2,count3,count4,total);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        
        resp.setContentType("text/html; charset=UTF-8");
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String add=user.getEmail();
     
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String messageBody = "◆PizzaShop　注文履歴◆\n"
        		+name+"様\n"+url+"\n\n"+m+"合計金額>>"+total+"円\n";

        try{
          MimeMessage message = new MimeMessage(session);
          message.setFrom(new InternetAddress("g11909hm@gm.tsuda.ac.jp", "Hayashi"));
          message.setRecipient(Message.RecipientType.TO,
          new InternetAddress(add));
          message.setSubject("ピザショップ注文履歴","ISO-2022-JP");
          message.setText(messageBody);
          Transport.send(message);
        }
        catch(AddressException e){

        }
        catch(MessagingException e){

        }
        
        resp.sendRedirect("/index.html");
    }

}
