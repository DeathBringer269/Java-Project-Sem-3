package com.erp;

import com.erp.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.text.View;

public class Launcher extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        System.out.println("here");
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showHomeWindow();
    }

}
