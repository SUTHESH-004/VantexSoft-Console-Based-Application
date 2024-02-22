package com.kok.DBA;
import java.sql.*;
public class PostsDBA {

    // @Override
    public int positionChecker(int emp_id){
        try{
        Connection con = Dbconnection.getconnection();
        String Query ="select posts_id from employeeinfo where employee_id =? ";
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setInt(1,emp_id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        // System.out.print(rs.getInt(1));
        return rs.getInt(1);
        }
        catch(Exception e)
        {
           System.out.println("position checker is failed");
           return -1;
        }
        
    }
    // @Override
    
    
}