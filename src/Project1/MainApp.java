/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Grace
 */
public class MainApp extends Application {
    
    public static Stage stage;
    private AnchorPane rootLayout;
    public static String s;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            s = "Hello";
            
            //FXMLLoader loader = new FXMLLoader();
           // loader.setLocation(MainApp.class.getResource("fxml/login.fxml"));
            //rootLayout = (AnchorPane) loader.load();
            URL url = getClass().getResource("fxml/login.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("ERP");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.print(e);
        }
    }
    
    public static void main(String args[]) {
        launch(args);
    }
}
