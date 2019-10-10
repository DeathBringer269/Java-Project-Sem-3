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
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Grace
 */
public class MainApp extends Application {
    
    public static Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
            stage = primaryStage;
            //Setting home scene
            //System.out.println("IN HERE");
            Scene scene = setHomePage();
            //System.out.println("IN HERE");
            stage.setTitle("ERP");
            stage.getIcons().add(new Image("Project/media/college.png"));
            stage.setScene(scene); 
            stage.setResizable(false);
            stage.show();
    }
 
    public static void main(String[] args)  {
        
        launch(args);
    }
    
    public Scene setHomePage(){
        //System.out.println("IN HERE");
        Scene scene = null;
        try {
            URL url = getClass().getResource("fxml/home.fxml");
            Parent root = FXMLLoader.load(url);
            scene = new Scene(root);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scene;
    } 
}
