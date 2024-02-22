package com.kok;

import java.sql.SQLException;

import com.kok.Controller.App;
import com.kok.DBA.Dbconnection;
// import com.kok.Service.SendMail;
// import com.kok.DBA.Dbconnection.*;
import com.kok.views.Mainview;

public class Main {
    public static void main(String[] args) throws SQLException {
        Dbconnection.connect();
        Mainview a = new Mainview();
        // SendMail.sendmail("sumithagiri1011@gmail.com", "1234\nSuthesh pravin message\nis coming");
        a.welcomeDisplay();
        App.Start();
    }
}
