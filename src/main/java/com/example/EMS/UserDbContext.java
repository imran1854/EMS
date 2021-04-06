package com.example.EMS;

import java.sql.*;

public class UserDbContext {
    Connection con = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    public void AddNewUser(users user) throws Exception {
        try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "123i");
        String sql = "Insert into tblUsers ( username,password,name,contactno ) values (?,?,?,?) ";
        pstm = con.prepareStatement(sql);
        pstm.setString(1,user.getUsername());
        pstm.setString(2,user.getPassword());
        pstm.setString(3, user.getName());
        pstm.setString(4, user.getContactno());
        pstm.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            close(con,stm,pstm,rs);
        }
    }

    private void close(Connection con, Statement stm, PreparedStatement pstm, ResultSet rs) throws Exception {
        if(con != null){
            con.close();
        }
        if(pstm != null){
            pstm.close();
        }
        if(stm != null){
            stm.close();
        }
        if(rs != null){
            rs.close();
        }
    }

    public boolean CheckUser(String uname, String pass) throws Exception {
        boolean _status = false;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "123i");
            String sql = "select * from tblusers where username = ? and password = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1,uname);
            pstm.setString(2,pass);
            rs = pstm.executeQuery();
            if(rs.next()){
                _status =  true;
            }
            else {
                _status =  false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            close(con,stm,pstm,rs);
        }
        return _status;
    }
}
