package Project.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ErrorDialog {

    static Stage stage;
    
    public static void showDialog(String message,String title) {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Label messagelabel = new Label();
        messagelabel.setTextFill(Color.web("#ff0000"));
        messagelabel.setText(message);
        Label label = new Label();
        label.setText("Database: java_project\nUsername: default\nPassword: default");
        Button button = new Button();
        button.setText("OK");
        button.setOnAction(e -> onClick());
        VBox v = new VBox(20);
        v.getChildren().addAll(messagelabel,label,button);
        v.setAlignment(Pos.CENTER);
        Scene scene = new Scene(v);
        stage.setScene(scene);
        stage.setMinWidth(200);
        stage.setMinHeight(200);
        stage.setMaxWidth(1000);
        stage.setMaxHeight(1000);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.getIcons().add(new Image("/Project/media/warning.png"));
        stage.showAndWait();
    }
    
    static void onClick() {
        stage.close();
    }
}
