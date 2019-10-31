package main.java.com.erp.controller.service;

import main.java.com.erp.controller.LoginWindowController;
import main.java.com.erp.model.LoggedAccount;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class RememberMe {

    private String username;

    private String password;

    public String getUsername() {
        File configFile = new File("src/main/java/com/erp/controller/service/config.properties");
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            username = props.getProperty("username");
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        } catch ( IOException e) {
            System.out.println(e);
        }
        return username;
    }

    public String getPassword() {
        File configFile = new File("src/main/java/com/erp/controller/service/config.properties");
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            password = props.getProperty("password");
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        } catch ( IOException e) {
            System.out.println(e);
        }
        return password;
    }


    public void saveCredentials() {
        File configFile = new File("src/main/java/com/erp/controller/service/config.properties");
        try {
            Properties properties = new Properties();
            properties.setProperty("username", LoggedAccount.getUsername());
            properties.setProperty("password", LoggedAccount.getPassword());
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

    public void clearCredentials() {
        File configFile = new File("src/main/java/com/erp/controller/service/config.properties");
        try {
            FileWriter writer = new FileWriter(configFile);
            writer.write("");
            writer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        } catch ( IOException e) {
            System.out.println(e);
        }
    }

    public boolean hasValue() {
        File configFile = new File("src/main/java/com/erp/controller/service/config.properties");
        if(configFile.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

}
