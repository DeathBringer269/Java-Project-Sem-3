/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gnitch
 */
public class Connect {
    static Connection conn = null;
    public static void init() { 
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/java_project";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url,userName,password);
            System.out.println("Database connection Esatbliohed");
        } catch (Exception e) {
            System.out.println("Cannot Establish connection");
        }
    }
    public static void closeDB() throws SQLException {
        try {
            conn.close();
            System.out.println("Database connection terminated");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static Connection getConnection() {
        return conn;
    }
}
