package main.java.com.erp.controller.erp.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class HomeController {

    @FXML
    private JFXButton SignInHome;
    
    @FXML
    private StackPane stackpane;
    
    @FXML
    private ScrollPane scrollpane;
    

    @FXML
    void onSignInHome(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/erp/view/login.fxml"));
            Scene scene = SignInHome.getScene();
            root.translateYProperty().set(scene.getHeight());
            stackpane.getChildren().add(root);
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.4),kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
            timeline.setOnFinished( Event -> {
                stackpane.getChildren().remove(scrollpane);
            });
            } catch (IOException ex) {
            System.out.println("Here");
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
