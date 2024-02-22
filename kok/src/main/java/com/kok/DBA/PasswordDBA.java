package com.kok.DBA;

// import com.kok.Controller.App;
import com.kok.Modal.*;
import java.sql.*;

// import javax.swing.text.StyledEditorKit.BoldAction;

public class PasswordDBA {
    public boolean passwordverfication(IdPass idPass){
            try{Connection con = Dbconnection.getconnection();
            String query = "select pass from passwordlist where employee_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idPass.emp_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
                if (rs.getString(1).equals(idPass.password)) {
                    return true;
                } else {
                    return false;
                }
            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    return false;
                }
    }
}
