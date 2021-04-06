package com.example.EMS;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("Start thsi.................");
        String URL = "jdbc:sqlserver://RANA\\SQLEXPRESS;user=sa;password=12345;database=StudentDb";
        try (Connection con = DriverManager.getConnection(URL); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM tblUsers";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("username") + " " + rs.getString("password"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }



        /*try {

            Connection con = DriverManager.getConnection(URL);
            System.out.println("Connection made........");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from tblUsers");
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/


        /*response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");*/
    }

    public void destroy() {
    }

    public static void main(String[] args) {
        System.out.println("This is main ");
    }
}