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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TeacherTableController {
    
    Stage stage = MainApp.stage;

    @FXML
    private Button displaybutton1;

    @FXML
    private Button toback;

    @FXML
    private TabPane tabpane;

    @FXML
    private TableView<?> tableview;

    @FXML
    void onBackClicked(MouseEvent event) {
        try {
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
    void onClickButton1(MouseEvent event) {
        Tab tab = new Tab();
        tab.setText("Marksheet1");
        tab.setClosable(true);
        tabpane.getTabs().add(tab);
        
        //displaying table
        
    }
    
    class TableData {
        
    }

    @FXML
    void onEditClicked(MouseEvent event) {

    }

    @FXML
    void onLogoutClicked(MouseEvent event) {
        HomeController home = new HomeController();
        Scene scene = home.setLoginPage();
        stage.setScene(scene);
        stage.setResizable(false);
    }

}

