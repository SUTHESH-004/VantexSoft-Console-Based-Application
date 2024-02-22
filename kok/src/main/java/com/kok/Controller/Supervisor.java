package com.kok.Controller;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.kok.DBA.AttendanceDBA;
import com.kok.DBA.Employee_infoDBA;
import com.kok.Modal.Attendrep;
import com.kok.Modal.Report;
import com.kok.Modal.employee;
import com.kok.Service.SendMail;
import com.kok.views.*;

public class Supervisor {
    public static void enter(int emp_id,int position) throws SQLException {     
        Supervisorview view = new Supervisorview();
        int choice = 0;
            view.displayMenu();
            try {
                choice = view.getInt();
            } catch (Exception e) {
                view.print("Enter a Valid Input");
                enter(emp_id,position);
                view.print("Ended succesfully");
                System.exit(200);}
            switch(choice)
            {
                //attendance enter
                case 1:{ 
                    boolean a=AttendanceDBA.entryStatus(emp_id,position);
                        if(a==true)
                        {
                            enter(emp_id, position);
                        }
                        else
                        {
                            System.exit(200);
                        }

                    break;}
                    // report view 
                case 2:{
                     Employeeinfoview.displayreport(); 
                    int reportchoice = view.getInt();
                    switch(reportchoice)
                    {
                        case 1:{ 
                        ArrayList<employee>list =Employee_infoDBA.employeedetails();
                        Employeeinfoview.employee_inforeport(list);
                        view.print("Enter you 1 continue and 4 to exit :");
                        int n = view.getInt();
                        view.println("");
                        if(n==1)
                        {
                            enter(emp_id, position);
                            System.exit(200);
                        }
                        else{
                            view.println("Exiting the Vantex software");
                            System.exit(200);
                        }

                        break;}
                        case 2:{
                            System.out.print("Enter a date (yyyy-MM-dd)  : ");
                            String userInput1 =view.getString();
                            System.out.print("Enter a  date (yyyy-MM-dd) :");
                            String userInput2 = view.getString();
                            System.out.println();
                            // DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            LocalDate dt1 = LocalDate.parse(userInput1);
                            LocalDate dt2 = LocalDate.parse(userInput2);
                            // dt2 =dt2.plusDays(1);
                            // System.out.print(dt2.toString());
                            ArrayList<Attendrep>list = AttendanceDBA.TotalReport(dt1.toString(), dt2.toString());

                            Supervisorview.displayAttendancereport(list);
                            // System.out.println("Name    "+"NO_OF_DAYS"+"   PRESENTDAYS"+"Ouput" );
                            // for(int i=0;i<list.size();i++)
                            // {
                            //     System.out.print(list.get(i).getName()+" ");
                            //     System.out.print(list.get(i).getNo_of_days()+"     ");
                            //     System.out.print(list.get(i).getNo_presentdays()+"     ");
                            //     float f = list.get(i).getNo_of_days()/list.get(i).getNo_presentdays();
                            //     f = f*100; 
                            //     System.out.print(f+"%");
                            //     System.out.println("    "+list.get(i).getOutput()+"   ");
                            // }
                            break;
                        }
                        case 3:{
                            System.out.print("Enter a date (yyyy-MM-dd)  : ");
                            String userInput1 =view.getString();
                            System.out.print("Enter a  date (yyyy-MM-dd) :");
                            String userInput2 = view.getString();
                            System.out.println();
                            DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            LocalDate dt1 = LocalDate.parse(userInput1, dateformatter);
                    
                            LocalDate dt2 = LocalDate.parse(userInput2, dateformatter);
                           // dt2 =dt2.plusDays(1);
                            // System.out.print(dt2.toString());
                            ArrayList<Attendrep>list = AttendanceDBA.TotalReport(dateformatter.format(dt1), dateformatter.format(dt2));
                            System.out.println("Name    "+"NO_OF_DAYS"+"   PRESENTDAYS" );
                            for(int i=0;i<list.size();i++)
                            {
                                System.out.print(list.get(i).getName()+" ");
                                // System.out.print(list.get(i).getNo_of_days()+"    ");
                                // System.out.println(list.get(i).getNo_presentdays()+"    ");
                                System.out.println(list.get(i).getOutput()+"   ");
                            }
                            break;
                        }
                        case 4:{
                            System.exit(200);
                        }
                    }
                        break;
                }
                // outputentry
                case 3:{     
                   boolean a = AttendanceDBA.enterOutput(emp_id, position);
                //    ArrayList<emailreport> list = AttendanceDBA.emailreport(dt);
                   if(a)
                   {
                       System.out.println("Do you want to continue enter 1 and 4 to exit");
                       int n = view.getInt();
                       if(n==1)
                       {
                        enter(emp_id, position);
                        SendMail.sendmail("sumithagiri1011@gmail.com","");
                       }
                       else
                       {
                        System.out.println("exiting the document");
                        System.exit(200);
                        }
                       
                   }
                   else
                   {
                    System.out.print("Attendance is not entered");
                    enter(emp_id,position);
                    System.exit(200);
                   }
                   break;
                }
                case 4:{
                    LocalDate dt = LocalDate.now();
                    ArrayList<Report> list = AttendanceDBA.emailreport(dt);
                    String rep ="";
                    for(int i=0;i<list.size();i++)
                    {
                        rep = rep+list.get(i).getName()+" "+list.get(i).getPresentOrNot()+" "+list.get(i).getOutput()+"\n"; 
                    }
                    SendMail.sendmail("sumithagiri1011@gmail.com",rep);
                }

                case 5:{
                    System.out.println("System is exiting");
                    System.exit(200);
                }
                }
                
            }

    }
