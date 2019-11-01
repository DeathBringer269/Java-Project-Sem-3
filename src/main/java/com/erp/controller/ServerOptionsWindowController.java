package main.java.com.erp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.com.erp.controller.service.DBConnect;
import main.java.com.erp.controller.service.ServerProperties;
import main.java.com.erp.model.ServerDetails;
import main.java.com.erp.view.ViewFactory;

import javax.swing.text.View;
import java.net.URL;
import java.rmi.ServerError;
import java.util.ResourceBundle;

public class ServerOptionsWindowController extends BaseController implements Initializable {

    @FXML
    private static Label serverHeading;

    @FXML
    private TextField urlField;

    @FXML
    private TextField databaseNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusField;

    @FXML
    private Button editButton;

    @FXML
    private CheckBox checkBox;

    private ServerDetails serverDetails;

    private boolean checked = false;

    public ServerOptionsWindowController(ViewFactory viewFactory, String fxmlName, ServerDetails serverDetails) {
          super(viewFactory, fxmlName);
//        this.urlField = null;
//        this.databaseNameField = null;
//        this.usernameField = null;
//        this.passwordField = null;
        this.serverDetails = serverDetails;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.urlField.setText(serverDetails.getUrl());
        this.databaseNameField.setText(serverDetails.getDbname());
        this.usernameField.setText(serverDetails.getUsername());
        this.passwordField.setText(serverDetails.getPassword());
        if(passwordField.getText().isEmpty()) {
            passwordField.setText("tofillspace");
        }
        DBConnect dbConnect = new DBConnect(serverDetails);
        if(dbConnect.init()) {
            statusField.setText("Connected");
            statusField.setTextFill(Color.GREEN);
        } else {
            statusField.setText("Not Connected");
            statusField.setTextFill(Color.RED);
        }
        checkBox.setText("Saved configuration");
        checkBox.setSelected(true);
        //System.out.println(AuthenticateAdminWindowController.adminRights);
        setDisabled(AuthenticateAdminWindowController.adminRights);
    }

    @FXML
    void onBack() {
        AuthenticateAdminWindowController.adminRights = false;
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
        Stage stage = (Stage) usernameField.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void onEdit() {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showAuthenticateAdminWindow();
        Stage stage = (Stage) usernameField.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void onEnter(KeyEvent event) {
        String type = event.getEventType().getName();
        KeyCode keyCode = event.getCode();
//        System.out.println(type + ": Key Code=" + keyCode.getName() + ", Text=" + event.getText()+"\n");
        checkBox.setSelected(false);
        checkBox.setText("Save this configuration");
        checkBox.setTextFill(Color.RED);
        if(event.getCode() == KeyCode.ENTER) {
            System.out.println("OK");
                databaseNameField.setFocusTraversable(true);
                usernameField.setFocusTraversable(true);
                passwordField.setFocusTraversable(true);
                urlField.setFocusTraversable(true);
        }
    }

    @FXML
    void onSave() {
        ServerDetails serverDetails = new ServerDetails(urlField.getText(), databaseNameField.getText(), usernameField.getText(), checkPassword());
        DBConnect dbConnect = new DBConnect(serverDetails);
        if(dbConnect.init()) {
            System.out.println("Connected");
            statusField.setText("Connected");
            statusField.setTextFill(Color.GREEN);
            checkBox.setSelected(true);
            checkBox.setText("Configuration saved");
            checkBox.setTextFill(Color.GREEN);
            if(checkBox.isSelected()) {
                ServerProperties serverProperties = new ServerProperties(serverDetails);
                serverProperties.setValues();
            }
        } else {
            statusField.setText("Enable to connect");
            statusField.setTextFill(Color.RED);
        }
    }

    @FXML
    void onSaveKey(KeyEvent event) {

    }

//    @FXML
//    void onChecked() {
//        if(!checked) {
//            checked = true;
//        } else {
//            checked = false;
//        }
//    }

    void setDisabled(boolean edit) {
//        System.out.println(edit);
        urlField.setDisable(!edit);
        databaseNameField.setDisable(!edit);
        usernameField.setDisable(!edit);
        passwordField.setDisable(!edit);
        editButton.setDisable(edit);
        checkBox.setDisable(!edit);
    }

    private String checkPassword() {
        if(passwordField.getText().equals("tofillspace")) {
            return "";
        } else {
            return passwordField.getText();
        }
    }
}
