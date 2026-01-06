<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Students</title>
</head>
<body>

<h2>Student Details</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>Action</th>
    </tr>

<%
    List<Student> studentList =
            (List<Student>) request.getAttribute("studentList");

    if (studentList != null) {
        for (Student s : studentList) {
%>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getCourse() %></td>
        <td>
            <a href="EditStudentServlet?id=<%= s.getId() %>">Edit</a>
            |
            <a href="DeleteStudentServlet?id=<%= s.getId() %>"
               onclick="return confirm('Are you sure?');">
               Delete
            </a>
        </td>
    </tr>
<%
        }
    }
%>

</table>

<br>
<a href="addStudent.jsp">Add New Student</a>

</body>
</html>
