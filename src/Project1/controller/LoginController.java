/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1.controller;

import Project1.MainApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Grace
 */
public class LoginController {
    
    @FXML
    private AnchorPane root;
    
    @FXML
    private Button teacherbutton;
    
    @FXML
    private Button studentbutton;
    
    @FXML
    private Label errorprompt;
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Button login;
    
    int set;

    public LoginController() {
        this.set = 0;
    }
    
    @FXML
    void onLogin(ActionEvent event) {

            String u = username.getText();
            String p = password.getText();
            /*            Button b = new Button();
            Label l = new Label();
            l.setText(MainApp.s);
            VBox v = new VBox();
            v.getChildren().addAll(b,l);
            Scene scene = new Scene(v,500,500);
            Stage stage = MainApp.stage;
            stage.setScene(scene);*/
            if(u.isEmpty()){
                errorprompt.setTextFill(Color.web("#ff0000"));
                errorprompt.setText("Username cannot be empty");
            }else if(p.isEmpty()) {
                errorprompt.setTextFill(Color.web("#ff0000"));
                errorprompt.setText("Password cannot be empty");
            }else {
                if(set == 0) {
                    setSceneTeacher();
                }
                else {
                    setSceneStudent();
                }
            }
    }
    
    
    void setSceneTeacher() {
        try {
            Stage stage = MainApp.stage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("fxml/teacher1.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Teacher Home Page");
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void setSceneStudent() {
        
        System.out.print("Entered method setSceneStudent");
        try {
            Stage stage = MainApp.stage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("fxml/student1.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Student Home Page");
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    void onSetStudent(ActionEvent event) {
        this.set = 1;
        System.out.println(set);
    }

    @FXML
    void onSetTeacher(ActionEvent event) {
        this.set = 0;
    }
}


