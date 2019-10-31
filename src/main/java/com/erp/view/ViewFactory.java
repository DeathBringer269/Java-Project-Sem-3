package main.java.com.erp.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.erp.controller.BaseController;
import main.java.com.erp.controller.HomeWindowController;
import main.java.com.erp.controller.LoginWindowController;
import main.java.com.erp.controller.TeacherHomeController;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    public void showHomeWindow() {
        BaseController controller = new HomeWindowController(this, "HomeWindow.fxml");
        initializeStage(controller);
    }

    public void showLoginWindow() {
        BaseController controller = new LoginWindowController(this, "LoginWindow.fxml");
        initializeStage(controller);
    }

    public void showTeacherHome() {
        BaseController controller = new TeacherHomeController(this, "TeacherHome.fxml");
        initializeStage(controller);
    }

    private void initializeStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
    }
}
