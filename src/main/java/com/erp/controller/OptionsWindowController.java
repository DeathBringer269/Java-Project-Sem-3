package main.java.com.erp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import main.java.com.erp.controller.service.RememberMe;
import main.java.com.erp.view.ViewFactory;

public class OptionsWindowController extends BaseController {

    @FXML
    private CheckBox clearSavedData;

    public static boolean checked = false;

    public OptionsWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void onSignOut() {
        OptionsWindowController.checked = true;
        if(clearSavedData.isSelected()) {
//            System.out.println("Working");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to clear your saved username, password amd quit!!", ButtonType.YES, ButtonType.CANCEL);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES) {
                RememberMe rememberMe = new RememberMe();
                rememberMe.clearCredentials();
                Stage stage = (Stage) clearSavedData.getScene().getWindow();
                ViewFactory viewFactory = new ViewFactory();
                viewFactory.closeStage(stage);
            }
        } else {
            Stage stage = (Stage) clearSavedData.getScene().getWindow();
            ViewFactory viewFactory = new ViewFactory();
            viewFactory.closeStage(stage);
        }
    }


    @FXML
    void onViewProfile() {

    }

    @FXML
    void onBack() {
        Stage stage = (Stage) clearSavedData.getScene().getWindow();
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.closeStage(stage);
    }
}
