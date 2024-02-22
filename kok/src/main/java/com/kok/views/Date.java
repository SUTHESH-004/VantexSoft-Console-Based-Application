package com.kok.views;
import java.time.LocalDate;
import java.time.LocalTime;
// import java.util.*;

public class Date {
    {
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        // System.out.print("\033[H\033[2J");
        // for clearing the window for cleaner output1
        System.out.println("THE CURRENT DATE IS =" + date);
        System.out.println("THE CURRENT TIME IS =" + time);
    }
}
