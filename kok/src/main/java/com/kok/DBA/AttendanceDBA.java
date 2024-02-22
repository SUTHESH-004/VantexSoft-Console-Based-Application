package com.kok.DBA;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import com.kok.Modal.Attendrep;
import com.kok.Modal.Report;
// import com.kok.Service.SendMail;
// import com.kok.Controller.Supervisor;
import com.kok.views.Supervisorview;

public class AttendanceDBA {

    public static boolean entryStatus(int emp_id, int position) throws SQLException {
        Supervisorview view = new Supervisorview();
        Connection con = Dbconnection.getconnection();
        LocalDate date = LocalDate.now();

        if (datechecker(date)) {
            String query = "select employee_name,employee_id from employeeinfo where posts_id not in(2,3)";
            Statement st = con.createStatement();
            ResultSet rp = st.executeQuery(query);
            // rp.next();
            System.out.println("Enter P to present | Enter A to absent ");
            while (rp.next()) {
                String name = rp.getString(1);
                view.print("Is " + name + " Present : ");
                String state = view.getString();
                String query1 = "insert into attendancesheet(employeeid,presentOrNot,dateOfwork,attendant_id)values(?,?,?,?);";
                PreparedStatement stated = con.prepareStatement(query1);
                stated.setInt(1, rp.getInt(2));
                stated.setString(2, state);
                // String date1 = date;
                // Date date1 = date;
                stated.setDate(3, java.sql.Date.valueOf(date));
                stated.setInt(4, emp_id);
                stated.executeUpdate();
            }
            String y = "insert into datedata values(?,?,?);";
            PreparedStatement ot = con.prepareStatement(y);
            ot.setBoolean(1, true);
            ot.setDate(2, java.sql.Date.valueOf(date));
            ot.setInt(3, emp_id);
            int rows = ot.executeUpdate();
            System.out.println("inserted date rows affected" + rows);

        } else {
            String query = "select employee_name from employeeinfo where employee_id= ?";
            PreparedStatement tt = con.prepareStatement(query);
            tt.setInt(1, emp_id);
            ResultSet yt = tt.executeQuery();
            yt.next();
            if (position == 2) {
                view.print("Todays Attendance is already entered by the Supervisor \" " + yt.getString(1) + "\" ");
            }
        }
        view.print("do you want to continue ? press 1 to continue | press 4 exit");
        String a = view.getString();
        if (a.equals("1"))
            return true;
        else {
            // System.exit(200);
            return false;
        }
    }

    private static Boolean datechecker(LocalDate date) throws SQLException {
        Connection con = Dbconnection.getconnection();

        String Query = "Select isDate from datedata where dates = ? ";
        PreparedStatement ss = con.prepareStatement(Query);
        ss.setDate(1, java.sql.Date.valueOf(date));
        ResultSet rs = ss.executeQuery();
        if (rs.next())
            return false;
        else
            return true;
    }

    public static ArrayList<Attendrep> TotalReport(String dt1, String dt2) throws SQLException {
        // try {
        Connection con = Dbconnection.getconnection();
        // String sqlQuery = "select count(dateOfwork) from attendancesheet group by employeeid";
        // Statement statement = con.createStatement();
        // ResultSet rscount = statement.executeQuery(sqlQuery);
        // rscount.next();
        int max = 0;
        LocalDate start = LocalDate.parse(dt1);
        LocalDate end   = LocalDate.parse(dt2);
        max = (int)ChronoUnit.DAYS.between(start, end);
        String Query = "select e.employee_name ,count(a.dateOfwork),sum(OutputPerDay) from attendancesheet a inner join employeeinfo e on a.employeeid = e.employee_id where presentOrNot='P' and dateOfwork>= ? and dateOfwork <= ? and posts_id <2 group by employeeid;";
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setString(1, dt1);
        ps.setString(2, dt2);
        ResultSet rs = ps.executeQuery();
        // rs.next();
        // System.out.println(dateformatter.format(dt2));
        ArrayList<Attendrep> list = new ArrayList<Attendrep>();
        while (rs.next()) {
            Attendrep r = new Attendrep();
            // System.out.print(rs.getString(1));
            int stre = rs.getInt(2);
            int out = rs.getInt(3);
            // System.out.print(stre);
            // System.out.print(" " + max);
            r.setName(rs.getString(1));
            r.setNo_of_days(max);
            r.setNo_presentdays(stre);
            r.setOutput(out);
            list.add(r);
            // System.out.println();
        }
        return list;

    }

    public static boolean enterOutput(int emp_id, int position) throws SQLException {
        Supervisorview view = new Supervisorview();
        Connection con = Dbconnection.getconnection();
        LocalDate date = LocalDate.now();
        view.print("Enter the Output of each person in kgs");
        // boolean v = datechecker(date);
        // false means attendance is entere
        // String query = "select e.employee_name,e.employee_id from attendancesheet a
        // join employeeinfo e on whwhere e.posts_id not in(2)and a.dateOfwork in(select
        // dates from datedata)";
        String query = "select e.employee_name,e.employee_id from attendancesheet a join employeeinfo e on a.employeeid = e.employee_id where e.posts_id not in(2) and a.dateOfwork in(?);";

        PreparedStatement pss = con.prepareStatement(query);
        pss.setDate(1, java.sql.Date.valueOf(date));
        // pss.setDate(1,java.sql.Date.valueOf(date));
        ResultSet rp = pss.executeQuery();
        while (rp.next()) {
            String name = rp.getString(1);
            view.print(name + "'/s  Output  :");
            // String name = rp.getString(1);
            int out = view.getInt();
            String query1 = "update attendancesheet set OutputPerDay = ? where dateOfwork =? and employeeid=?;";
            PreparedStatement stated = con.prepareStatement(query1);
            stated.setInt(1, out);
            stated.setDate(2, java.sql.Date.valueOf(date));
            stated.setInt(3, rp.getInt(2));

            int rows = stated.executeUpdate();
            System.out.println(rows + "rows are affected ");
        }
        return true;
        // return false;

    }
        public static ArrayList<Report> emailreport(LocalDate dt) throws SQLException
        {
            LocalDate date = dt;
            Connection con = Dbconnection.getconnection();
            String query = "select e.employee_name,a.presentOrNOt,a.OutputPerDay from attendancesheet as a join employeeinfo as e  on e.employee_id = a.employeeid where dateOfWork=?;";
            PreparedStatement pt = con.prepareStatement(query);
            pt.setDate(1, java.sql.Date.valueOf(date));
            ResultSet rs = pt.executeQuery();
            ArrayList <Report> list = new ArrayList<Report>();
            while(rs.next())
            {
                Report e = new Report();
                e.setName(rs.getString(1));
                e.setPresentOrNot(rs.getString(2));
                e.setOutput(rs.getString(3));
                list.add(e);
            }
            return list;
        }

}
