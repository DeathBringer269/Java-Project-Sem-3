/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alan.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Grace
 */
public class LoginController {
    
    private AnchorPane root;
    
    private Button teacherbutton;
    
    private Button studentbutton;
    
    private TextField username;
    
    private PasswordField password;
    
    private Button login;
    
    void onLogin(ActionEvent event) {
        String u = username.getText();
        String p = password.getText();
        System.out.println(u + p);
    }
}
