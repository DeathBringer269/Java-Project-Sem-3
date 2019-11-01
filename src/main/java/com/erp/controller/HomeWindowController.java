package main.java.com.erp.controller;

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.application.HostServices;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.com.erp.view.ViewFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeWindowController extends BaseController implements Initializable {

    @FXML
    private Button signInButton;

    @FXML
    private Label alan;

    @FXML
    private Label sujoy;

    @FXML
    private Label mark;

    public HomeWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        alan.setTextFill(Color.BLUE);
        sujoy.setTextFill(Color.BLUE);
        mark.setTextFill(Color.BLUE);
    }

    @FXML
    void onSignInAction( ) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("");
//        alert.showAndWait();
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
        Stage stage = (Stage) signInButton.getScene().getWindow();
        viewFactory.closeStage(stage);
        return;
    }


    @FXML
    void onClicked(MouseEvent event) {
        if(event.getSource() == alan) {
            showInBrowser(GithubAccounts.alan);
        } else if(event.getSource() == sujoy) {
            showInBrowser(GithubAccounts.sujoy);
        } else if(event.getSource() == mark) {
            showInBrowser(GithubAccounts.mark);
        }
    }

    public void showInBrowser(String url) {
        try {
            URI uri = new URI(url);
            java.awt.Desktop.getDesktop().browse(uri);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onMouseEntered(MouseEvent event) {
        if(event.getSource() == alan) {
            alan.setTextFill(Color.BLUE);
            alan.setStyle("-fx-underline: true");
        } else if(event.getSource() == sujoy) {
            sujoy.setTextFill(Color.BLUE);
            sujoy.setStyle("-fx-underline: true");
        } else if(event.getSource() == mark) {
            mark.setTextFill(Color.BLUE);
            mark.setStyle("-fx-underline: true");
        }
    }

    @FXML
    void onMouseExited(MouseEvent event) {
        if(event.getSource() == alan) {
            alan.setTextFill(Color.BLUE);
            alan.setStyle("-fx-underline: false");
        } else if(event.getSource() == sujoy) {
            sujoy.setTextFill(Color.BLUE);
            sujoy.setStyle("-fx-underline: false");
        } else if(event.getSource() == mark) {
            mark.setTextFill(Color.BLUE);
            mark.setStyle("-fx-underline: false");
        }
    }

}
