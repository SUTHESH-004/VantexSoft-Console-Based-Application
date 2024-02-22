package com.kok.views;

import java.time.LocalDate;
// import java.util.ArrayList;

import com.kok.Modal.employee;

public class Managerview extends Scan {
        public void displayMenu() {
            System.out.println("Welcome! Press the numbers to indicate what you want to do:");
            System.out.println("1. Enter Attendance");
            System.out.println("2. View Reports");
            System.out.println("3. Output Entry");
            System.out.println("4.Send Todays report");
            System.out.println("5.Edit Employee details");
            System.out.println("6. Exit");
        }
        public void addemployeeMenu()
        {
            System.out.println("1 . Add a employee");
        }
        public void welcomeManger() {
            // System.out.print("\033[H\033[2J");
            System.out.println(" ╔══════════════════════════════════════════╗ ");
            System.out.println(" ║                                          ║ ");
            System.out.println(" ║      WELCOME MANAGER TO  VANTEX SOFT     ║ ");
            System.out.println(" ║            EMPLOYEE DATABASE             ║ ");
            System.out.println(" ║                                          ║ ");
            System.out.println(" ╚══════════════════════════════════════════╝ ");
        }
        public int getInt() {
            int s = sc.nextInt();
            return s;
        }
    
        public void print(String string) {
            System.out.print(string);
        }
    
        public void println(String s) {
            System.out.println(s);
        }
    
        public String getString() {
            String s = sc.next();
            return s;
        }
        public employee addemployeedetails()
        {
            employee emp  = new employee();
            System.out.println("Enter the employee id");
            emp.setid(getInt());
            System.out.println("Enter the employee name");
            emp.setname(getString());
            System.out.println("Enter the employee date of birth");
            emp.setdob(getString());    
            System.out.println("Enter the city");
            emp.setdob(getString());
            System.out.println("Enter the employee state");
            emp.setstate(getString());
            System.out.println("Enter the employee country");
            emp.setcountry(getString());
            System.out.println("Enter the employee mobile number");
            emp.setmobilenumber(getString());
            LocalDate l = LocalDate.now();
            emp.setjoineddate(l.toString());
            System.out.println("Enter the employee address");
            emp.setaddress(getString());
            System.out.println("Enter the posts M for manager S for superisor E for employee");
            emp.setpostid(getString());
            return emp;

        }

    }
