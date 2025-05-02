import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Hardcoded courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("101", "Mathematics", "Dr.Kamal"));
        courses.add(new Course("102", "Physics", "Dr.Amal"));
        courses.add(new Course("103", "Chemistry", "Dr.Nimal"));

        request.setAttribute("courses", courses);

        HttpSession session = request.getSession(false);
        List<Course> enrolledCourses = (List<Course>) session.getAttribute("enrolledCourses");
        if (enrolledCourses == null) {
            enrolledCourses = new ArrayList<>();
        }
        request.setAttribute("enrolledCourses", enrolledCourses);

        String message = request.getParameter("message");
        if (message != null) {
            request.setAttribute("message", message);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
