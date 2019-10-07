package Project.controller;

import Project.MainApp;
import static Project.MainApp.stage;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
        try {
            Stage stage = MainApp.stage;
            URL url = getClass().getResource("/Project/fxml/TeacherTable.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(Teacher1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void onSendNotify(MouseEvent event) {

    }
    

}
