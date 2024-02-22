package com.kok.views;

import java.util.ArrayList;
import com.kok.Modal.Attendrep;

public class Supervisorview extends Scan {
    public void displayMenu() {
        System.out.println("Welcome! Press the numbers to indicate what you want to do:");
        System.out.println("1. Enter Attendance");
        System.out.println("2. View Reports");
        System.out.println("3. Output Entry");
        System.out.println("4.Send Todays report");
        System.out.println("5. Exit");
    }

    public void welcomeSupervisor() {
        // System.out.print("\033[H\033[2J");
        System.out.println(" ╔══════════════════════════════════════════╗ ");
        System.out.println(" ║                                          ║ ");
        System.out.println(" ║      WELCOME SUPERVISOR TO VANTEX SOFT   ║ ");
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

    public static void displayAttendancereport(ArrayList<Attendrep> list) {
        System.out.println(
                "╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-10s ║ %-15s ║ %-15s ║ %-15s ║%n",
                "Name", "No_Of_Days", "No_of_PresentDays", "Persentage");
        System.out.println(
                "╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("║ %-10s ║ %-15s ║ %-15s ║ %-15s║%n", list.get(i).getName(),
                    list.get(i).getNo_of_days(), list.get(i).getNo_presentdays(),
                    list.get(i).getNo_presentdays(), list.get(i).getOutput());
            if (i == list.size() - 1) {
                System.out.println(
                        "╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                continue;
            }
            System.out.println(
                    "╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");

        }
    }
}