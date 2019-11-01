package main.java.com.erp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.java.com.erp.controller.service.ServerProperties;
import main.java.com.erp.model.ServerDetails;
import main.java.com.erp.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class AuthenticateAdminWindowController extends BaseController implements Initializable {

    protected static boolean adminRights = false;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public AuthenticateAdminWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void onAuthenticate(ActionEvent event) {
        verify();
    }

    @FXML
    void onAuthenticateKey(KeyEvent event) {
        String type = event.getEventType().getName();
        KeyCode keyCode = event.getCode();
        System.out.println(type + ": Key Code=" + keyCode.getName() +
                ", Text=" + event.getText()+"\n");
        if(event.getCode() == KeyCode.ENTER) {
            //System.out.println("OK");
            verify();
        }
    }

    private void verify() {
        if(usernameField.getText().isEmpty()) {
            errorLabel.setText("Username cannot be empty!");
        } else if(passwordField.getText().isEmpty()) {
            errorLabel.setText("Password cannot be empty");
        } else {
            errorLabel.setText("");
            for (Admin admin : Admin.values()) {
                if(admin.toString().equals(usernameField.getText()) && admin.toString().equals(passwordField.getText())) {
                    System.out.println("Authenticated as " + admin);
                    errorLabel.setText("");
                    adminRights = true;
                    ViewFactory viewFactory = new ViewFactory();
                    ServerDetails serverDetails = new ServerDetails(new ServerProperties());
                    viewFactory.showServerOptionsWindow(serverDetails);
                    onCancel();
                    break;
                } else {
                    System.out.println("Not Authenticated");
                    errorLabel.setText("Unable to verify identity! Check again!");
                    adminRights = false;
                }
            }
        }
    }

    @FXML
    void onCancel( ) {
        ViewFactory viewFactory = new ViewFactory();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

}
