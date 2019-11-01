package main.java.com.erp.controller.service;

import main.java.com.erp.model.ServerDetails;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    private String username;

    private String password;

    private String url;

    private String dbName;

    private Connection connection = null;

    public DBConnect(ServerDetails server) {
        this.url = server.getUrl();
        this.dbName = server.getDbname();
        this.username = server.getUsername();
        this.password = server.getPassword();
        System.out.println(url+dbName);
    }


    public boolean init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection  = DriverManager.getConnection(url + dbName,username, password);
            /*Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select Username from teacher_login_data");
            while(rs.next()) {
                System.out.println(rs.getInt(1));
            }*/
            System.out.println("Connected to " + url + dbName + "\n" + "Username: " + username + "\nPassword: " + password);
            return true;
        } catch (Exception  e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
