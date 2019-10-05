package Project.controller;

import Project.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {
    
    Stage stage = MainApp.stage;

    @FXML
    private Button signinbutton_home;

    @FXML
    void onClick(ActionEvent event) {
            //set login scene
            Scene scene = setLoginPage();
            stage.setScene(scene);
            stage.setResizable(false);
    }
    
    public Scene setLoginPage() {
        Scene scene = null;
        try {
            URL url = getClass().getResource("/Project/fxml/login.fxml");
            Parent root = FXMLLoader.load(url);
            scene = new Scene(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scene;
    }

}
