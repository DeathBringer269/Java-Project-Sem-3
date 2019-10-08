/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gnitch
 */
public class Connect {
    public static Connection conn = null;
    public static ResultSet rs;
    public static boolean init() { 
        try {
            String userName = "root";
            String password = "password";
            String url = "jdbc:mysql://localhost:3306/java_project";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url,userName,password);
            return true;
        } catch (Exception e) {
            return false;
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
