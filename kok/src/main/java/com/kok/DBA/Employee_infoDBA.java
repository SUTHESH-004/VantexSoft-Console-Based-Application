package com.kok.DBA;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import com.kok.Modal.employee;
// import com.kok.DBA.dbconnection;
import com.kok.views.Scan;
// import com.mysql.cj.xdevapi.Statement;

public class Employee_infoDBA extends Scan {
     
    public static ArrayList<employee> employeedetails() throws SQLException {
        Connection con = Dbconnection.getconnection();
        String query = "select * from employeeinfo ";
        // Statement s = con.createStatement();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        ArrayList<employee> list = new ArrayList<employee>();
        
        while (rs.next()) {
                    employee emp =  new employee();
                     emp.setname(rs.getString(2));
                     emp.setdob(" "+rs.getDate(3));
                    emp.setcity(rs.getString(4));
                    emp.setstate(rs.getString(5));
                     emp.setcountry(rs.getString(6));
                     emp.setmobilenumber(rs.getString(7));          
                     emp.setjoineddate(""+rs.getDate(8));
                     emp.setrelieveddate(""+rs.getDate(9));
                     emp.setaddress(rs.getString(10));
                    list.add(emp);
        }
        return list;

    }
    public static Boolean addemployee(employee e){
        try{Connection con = Dbconnection.getconnection();
        String query ="insert into employeeinfo(employee_id,employee_name,employee_dob,employee_city,employee_state,employee_country,employee_mobilenumber,employee_joined_date,employee_address,posts_id,insert into values(?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,e.getid());
        ps.setString(2,e.getname());
        ps.setDate(3,java.sql.Date.valueOf(LocalDate.parse(e.getdob())));
        ps.setString(4,e.getcity());
        ps.setString(5,e.getstate());
        ps.setString(6,e.getcountry());
        ps.setString(7,e.getMobileNumber());
        ps.setString(8,e.getjoinedddate());
        ps.setString(9,e.getAddress());
        ps.setInt(10, e.getpostid());
        return true;}
        catch(Exception ex){
            ex.printStackTrace();
            return false;}
    }



}
