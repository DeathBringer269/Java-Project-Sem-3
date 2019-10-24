/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.controller;

import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Grace
 */
public class Teacher1Controller implements Initializable {

    @FXML
    private JFXDrawer drawer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            VBox x = FXMLLoader.load(getClass().getResource("/Main/fxml/tabledrawerteacher.fxml"));
            System.out.print("here");
            drawer.setSidePane(x);
            /*            if (drawer.isOpened()) {
            drawer.close();
            drawer.setPrefWidth(0);
            } else {*/
            drawer.open();
        } catch (IOException ex) {
            Logger.getLogger(Teacher1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void onViewTables(MouseEvent event) {
        try {
            VBox v = FXMLLoader.load(getClass().getResource("/Main/fxml/tabledrawerteacher.fxml"));
            drawer.setSidePane(v);
            /*            if (drawer.isOpened()) {
            drawer.close();
            drawer.setPrefWidth(0);
            } else {*/
            drawer.open();
            //}
        } catch (IOException ex) {
            Logger.getLogger(Teacher1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void onTest(MouseEvent event) {
        try {
            VBox x = FXMLLoader.load(getClass().getResource("/Main/fxml/test.fxml"));
            System.out.print("here");
            drawer.setSidePane(x);
            /*            if (drawer.isOpened()) {
            drawer.close();
            drawer.setPrefWidth(0);
            } else {*/
            drawer.open();
            //}
        } catch (IOException ex) {
            Logger.getLogger(Teacher1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
