package com.example.EMS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    UserDbContext ObjUser = new UserDbContext();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _command = request.getParameter("command");
        try {
        if(_command.equals("login")){
            checkUser(request,response);
        }
        else {
            AddnewUser(request,response);
        }
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    private void AddnewUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("txtname");
        String contact = request.getParameter("txtcontact");
        String uname = request.getParameter("txtusername");
        String pass = request.getParameter("txtpassword");
        users _user = new users(name,contact,uname,pass);
        ObjUser.AddNewUser(_user);
        response.sendRedirect("/index.jsp");
    }

    private void checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uname = request.getParameter("txtusername");
        String pass = request.getParameter("txtpassword");
        if(ObjUser.CheckUser(uname,pass)){
            RequestDispatcher _disp = request.getRequestDispatcher("/getEmployees");
            _disp.forward(request,response);
        }else {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Invalid Username or Password');");
            pw.println("</script>");
            RequestDispatcher _disp = request.getRequestDispatcher("/index.jsp");
            _disp.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
