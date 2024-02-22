package com.kok.views;

import java.util.ArrayList;

// import com.kok.DBA.Employee_infoDBA;
import com.kok.Modal.employee;

public class Employeeinfoview {
    public static void displayreport() {
        System.out.print("1 . Display Employee Details");
        System.out.print("2 . Attendance details");
        System.out.print("3 . Output details");
    }
    // public static void employee_inforeport(ArrayList<employee> list)
    // {
    // System.out.println(
    // "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
    // System.out.printf("║ %-15s ║ %-12s ║ %-15s ║ %-15s ║ %-15s ║ %-15s ║%n",
    // "Id","Name", "DateOfBirth", "City", "State", "Country", "MoblieNumber");
    // System.out.println(
    // "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
    // for(int i=0;i<list.size();i++)
    // {
    // System.out.printf("║ %-15s ║ %-12s ║ %-15s ║ %-15s ║ %-15s ║ %-15s
    // ║%n",list.get(i).getid(),list.get(i).getname(),list.get(i).getdob(),list.get(i).getcity(),list.get(i).getstate(),list.get(i).getcountry(),list.get(i).getrelieveddate(),list.get(i).getAddress());
    // }
    // }

    public static void employee_inforeport(ArrayList<employee> list) {
        System.out.println(
                "╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-10s ║ %-15s ║ %-15s ║ %-15s ║ %-15s ║ %-15s ║ %-15s ║%n",
                "Id", "Name", "DateOfBirth", "City", "State", "Country", "MobileNumber");
        System.out.println(
                "╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("║ %-10s ║ %-15s ║ %-15s ║ %-15s ║ %-15s ║ %-15s ║ %-15s ║%n", list.get(i).getid(),
                    list.get(i).getname(),
                    list.get(i).getdob(), list.get(i).getcity(),
                    list.get(i).getstate(), list.get(i).getcountry(), list.get(i).getMobileNumber());
            if (i == list.size()-1) {
            System.out.println(
            "╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");continue;
            }
            System.out.println(
                    "╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
        }

    }
}
