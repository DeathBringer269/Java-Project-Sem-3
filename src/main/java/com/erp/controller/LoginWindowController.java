package main.java.com.erp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.com.erp.controller.service.DBConnect;
import main.java.com.erp.controller.service.RememberMe;
import main.java.com.erp.controller.service.ServerProperties;
import main.java.com.erp.controller.service.ValidateLogin;
import main.java.com.erp.model.LoggedAccount;
import main.java.com.erp.model.ServerDetails;
import main.java.com.erp.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Label connectionStatus;

    @FXML
    private CheckBox checkBox;

    private DBConnect dbConnect;

    private ServerDetails serverDetails;

    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
        //System.out.println("not empty");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RememberMe rememberMe = new RememberMe();
        if(rememberMe.hasValue()) {
            usernameField.setText(rememberMe.getUsername());
            passwordField.setText(rememberMe.getPassword());
            checkBox.selectedProperty().set(true);
        }
        serverDetails = new ServerDetails(new ServerProperties());
        dbConnect= new DBConnect(serverDetails);
        if(dbConnect.init()) {
            connectionStatus.setText("Connected successfully!");
            connectionStatus.setTextFill(Color.GREEN);
        } else {
            connectionStatus.setText("Not Connected! Check your connection!");
            connectionStatus.setTextFill(Color.RED);
        }
    }

    public void setErrorLabel(String errorLabel) {
        this.errorLabel.setText(errorLabel);
    }

    @FXML
    void onSignInAction( ) {
        LoggedAccount loggedAccount = new LoggedAccount(usernameField.getText(), passwordField.getText());
        ValidateLogin validateLogin = new ValidateLogin();
        if(validateLogin.check(this)) {
            RememberMe rememberMe = new RememberMe();
            if(onCheck()) {
                System.out.println("saving credentials");
                rememberMe.saveCredentials();
            } else {
                System.out.println("clearing credentials");
                //rememberMe.clearCredentials();
            }
            ViewFactory viewFactory = new ViewFactory();
            viewFactory.showTeacherHomeWindow();
            Stage stage = (Stage) errorLabel.getScene().getWindow();
            viewFactory.closeStage(stage);
        }
    }

    @FXML
    void changeServerDetails() {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showServerOptionsWindow(serverDetails);
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    boolean onCheck() {
        if(checkBox.isSelected()) {
            System.out.println("true");
            return true;
        }
        return false;
    }

    @FXML
    void onBack() {
        ViewFactory viewFactory = new ViewFactory();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
        viewFactory.showHomeWindow();
    }

}
