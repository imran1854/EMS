package com.example.EMS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/getEmployees")
public class EmployeeServlet extends HttpServlet {
    EmployeeDbContext ObjEmp;

    @Override
    public void init() throws ServletException {
        ObjEmp = new EmployeeDbContext();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> _list= null;
        try{
            String _commond = request.getParameter("command");
            if(_commond == null){
                _list= ObjEmp.getEmployeeList();
            }
            else if(_commond.equals("ADD")){
                AddEmployee(request,response);
                _list= ObjEmp.getEmployeeList();
            }
            else  if(_commond.equals("LOAD")){
                loadEmployeeByID(request,response);
            }
            else  if(_commond.equals("UPDATE")){
                updateEmployee(request,response);
                _list= ObjEmp.getEmployeeList();
            }
            else  if(_commond.equals("DELETE")){
                deleteEmployee(request,response);
                _list= ObjEmp.getEmployeeList();
            }
            else {
                 _list= ObjEmp.getEmployeeList();
            }
            request.setAttribute("Emp_list",_list);
            RequestDispatcher _disp = request.getRequestDispatcher("showEmployeeData.jsp");
            _disp.forward(request,response);

        }catch (Exception exc){
            exc.printStackTrace();
        }

    }

    private void AddEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        boolean status =Boolean.valueOf(request.getParameter("status"));
        Employee obj = new Employee(fname,lname,email,status);
        ObjEmp.saveEmployee(obj);
    }

    private void loadEmployeeByID(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int _id = Integer.parseInt(request.getParameter("empid")) ;
        Employee _emp = ObjEmp.loadEmployeeByID(_id);
        request.setAttribute("THE_STUDENT",_emp);
        RequestDispatcher _dispacher  = request.getRequestDispatcher("/UpdateStudent.jsp");
        _dispacher.forward(request,response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int updateID = Integer.parseInt(request.getParameter("student_id"));
        Employee emp_obj = new Employee(updateID,request.getParameter("fname"),request.getParameter("lname")
                ,request.getParameter("email"),Boolean.getBoolean(request.getParameter("status")));
        ObjEmp.UpdateEmployee(emp_obj);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String _deleteID = request.getParameter("deleteID");
        ObjEmp.deleteEmployee(_deleteID);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
