package com.erp.controller;

import com.erp.Connect;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private JFXButton BackToLogin;

    @FXML
    private JFXButton Teacher;

    @FXML
    private JFXButton Student;

    @FXML
    private JFXTextField Username;

    @FXML
    private JFXPasswordField Password;

    @FXML
    private JFXButton Next;

    @FXML
    private Label error;

    private int set = 1;

    private int flag;
    
    public void initialize(URL url, ResourceBundle rb) {
        set = 1;
        Teacher.setStyle("-fx-background-color : #0C39FF ;\n"
                + "-fx-text-fill: #FFF;");      
    }  

    @FXML
    void onBackToLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/erp/view/home.fxml"));
            Scene scene = BackToLogin.getScene();
            root.translateXProperty().set(scene.getWidth());
            StackPane stackpane = (StackPane) scene.getRoot();
            stackpane.getChildren().add(root);
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void onNext(ActionEvent event) {
        String username = "Username";
        String password = "Password";
        String data = null;
        Boolean status = Connect.init();
        if (status) {
            error.setText("Connection established");
            error.setStyle("-fx-text-fill: green");
        } else {
            error.setText("Could not establish connection");
            error.setStyle("-fx-text-fill: red");
        }
        if (Username.getText().isEmpty()) {
            error.setText("Username cannot be empty");
            error.setStyle("-fx-text-fill: red");
        } else if (Password.getText().isEmpty()) {
            error.setText("Password cannot be empty");
            error.setStyle("-fx-text-fill: red");
        } else {
            String usr = Username.getText();
            String pass = Password.getText();
            try {
                String table = null;
                Connection conn = Connect.getConnection();
                Statement statement = conn.createStatement();
                if(set == 1) {
                    data = "teacherlogindata";
                } else {
                    data = "studentlogindata";
                }
                statement.executeQuery("SELECT * FROM " + data);
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    String u = rs.getString(username);
                    String p = rs.getString(password);
                    if (usr.equals(u) && pass.equals(p)) {
                        error.setText("Logged in");
                        error.setStyle("-fx-text-fill: green");
                        flag = 1;
                        break;
                    } else {
                        error.setText("No such username or password.Check again");
                        error.setStyle("-fx-text-fill: red");
                        flag = 0;
                    }
                }

                if (flag == 1 && set == 1) {
                    //switch to teacher
                    Parent root = FXMLLoader.load(getClass().getResource("/com/erp/view/teacher1.fxml"));
                    Scene scene = BackToLogin.getScene();
                    root.translateYProperty().set(scene.getHeight());
                    StackPane stackpane = (StackPane) scene.getRoot();
                    stackpane.getChildren().add(root);
                    Timeline timeline = new Timeline();
                    KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
                    KeyFrame kf = new KeyFrame(Duration.seconds(0.4),kv);
                    timeline.getKeyFrames().add(kf);
                    timeline.play();
                    timeline.setOnFinished(Event -> {
                        stackpane.getChildren().remove(anchorpane);
                    });
                } else if(flag == 1 && set == 0) {
                    //switch to student
                }
            } catch (Exception e) {
            }
        }
    }


@FXML
    void onSetStudent(ActionEvent event) {
        set = 0;
        Student.setStyle("-fx-background-color : #0C39FF ;\n"
                + "-fx-text-fill: #FFF;");
        Teacher.setStyle("-fx-background-color : #FFF;\n"
                + "-fx-text-fill: #0C3988;");
    }

    @FXML
    void onSetTeacher(ActionEvent event) {
        set = 1;
        Teacher.setStyle("-fx-background-color : #0C39FF ;\n"
                + "-fx-text-fill: #FFF;");
        Student.setStyle("-fx-background-color : #FFF ;\n"
                + "-fx-text-fill: #0C39FF;");
    }

}
