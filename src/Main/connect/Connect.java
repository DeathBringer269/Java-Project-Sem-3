/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 *
 */
public class Connect {

    public static Connection conn = null;
    
    public static boolean init() {
        String DBname = "java_project";
        String username = "root";
        String password = "";
        try {
                String url = "jdbc:mysql://localhost/" + DBname;
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(url,username,password);
                return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    public static boolean closeDB() {
        try {
            conn.close();
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    public static Connection getConnection() {
        return conn;
    }
}
