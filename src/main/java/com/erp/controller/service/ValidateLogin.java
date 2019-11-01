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
//            DBConnect dbConnect = new DBConnect("root", "");
//            if((dbConnect.init())) {
//                //code to check if values match those in database will go here
//                //return true if matching
//                //return false if not matching
//                //table to check from = "teacher_login_data" in database "college_data"
//                return true;
//            } else {
//                loginWindowController.setErrorLabel("Unable to establish connection to database");
//                return false;
//            }
            return true;
        }
        return false;
    }
}
