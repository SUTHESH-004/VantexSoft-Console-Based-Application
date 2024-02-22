package com.kok.Controller;

// import java.sql.SQLException;

import com.kok.DBA.*;
import com.kok.Modal.IdPass;
import com.kok.views.*;

public class App {
    public static void Start(){
        try{
        Mainview a = new Mainview();
        IdPass idpass = a.passwordisplay();
        PostsDBA postsDBA = new PostsDBA();
        PasswordDBA passwordDBA = new PasswordDBA();

        // i have checked the password is correct or not if not loop
        boolean dir = passwordDBA.passwordverfication(idpass);
        if (dir ==false) {
            System.out.println("Your password is incorrect ");
            Start();
            System.exit(200);
        } 
        else {
            int position = postsDBA.positionChecker(idpass.emp_id);
            if (position == 2) {
                Supervisorview view = new Supervisorview();
                view.welcomeSupervisor();
                Supervisor.enter(idpass.emp_id, position);
            }
            if(position ==3)
            {
                Managerview view = new Managerview();
                view.welcomeManger();
                Manager.enter(idpass.emp_id, position);

            }

        }
    }
    catch(Exception e){
        e.printStackTrace();
        Start();
    }
}
}

