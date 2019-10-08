/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.controller;

import Project.connect.Connect;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author gnitch
 */
public class LoadTableData {
    Connection  con = null;
    
    ResultSet rs = null;
    Statement stmt = null;
  
 
    int i =1;
    public void  method() throws  SQLException {
        String column = "column_name";
    con = Connect.getConnection();
    stmt = con.createStatement();
    stmt.executeQuery( "select column_name from  information_schema.columns where table_name =  'practicalmarksheet'   " );
    rs = stmt.getResultSet();
    while(rs.next()){
       String  u = rs.getString(column);
       System.out.println(u);
       if(i==5 )
           break;
       i++;
    }
    }
    
    private String id;
    private String name;
    
    public LoadTableData() {
        this.id = "";
        this.name = "";
    }
    
    public LoadTableData(String title,String name) {
        this.id = title;
        this.name = name;
    }
    
    public String getTitle() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setTitle(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}