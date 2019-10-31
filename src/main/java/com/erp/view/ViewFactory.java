package main.java.com.erp.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.com.erp.controller.*;

import java.io.IOException;

public class ViewFactory {

    public void showHomeWindow() {
        BaseController controller = new HomeWindowController(this, "HomeWindow.fxml");
        initializeStage(controller,"Home", false);
    }

    public void showLoginWindow() {
        BaseController controller = new LoginWindowController(this, "LoginWindow.fxml");
        initializeStage(controller, "Login", false);
    }

    public void showTeacherHomeWindow() {
        BaseController controller = new TeacherHomeWindowController(this, "TeacherHomeWindow.fxml");
        initializeStage(controller, "Home", false);
    }

    public void showTableViewWindow() {
        BaseController controller = new TableViewWindowController(this, "TableViewWindow.fxml");
        initializeStage(controller, "Tables", false);
    }

    public void showOptionsWindow() {
        BaseController controller = new OptionsWindowController(this, "OptionsWindow.fxml");
        initializeStage(controller, "Options",false, true);
    }

    public void showServerOptionsWindow() {
        BaseController controller = new ServerOptionsWindowController(this, "ServerOptionsWindow.fxml");
        initializeStage(controller, "Server Options", false, true);
    }

    private void initializeStage(BaseController controller, String title, Boolean resizable) {
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
        stage.setTitle(title);
        stage.getIcons().add(new Image(ViewFactory.class.getResourceAsStream("media/college.png")));
        stage.show();
        if(!resizable) {
            stage.setResizable(false);
        }
    }

    private void initializeStage(BaseController controller, String title, Boolean resizable, Boolean modality) {
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
        stage.setTitle(title);
        stage.getIcons().add(new Image(ViewFactory.class.getResourceAsStream("media/college.png")));
        if(modality) {
            stage.initModality(Modality.APPLICATION_MODAL);
        }
        stage.show();
        if(!resizable) {
            stage.setResizable(false);
        }
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
    }

}
