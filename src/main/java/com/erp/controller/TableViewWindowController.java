package main.java.com.erp.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.java.com.erp.view.ViewFactory;

public class TableViewWindowController extends BaseController {

    @FXML
    private BorderPane borderPane;

    public TableViewWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void onBack() {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showTeacherHomeWindow();
        Stage stage = (Stage) borderPane.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

}
