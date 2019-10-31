package main.java.com.erp.controller.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

    Connection connection;

    public boolean init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_data","root", "");
            /*Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select Username from teacher_login_data");
            while(rs.next()) {
                System.out.println(rs.getInt(1));
            }*/
            System.out.println("connected");
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
