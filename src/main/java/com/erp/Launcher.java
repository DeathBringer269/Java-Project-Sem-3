package main.java.com.erp;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.com.erp.controller.service.DBConnect;
import main.java.com.erp.view.ViewFactory;

public class Launcher extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showHomeWindow();
        DBConnect dbConnect = new DBConnect();
        dbConnect.init();
    }
}
