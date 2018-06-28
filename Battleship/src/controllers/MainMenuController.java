package controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MainMenuController extends ViewController {

    public void btnNewGameHandler(ActionEvent event) throws Exception {
        changeView("gameSettingsView",
                (Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void btnContinueHandler(ActionEvent event) throws Exception {
        System.out.println("CONTINUE");
    }

    public void btnInfoHandler(ActionEvent event) throws Exception {
        System.out.println("INFO");
    }
}
