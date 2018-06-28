package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ViewController {
    private static final String VIEW_DIR = "/views/";
    private static final String FILE_EXT = ".fxml";

    public void changeView(String viewName, Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(VIEW_DIR + viewName + FILE_EXT));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
