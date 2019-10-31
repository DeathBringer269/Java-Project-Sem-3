package main.java.com.erp.controller.service;

import main.java.com.erp.model.LoggedAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class RememberMe {

    private String username;

    private String password;

    public RememberMe() {
        this.username = LoggedAccount.getUsername();
        this.password = LoggedAccount.getPassword();
    }


    public void saveCredentials() {
        System.out.println("here");
        File configFile = new File("src/main/java/com/erp/controller/service/config.properties");
        try {
            Properties properties = new Properties();
            properties.setProperty("username", username);
            properties.setProperty("password", password);
            FileWriter writer = new FileWriter(configFile);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            properties.store(writer, "Saved Credentials: " + dtf.format(now));
            writer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        } catch ( IOException e) {
            System.out.println(e);
        }
    }


}
