/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.controller;
/*
import Project.connect.Connect;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
*/
/**
 *
 * @author gnitch
 */
public class LoadTableData {
  /*  Connection  con = null;
    
    ResultSet rs = null;
    Statement stmt = null;
  */
 
   /* 
    public void  method() throws  SQLException {
        String column = "column_name";
        con = Connect.getConnection();
        stmt = con.createStatement();
        stmt.executeQuery( "select column_name from  information_schema.columns where table_name =  'practicalmarksheet'   " );
        rs = stmt.getResultSet();
        while(rs.next()){
            String  u = rs.getString(column);
            System.out.println(u);
        }
    }
   */
    public int Pid;
    public String Name;
    public double Exp1,Exp2,Exp3,Exp4,Exp5,Avg_exp,Avg_test,Test1,Test2;
    LoadTableData( int Pid, String Name , double Exp1 , double Exp2 ,
            double Exp3,double Exp4,double Exp5,double Avg_exp,double Test1,
            double Test2,double Avg_test) {
        this .Pid = Pid;
        this.Name = Name;
        this.Exp1 = Exp1;
        this.Exp2 = Exp2;
        this.Exp3 = Exp3;
        this.Exp4 = Exp4;
        this.Exp5 = Exp5;
        this.Avg_exp = Avg_exp;
        this.Test1 = Test1;
        this.Test2 = Test2;
        this.Avg_test = Avg_test;
    }

    public int getPid() {
        return this.Pid;
    }
    public void setPid(int Pid) {
        this.Pid = Pid;
        
    }
    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public double getExp1() {
        return this.Exp1;
    }
    public void setExp1(double Exp1) {
        this.Exp1 = Exp1;
    }
    public double getExp2() {
        return this.Exp2;
    }
    public void setExp2(double Exp2) {
        this.Exp2 = Exp2;
    }public double getExp3() {
        return this.Exp3;
    }
    public void setExp3(double Exp3) {
        this.Exp3 = Exp3;
    }
    public double getExp4() {
        return this.Exp4;
    }
    public void setExp4(double Exp4) {
        this.Exp4 = Exp4;
    }
    public double getExp5() {
        return this.Exp5;
    }
    public void setExp5(double Exp5) {
        this.Exp5 = Exp5;
    }
    public double getAvg_exp() {
        return this.Avg_exp;
    }
    public void setAvg_exp(double Avg_exp) {
        this.Avg_exp = Avg_exp;
    }
    public double getTest1() {
        return this.Test1;
    }
    public void setTest1(double Test1) {
        this.Test1 = Test1;
    }
    public double getTest2() {
        return this.Test2;
    }
    public void setTest2(double Test2) {
        this.Test2 = Test2;
    }
    public double getAvg_test() {
        return this.Avg_test;
    }
    public void setAvg_test(double Avg_test) {
        this.Avg_test = Avg_test;
    }
    
}