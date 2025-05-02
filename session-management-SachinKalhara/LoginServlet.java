import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends Httpservlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if (("student1".equals(username)&&"pass1".equals(password))||
                ("student2".equals(username)&&"pass2".equals(password))){
            HttpSession session=request.getSession().setAttribute("username",username);

            Cookie userCookie=new Cookie("username",username);
            userCookie.setMaxAge(60*60);
            response.addCookie(userCookie);

            response.sendRedirect("DashboardServlet");
        }else {
            response.getWriter().println("Invalid LogIn."<a href='login.html'>Try Again</a>);
        }
    }
}