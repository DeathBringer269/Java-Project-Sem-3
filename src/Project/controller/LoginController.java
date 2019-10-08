package Project.controller;

import Project.connect.Connect;
import Project.MainApp;
import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {
    
    Stage stage = MainApp.stage;
    
    public static String logged_username;
    
    public static String logged_password;

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
    
    @FXML
    private CheckBox remember;    
    
    //1 indicates that teacher is selected
    int set = 1;

    @FXML
    void onClick(MouseEvent event) throws SQLException {

        
        int flag_check =0;
        
        Statement stmt = null;
        
        ResultSet rs = null;
        
        Connection conn = null;
        
        String u = null;
        
        String p = null;
        
        String Username = "Username";
        
        String Password = "Password";
        
        if(onChecked()) {
            try {
                rememberMe();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
        if(username.getText().isEmpty()){
            fielderrorlabel.setText("Username cannot be empty!");
        }
        else if(password.getText().isEmpty()) {
            fielderrorlabel.setText("Password cannot be empty!");
        }
        else {
            //checking crendentials for teacher
            if(set == 1) {
                //System.out.println("IN HERE");
                String usr = username.getText();
                String pas = password.getText();
                try {
                    //System.out.println("IN HERE");
                    conn = Connect.getConnection();
                    stmt = conn.createStatement();
                    stmt.executeQuery("SELECT * FROM teacherlogindata" );
                    rs = stmt.getResultSet();
                    while(rs.next()) {
                        u = rs.getString(Username);
                        p = rs.getString(Password);
                        if(usr.equals(u) && pas.equals(p)) {
                            System.out.println("Logged in");
                            flag_check =1;
                            break;
                        }
                    }
                    if(flag_check != 1) {
                        fielderrorlabel.setText("Enter a valid username or password!");
                    }
                    else {
                        logged_username = usr;
                        logged_password = usr;
                        Scene scene = SwitchToTeacher1();
                        stage.setScene(scene);
                        stage.setTitle("Teacher");
                        stage.setResizable(false);                       
                    }
                } catch (SQLException e) {
                    System.out.print(e);
                } 
            }
            else {
                //check credentials for student
                //switch to APPROPRIATE student scene
                String usr = username.getText();
                String pas = password.getText();
                try {
                    conn = Connect.getConnection();
                    stmt = conn.createStatement();
                    stmt.executeQuery("SELECT * FROM studentlogindata" );
                    rs = stmt.getResultSet();
                    while(rs.next()) {
                        u = rs.getString(Username);
                        p = rs.getString(Password);
                        if(usr.equals(u) && pas.equals(p)) {
                            System.out.println("Logged in");
                            flag_check = 1;
                            break;
                        }
                    }
                    if(flag_check != 1) {
                        fielderrorlabel.setText("Enter a valid username or password!");                        
                    }
                    else {
                        logged_username = usr;
                        logged_password = usr;                        
                        Scene scene = SwitchToStudent1();
                        stage.setScene(scene);
                        stage.setTitle("Student");
                        stage.setResizable(false);
                    }
                } catch (SQLException e) {
                    System.out.print(e);
                }
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
            int flag_check =0;

            Statement stmt = null;

            ResultSet rs = null;

            Connection conn = null;

            String u = null;

            String p = null;

            String Username = "Username";

            String Password = "Password";    
            
            
            if(username.getText().isEmpty()){
                  fielderrorlabel.setText("Username cannot be empty!");
              }
              else if(password.getText().isEmpty()) {
                  fielderrorlabel.setText("Password cannot be empty!");
              }
              else {
                  //checking crendentials for teacher
                  if(set == 1) {
                      String usr = username.getText();
                      String pas = password.getText();
                      try {
                          conn = Connect.getConnection();
                          stmt = conn.createStatement();
                          stmt.executeQuery("SELECT * FROM teacherlogindata" );
                          rs = stmt.getResultSet();
                          while(rs.next()) {
                              u = rs.getString(Username);
                              p = rs.getString(Password);
                              if(usr.equals(u) && pas.equals(p)) {
                                  System.out.println("Logged in");
                                  flag_check = 1;
                                  break;
                              }
                          }
                          if(flag_check != 1) {
                              fielderrorlabel.setText("Enter a valid username or password!");
                          }
                          else {
                                logged_username = usr;
                                logged_password = usr;                              
                                Scene scene = SwitchToTeacher1();
                                stage.setScene(scene);
                                stage.setTitle("Teacher");
                                stage.setResizable(false);                       
                          }
                      } catch (SQLException e) {
                          System.out.println("IN HERE");
                          System.out.print(e);
                      } 
                  }
                  else {
                      //check credentials for student
                      //switch to APPROPRIATE student scene
                      String usr = username.getText();
                      String pas = password.getText();
                      try {
                          conn = Connect.getConnection();
                          stmt = conn.createStatement();
                          stmt.executeQuery("SELECT * FROM studentlogindata" );
                          rs = stmt.getResultSet();
                          while(rs.next()) {
                              u = rs.getString(Username);
                              p = rs.getString(Password);
                              if(usr.equals(u) && pas.equals(p)) {
                                  System.out.println("Logged in");
                                  flag_check = 1;
                                  break;
                              }
                          }
                          if(flag_check != 1) {
                              fielderrorlabel.setText("Enter a valid username or password!");                        
                          }
                          else {
                                logged_username = usr;
                                logged_password = usr;   
                                Scene scene = SwitchToStudent1();
                                stage.setScene(scene);
                                stage.setTitle("Student");
                                stage.setResizable(false);
                          }
                      } catch (SQLException e) {
                          System.out.print(e);
                      }
                  }
              }
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
            //System.out.println("IN HERE");
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
    
    @FXML
    boolean onChecked() {
        if(remember.isSelected()) {
            System.out.println("OK");
            return true;
        } else {
            System.out.println("NOT OK");
            return false;
        }
    }
    
    void rememberMe() throws IOException {
        File file = new File("/Project/user.txt");
        if(file.exists()) {
            
        } else {
            if(file.createNewFile()) {
                FileWriter myfile = new FileWriter("/Project/user.txt");
                myfile.write(username.getText() + "\n" + password.getText());
            } else {
                System.out.println("Unable to save credentials");
            }
        }
    }
}
