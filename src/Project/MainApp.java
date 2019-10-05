/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Grace
 */
public class MainApp extends Application {
    
    public static Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            //Setting home scene
            URL url = getClass().getResource("fxml/home.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            
            stage.setTitle("ERP");
            stage.setScene(scene); 
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
}
