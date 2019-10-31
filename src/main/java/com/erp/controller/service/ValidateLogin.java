package main.java.com.erp.controller.service;

import main.java.com.erp.controller.LoginWindowController;
import main.java.com.erp.model.LoggedAccount;

public class ValidateLogin {

    String username;

    String password;

    public ValidateLogin() {
        this.username = LoggedAccount.getUsername();
        this.password = LoggedAccount.getPassword();
        //System.out.println(username + password);
    }


    public boolean check(LoginWindowController loginWindowController) {
        if(username.isEmpty()) {
            loginWindowController.setErrorLabel("Username cannot be empty!");
        } else if(password.isEmpty()) {
            loginWindowController.setErrorLabel("Password cannot be empty!");
        } else {
            loginWindowController.setErrorLabel("");
            return true;
        }
        return false;
    }
}
