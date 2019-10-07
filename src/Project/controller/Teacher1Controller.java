package Project.controller;

import static Project.MainApp.stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;

public class Teacher1Controller {

    @FXML
    private SplitMenuButton viewSpreadSheets;

    @FXML
    private MenuItem viewStudentData;

    @FXML
    private MenuItem viewMarksheet;

    @FXML
    private Button sendnotifybutton;

    @FXML
    private MenuItem logout_teacher1;

    @FXML
    void onClick(ActionEvent event) {

    }

    @FXML
    void onClick2(ActionEvent event) {

    }

    @FXML
    void onClicklogout_teacher1(ActionEvent event) {
        HomeController home = new HomeController();
        Scene scene = home.setLoginPage();
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @FXML
    void onClickmenu1(MouseEvent event) {

    }

    @FXML
    void onSendNotify(MouseEvent event) {

    }

}
