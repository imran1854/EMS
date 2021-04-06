package com.example.EMS;

import java.sql.*;
import java.util.*;

public class EmployeeDbContext {
    Connection con = null;
    Statement stm = null;
    PreparedStatement Pstm = null;
    ResultSet rs = null;

    public List<Employee> getEmployeeList() throws SQLException {
        List<Employee> _list = new ArrayList<>();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "123i");
            stm = con.createStatement();
            String sql = "Select * from eployees";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fnmae = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String email = rs.getString("email");
                boolean status = rs.getBoolean("status");
                Employee emp = new Employee(id, fnmae, lname, email, status);
                _list.add(emp);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            releaseMemory(con, Pstm, rs, stm);
        }

        return _list;
    }

    public void saveEmployee(Employee obj) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","123i");
            String sql = "insert into eployees(first_name,last_name,email,status) values(?,?,?,?)";
            Pstm = con.prepareStatement(sql);
            //set params

            Pstm.setString(1, obj.getFirstName());
            Pstm.setString(2, obj.getLastName());
            Pstm.setString(3, obj.getEmail());
            Pstm.setBoolean(4, obj.isStatus());
            Pstm.execute();


        }catch (Exception exc){
            exc.printStackTrace();
        }

    }

    public Employee loadEmployeeByID(int id) throws Exception {
        Employee ObjEmp = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","123i");
            String sql = "Select * from eployees where id = ?";
            Pstm = con.prepareStatement(sql);
            Pstm.setInt(1,id);
            rs = Pstm.executeQuery();
            while (rs.next()){
                ObjEmp = new Employee(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"),rs.getBoolean("status"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            releaseMemory(con,Pstm,rs,null);
            return ObjEmp;
        }
    }
    public void UpdateEmployee(Employee emp_obj) throws Exception {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","123i");
            String sql  = "Update eployees set"
                    +" first_name = ?, last_name = ?, email = ? , status = ?"
                    +" where id = ?";
            Pstm = con.prepareStatement(sql);
            Pstm.setString(1, emp_obj.getFirstName());
            Pstm.setString(2, emp_obj.getLastName());
            Pstm.setString(3, emp_obj.getEmail());
            Pstm.setBoolean(4, emp_obj.isStatus());
            Pstm.setInt(5, emp_obj.getId());
            Pstm.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            releaseMemory(con,Pstm,null,null);
        }

    }
    private void releaseMemory(Connection con, PreparedStatement pstm, ResultSet rs, Statement stm) {
        try{
            if(con != null){
                con.close();
            }
            if(Pstm != null){
                Pstm.close();
            }
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                rs.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    public void deleteEmployee(String deleteID)  throws Exception {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","123i");
            String Sql = "Delete from eployees where id= ?";
            Pstm = con.prepareStatement(Sql);
            Pstm.setInt(1,Integer.parseInt(deleteID));
            Pstm.execute();
        }catch (Exception exc){
            exc.printStackTrace();
        }finally {
            releaseMemory(con,Pstm,null,null);
        }

    }
}
