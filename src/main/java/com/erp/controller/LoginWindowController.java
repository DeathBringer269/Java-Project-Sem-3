package main.java.com.erp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.com.erp.controller.service.RememberMe;
import main.java.com.erp.controller.service.ValidateLogin;
import main.java.com.erp.model.LoggedAccount;
import main.java.com.erp.view.ViewFactory;

public class LoginWindowController extends BaseController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private CheckBox checkBox;

    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    public void setErrorLabel(String errorLabel) {
        this.errorLabel.setText(errorLabel);
    }

    @FXML
    void onSignInAction( ) {
        LoggedAccount loggedAccount = new LoggedAccount(usernameField.getText(), passwordField.getText());
        ValidateLogin validateLogin = new ValidateLogin();
        if(validateLogin.check(this)) {
            if(onCheck()) {
                RememberMe rememberMe = new RememberMe();
                rememberMe.saveCredentials();
            }
            ViewFactory viewFactory = new ViewFactory();
            viewFactory.showTeacherHome();
            Stage stage = (Stage) errorLabel.getScene().getWindow();
            viewFactory.closeStage(stage);
        }
    }

    @FXML
    boolean onCheck() {
        if(checkBox.isSelected()) {
            System.out.println("true");
            return true;
        }
        return false;
    }
}
