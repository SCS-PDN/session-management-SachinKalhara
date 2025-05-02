import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseId = request.getParameter("courseId");

        // Dummy course lookup
        Course course = null;
        if ("101".equals(courseId)) course = new Course("101", "Mathematics", "Dr.Kamal");
        else if ("102".equals(courseId)) course = new Course("102", "Physics", "Dr.Amal");
        else if ("103".equals(courseId)) course = new Course("103", "Chemistry", "Dr.Nimal");

        HttpSession session = request.getSession();
        List<Course> enrolledCourses = (List<Course>) session.getAttribute("enrolledCourses");
        if (enrolledCourses == null) {
            enrolledCourses = new ArrayList<>();
        }

        if (course != null && !enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
        session.setAttribute("enrolledCourses", enrolledCourses);

        response.sendRedirect("DashboardServlet?message=Successfully+enrolled+in+" + course.getCourseName());
    }
}
