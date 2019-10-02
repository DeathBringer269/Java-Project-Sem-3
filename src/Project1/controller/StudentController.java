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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StudentController {

    @FXML
    private AnchorPane root;

    @FXML
    private Label name;

    @FXML
    private Label id;

    @FXML
    private Button logout;

    @FXML
    void onLogout(ActionEvent event) {  
 
            try {
                Stage stage = MainApp.stage;
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("fxml/login.fxml"));
                root = (AnchorPane) loader.load();
                Scene scene = new Scene(root);
                stage.setTitle("Login Page");
                stage.setScene(scene);
            } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

}