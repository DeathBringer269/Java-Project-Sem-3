/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alan;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Grace
 */
public class Main extends Application {
    
    public static Stage stage;
    private AnchorPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            stage = primaryStage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("fxml/login.fxml"));
            rootLayout = (AnchorPane) loader.load();

            Scene scene = new Scene(rootLayout);
            stage.setTitle("ERP");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        launch(args);
    }
}
