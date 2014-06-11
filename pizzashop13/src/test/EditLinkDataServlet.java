package test;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.*;;

public class EditLinkDataServlet extends HttpServlet{
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
        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String url = req.getParameter("url");
        String comment = req.getParameter("comment");
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        LinkData data = (LinkData)manager.getObjectById(LinkData.class,id);
        data.setTitle(title);
        data.setUrl(url);
        manager.close();
        resp.sendRedirect("/index.html");
    }
}
