package main.java.com.erp.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.java.com.erp.view.ViewFactory;

public class TeacherHomeWindowController extends BaseController {

    @FXML
    private BorderPane borderPane;

    public TeacherHomeWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void onViewTables() {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showTableViewWindow();
        Stage stage = (Stage) borderPane.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void onOptions() {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showOptionsWindow();
    }
}
