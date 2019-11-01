package main.java.com.erp.controller.service;

import main.java.com.erp.model.LoggedAccount;
import main.java.com.erp.model.ServerDetails;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ServerProperties {

    private String url;

    private String dbName;

    private String username;

    private String password;

    public ServerProperties() {

    }

    public ServerProperties(ServerDetails serverDetails) {
        this.url = serverDetails.getUrl();
        this.dbName = serverDetails.getDbname();
        this.username = serverDetails.getUsername();
        this.password = serverDetails.getPassword();
    }

    public void setValues() {
        File configFile = new File("src/main/java/com/erp/controller/service/server.properties");
        try {
            Properties properties = new Properties();
            properties.setProperty("url", url);
            properties.setProperty("databaseName",dbName);
            properties.setProperty("username",username);
            properties.setProperty("password",password);
            FileWriter writer = new FileWriter(configFile);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            properties.store(writer, "Server Settings: " + dtf.format(now));
            writer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        } catch ( IOException e) {
            System.out.println(e);
        }
    }

    public String getUrl() {
        File configFile = new File("src/main/java/com/erp/controller/service/server.properties");
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            url = props.getProperty("url");
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        } catch ( IOException e) {
            System.out.println(e);
        }
        return url;
    }

    public String getDbName() {
        File configFile = new File("src/main/java/com/erp/controller/service/server.properties");
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            dbName = props.getProperty("databaseName");
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        } catch ( IOException e) {
            System.out.println(e);
        }
        return dbName;
    }

    public String getUsername() {
        File configFile = new File("src/main/java/com/erp/controller/service/server.properties");
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
        File configFile = new File("src/main/java/com/erp/controller/service/server.properties");
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

}
