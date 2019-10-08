package Project.controller;

import Project.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TeacherTableController {

    @FXML
    private Button toback;
    
    @FXML
    private GridPane gridpane;

    Label label[] = null;

    public TeacherTableController() {
        ArrayList<Label> label = new ArrayList();
        for(int i =0;i<3;i++){
                gridpane.add(label.get(i),0,i);
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
