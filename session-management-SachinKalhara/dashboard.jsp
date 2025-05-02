<%@page import="java.util.List"%>
<%@page import="Course"%>
<html>
    <head>
        <title>dashBoard</title>
    </head>
    <body>
        <h2>DashBoard</h2>

        <form method="post" action="LogoutServlet">
            <input type="submit" value="Logout">
        </form>

        <% String message = (String) request.getAttribute("message");
        if (message != null) { %>
            <p style="color:green;"><%= message %></p>
        <% } %>

        <h3>Available Courses</h3>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Instructor</th>
                <th>Action</th>
            </tr>
            <%
                List<Course> courses = (List<Course>) request.getAttribute("courses");
                if (courses != null) {
                    for (Course c : courses) {
            %>
            <tr>
                <td><%= c.getCourseId() %></td>
                <td><%= c.getCourseName() %></td>
                <td><%= c.getInstructor() %></td>
                <td><a href="EnrollServlet?courseId=<%= c.getCourseId() %>">Enroll</a></td>
            </tr>
            <%      }
                }
            %>
        </table>

        <h3>Enrolled Courses</h3>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Instructor</th>
            </tr>
            <%
                List<Course> enrolledCourses = (List<Course>) request.getAttribute("enrolledCourses");
                if (enrolledCourses != null && !enrolledCourses.isEmpty()) {
                    for (Course c : enrolledCourses) {
            %>
            <tr>
                <td><%= c.getCourseId() %></td>
                <td><%= c.getCourseName() %></td>
                <td><%= c.getInstructor() %></td>
            </tr>
            <%      }
                } else {
            %>
            <tr>
                <td colspan="3">No courses enrolled yet.</td>
            </tr>
            <% } %>
        </table>
    </body>
</html>