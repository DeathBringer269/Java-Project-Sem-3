package Project.controller;

import Project.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeacherTableController {

    @FXML
    private Button toback;
    
    @FXML
    private VBox labelbox;

    Label label[] = null;

    public TeacherTableController() {
        for(int i =0;i<5;i++){
            Label label[i] = new Label();
            label[i].setText("Label " + i);
            labelbox.getChildren().add(label[i]);
        }
       System.out.println("Entered the constructer");
    }

    @FXML
    void onBackClicked(MouseEvent event) {
        try {
            Stage stage = MainApp.stage;
            URL url = getClass().getResource("/Project/fxml/teacher1.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);   
            stage.setScene(scene);
            stage.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void onEditClicked(MouseEvent event) {

    }

    @FXML
    void onLogoutClicked(MouseEvent event) {

    }

}
