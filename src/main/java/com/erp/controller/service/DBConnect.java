package main.java.com.erp.controller.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_data","root", "");
            /*Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select Username from teacher_login_data");
            while(rs.next()) {
                System.out.println(rs.getInt(1));
            }*/
            System.out.println("connected");
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
}
