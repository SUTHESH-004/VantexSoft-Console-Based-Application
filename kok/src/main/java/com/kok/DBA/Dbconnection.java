package com.kok.DBA;

import java.sql.*;

public class Dbconnection {
    private static String url = "jdbc:mysql://localhost:3306/vantexemployee";
    private static String username = "root";
    private static String pass = "Suthesh123s";
    private static Connection con;
    private Dbconnection() {
        try {
            // System.out.println("Hello");
            con = DriverManager.getConnection(url, username, pass);
            // System.out.println("Db Connected");
        } catch (SQLException se) {
            se.fillInStackTrace();
        }
    }

    public static void connect() {
         new Dbconnection();
    }

    public static Connection getconnection() {

        return Dbconnection.con;
    }

    // public static Connection getconnection() throws SQLException{
    // Connection con = DriverManager.getConnection(url,username,pass);
    // return con;
    //
}
// SINGleton design pattern