package Project.controller;

import Project.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import Project.connect.Connect;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;

public class TeacherTableController {
    
    Stage stage = MainApp.stage;

    @FXML
    private Button displaybutton1;

    @FXML
    private Button toback;
    @FXML
    private Button edit;

    @FXML
    private TabPane tabpane;

    @FXML
     private TableView<LoadTableData> teac_tbl;
    @FXML
    private TableColumn Pid,Name,Exp1,Exp2,Exp3,Exp4,Exp5,Avg_exp,Test1,Test2,Avg_test; 
    @FXML
    private TextField txtPid,txtName,txtExp1,txtExp2,txtExp3,txtExp4,txtExp5,txtAvg_exp,txtTest1,txtTest2,txtAvg_test; 

    @FXML
    void onBackClicked(MouseEvent event) {
        try {
            URL url = getClass().getResource("/Project/fxml/teacher1.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);   
            stage.setScene(scene);
            stage.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void onEditClicked(MouseEvent event) throws SQLException {
        Tab tab = new Tab();
        tab.setText("Marksheet1");
        tab.setClosable(true);
        tabpane.getTabs().add(tab);
        //displaying table
        System.out.println("Entered");
        teac_tbl = new TableView<LoadTableData>();
        teac_tbl.setEditable(true);
        teac_tbl.setItems(loadData());
        Pid.setCellValueFactory(new PropertyValueFactory<LoadTableData, Integer >("Pid"));
        Pid.setCellFactory(TextFieldTableCell.forTableColumn());
        Pid.setOnEditCommit( e -> Pid_OnEditCommit(e) );
        Name.setCellValueFactory(new PropertyValueFactory<LoadTableData, String >("Name"));
        Name.setCellFactory(TextFieldTableCell.forTableColumn());
        Name.setOnEditCommit( e -> Name_OnEditCommit(e) );
        Exp1.setCellValueFactory(new PropertyValueFactory<LoadTableData, Double >("Exp1"));
        Exp1.setCellFactory(TextFieldTableCell.forTableColumn());
        Exp1.setOnEditCommit( e -> Exp1_OnEditCommit(e) );
        Exp2.setCellValueFactory(new PropertyValueFactory<LoadTableData, Double >("Exp2"));
        Exp2.setCellFactory(TextFieldTableCell.forTableColumn());
        Exp2.setOnEditCommit( e -> Exp2_OnEditCommit(e) );
        Exp3.setCellValueFactory(new PropertyValueFactory<LoadTableData, Double >("Exp3"));
        Exp3.setCellFactory(TextFieldTableCell.forTableColumn());
        Exp3.setOnEditCommit( e -> Exp3_OnEditCommit(e) );
        Exp4.setCellValueFactory(new PropertyValueFactory<LoadTableData, Double >("Exp4"));
        Exp4.setCellFactory(TextFieldTableCell.forTableColumn());
        Exp4.setOnEditCommit( e -> Exp4_OnEditCommit(e) );
        Exp5.setCellValueFactory(new PropertyValueFactory<LoadTableData, Double >("Exp5"));
        Exp5.setCellFactory(TextFieldTableCell.forTableColumn());
        Exp5.setOnEditCommit( e -> Exp5_OnEditCommit(e) );
        Avg_exp.setCellValueFactory(new PropertyValueFactory<LoadTableData, Double >("Avg-Exp"));
        Avg_exp.setCellFactory(TextFieldTableCell.forTableColumn());
        Avg_exp.setOnEditCommit( e -> Avg_exp_OnEditCommit(e) );
        Test1.setCellValueFactory(new PropertyValueFactory<LoadTableData, Double >("Test1"));
        Test1.setCellFactory(TextFieldTableCell.forTableColumn());
        Test1.setOnEditCommit( e -> Test1_OnEditCommit(e) );
        Test2.setCellValueFactory(new PropertyValueFactory<LoadTableData, Double >("Test2"));
        Test2.setCellFactory(TextFieldTableCell.forTableColumn());
        Test2.setOnEditCommit( e -> Test2_OnEditCommit(e) );
        Avg_test.setCellValueFactory(new PropertyValueFactory<LoadTableData, Double >("Avg-Test"));
        Avg_test.setCellFactory(TextFieldTableCell.forTableColumn());
        Avg_test.setOnEditCommit( e -> Avg_test_OnEditCommit(e) );       
    }



    

   
   /* class TableData {
        
    }
*/

    @FXML
    void onClickButton1(MouseEvent event) {

    }

    @FXML
    void onLogoutClicked(MouseEvent event) {
        HomeController home = new HomeController();
        Scene scene = home.setLoginPage();
        stage.setScene(scene);
        stage.setResizable(false);
    }
    public ObservableList<LoadTableData> loadData() throws SQLException {
        ObservableList<LoadTableData> data = 
                FXCollections.observableArrayList();
        Connection  con ;
        ResultSet rs ;
        Statement stmt ;
        String nm = "Name";
        String id = "Pid";
        String ep1 = "Exp1",ep2 = "Exp2",ep3 = "Exp3",ep4 = "Exp4";
        String ep5 = "Exp5",avg_ep = "Avg_exp",t1 = "Test1",t2 = "Test2";
        String avg_t = "Avg_test";
        int i= 1;
        int pid;
        String name;
        double exp1,exp2,exp3,exp4,exp5,avg_exp,test1,test2,avg_test;
        try {
            con = Connect.getConnection();
            stmt = con.createStatement();
            stmt.executeQuery("SELECT * FROM practicalmarksheet" );
            rs = stmt.getResultSet();
            while(rs.next()) {
                pid = rs.getInt(id);
                name = rs.getString(nm);
                System.out.println(name);
                exp1 = rs.getDouble(ep1);
                exp2 = rs.getDouble(ep2);
                exp3 = rs.getDouble(ep3);
                exp4 = rs.getDouble(ep4);
                exp5 = rs.getDouble(ep5);
                avg_exp = rs.getDouble(avg_ep);
                test1 = rs.getDouble(t1);
                test2 = rs.getDouble(t2);
                avg_test = rs.getDouble(avg_t);
                data.add(new LoadTableData(pid,name,exp1,exp2,exp3,exp4,exp5,avg_exp,test1,test2,avg_test));
                
                if(i == 2) {
                    break;
                }
                i++;
            }
            
            
        } catch(SQLException e) {
            System.out.println(e);
        }
        return data;
    }
    private void Pid_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Integer >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Integer >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setPid(ce.getNewValue());
    }
    private void Name_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , String >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,String >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setName(ce.getNewValue());
    }
    private void Exp1_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Double >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Double >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setExp1(ce.getNewValue());
    }
    private void Exp2_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Double >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Double >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setExp2(ce.getNewValue());
    }
    private void Exp3_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Double >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Double >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setExp3(ce.getNewValue());
    }
    private void Exp4_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Double >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Double >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setExp4(ce.getNewValue());
    }
    private void Exp5_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Double >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Double >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setExp5(ce.getNewValue());
    }
    private void Avg_exp_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Double >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Double >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setAvg_exp(ce.getNewValue());
    }
    private void Test1_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Double >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Double >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setTest1(ce.getNewValue());
    }
    private void Test2_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Double >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Double >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setTest2(ce.getNewValue());
    }
    private void Avg_test_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<LoadTableData , Double >ce;
        ce = (TableColumn.CellEditEvent<LoadTableData ,Double >)e;
        LoadTableData tb = ce.getRowValue();
        tb.setAvg_test(ce.getNewValue());
    }

}

