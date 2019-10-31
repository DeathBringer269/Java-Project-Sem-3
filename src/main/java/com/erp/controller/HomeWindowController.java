package main.java.com.erp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.java.com.erp.view.ViewFactory;


public class HomeWindowController extends BaseController {

    @FXML
    private Button signInButton;

    public HomeWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void onSignInAction( ) {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
        Stage stage = (Stage) signInButton.getScene().getWindow();
        viewFactory.closeStage(stage);
        return;
    }

}
