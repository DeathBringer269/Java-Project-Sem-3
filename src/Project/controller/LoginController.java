package Project.controller;

import Project.connect.Connect;
import Project.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {
    
    Stage stage = MainApp.stage;

    @FXML
    private Label fielderrorlabel;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button signinbutton;

    @FXML
    private Button backtohome;

    @FXML
    private Button teacherbutton;

    @FXML
    private Button studentbutton;
    
    //1 indicates that teacher is selected
    int set = 1;

    @FXML
    void onClick(MouseEvent event) {
        //switch scene
        int flag_check =0;
         Statement stmt = null;
        ResultSet rs = null;
       Connection con = null;
       String u = null;
        String p = null;
         String id = "ID";
        String pasw = "Password";
        if(username.getText().isEmpty()){
            fielderrorlabel.setText("Username cannot be empty!");
        }
        else if(password.getText().isEmpty()) {
            fielderrorlabel.setText("Password cannot be empty!");
        }
        else {
            fielderrorlabel.setText("");
            //connect to database
            if(set == 1) {
                String usr = username.getText();
                String pas = password.getText();
                try {
            con = Connect.getConnection();
            stmt = con.createStatement();
            stmt.executeQuery("SELECT * FROM teacher" );
 
            rs = stmt.getResultSet();
            while(rs.next()) {
               
                u = rs.getString(id);
                p = rs.getString(pasw);
                if(usr.equals(u)) {
                    System.out.println("Logged in");
                    flag_check =1;
                    break;
                }
                
            }
            if(flag_check != 1) {
                //Add a Popup Wrong username or password 
            }
            
            
        } catch (SQLException e) {
            System.out.print(e);
        }
                
                
                
                
                //check credentials
                //switch to teacher scene
                Scene scene = SwitchToTeacher1();
                stage.setScene(scene);
                stage.setTitle("Teacher");
                stage.setResizable(false);
            }
            else {
                //check credentials
                //switch to APPROPRIATE student scene
                String usr = username.getText();
                String pas = password.getText();
                try {
            con = Connect.getConnection();
            stmt = con.createStatement();
            stmt.executeQuery("SELECT * FROM student" );
 
            rs = stmt.getResultSet();
            while(rs.next()) {
               
                u = rs.getString(id);
                p = rs.getString(pasw);
                if(usr.equals(u)) {
                    System.out.println("Logged in");
                    flag_check =1;
                    break;
                }
                
            }
            if(flag_check != 1) {
                //Add a Popup Wrong username or password 
            }
            
            
        } catch (SQLException e) {
            System.out.print(e);
        }
                
                
                
                
                
                Scene scene = SwitchToStudent1();
                stage.setScene(scene);
                stage.setTitle("Student");
                stage.setResizable(false);
            }
        }
    }

    @FXML
    void onKeyPress(KeyEvent event) {
        
        //Testing for keyevent !!DO NOT REMOVE
        /*        String type = event.getEventType().getName();
        
        // Get the KeyCode of the Event
        KeyCode keyCode = event.getCode();
        
        // Log the Information
        System.out.println(type + ": Key Code=" + keyCode.getName() +
        ", Text=" + event.getText()+"\n");*/
         
        if(event.getCode() == KeyCode.ENTER) {
            //switch scene
        }
    }
    
    @FXML
    void onClicktoBack(MouseEvent event) {
        MainApp mainapp = new MainApp();
        Scene scene = mainapp.setHomePage();
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @FXML
    void onSetStudent(MouseEvent event) {
        //setting default to student
        studentbutton.setDefaultButton(true);
        teacherbutton.setDefaultButton(false);
        set = 0;
    }

    @FXML
    void onSetTeacher(MouseEvent event) {
        //setting default to teacher
        teacherbutton.setDefaultButton(true);
        studentbutton.setDefaultButton(false);
        set = 1;
    }    
    
    
    Scene SwitchToTeacher1() {
        Scene scene = null;
        try {
            URL url = getClass().getResource("/Project/fxml/teacher1.fxml");
            Parent root = FXMLLoader.load(url);
            scene = new Scene(root);   
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scene;
    }
    
    Scene SwitchToStudent1() {
        Scene scene = null;
        try {
            URL url = getClass().getResource("/Project/fxml/student1.fxml");
            Parent root = FXMLLoader.load(url);
            scene = new Scene(root);   
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scene;
    }
}
