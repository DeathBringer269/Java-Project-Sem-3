package Project.controller;

import Project.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Teacher1Controller {

    Stage stage = MainApp.stage;
    
    @FXML
    private MenuItem logout_teacher1;

    @FXML
    void onClicklogout_teacher1(ActionEvent event) {
        HomeController home = new HomeController();
        Scene scene = home.setLoginPage();
        stage.setScene(scene);
        stage.setResizable(false);
    }

}

