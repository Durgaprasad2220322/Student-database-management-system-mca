package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerStudent")
public class StudentRegistration extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");
        String semester = request.getParameter("semester");

        try {
            Connection con = DbConnection.getConnection();

            String sql = "INSERT INTO students(name, email, phone, course, semester) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, course);
            ps.setString(5, semester);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.sendRedirect("StudentRegistration/success.jsp");
            } else {
                response.sendRedirect("StudentRegistration/error.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
