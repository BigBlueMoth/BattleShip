package controllers;

import gameData.GameDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameSettingsController extends ViewController implements Initializable {

    private static final int MIN_GRID_SIZE = 10;
    private static final int MAX_GRID_SIZE = 15;
    private static final int MIN_SHIP_COUNT = 1;
    private static final int MAX_SHIP_COUNT = 5;
    private static final int ONE_FLAG_REQUIRED_FIELDS = 9;
    private static final int TWO_FLAG_REQUIRED_FIELDS = 12;
    private static final int THREE_FLAG_REQUIRED_FIELDS = 15;
    private static final int FOUR_FLAG_REQUIRED_FIELDS = 18;

    private int gridSize = MIN_GRID_SIZE;
    private int oneFlagCount = MIN_SHIP_COUNT;
    private int twoFlagCount = MIN_SHIP_COUNT;
    private int threeFlagCount = MIN_SHIP_COUNT;
    private int fourFlagCount = MIN_SHIP_COUNT;
    private boolean vsAi = true;

    @FXML private ImageView ship1;
    @FXML private ImageView ship2;
    @FXML private ImageView ship3;
    @FXML private ImageView ship4;
    @FXML private TextField txtFieldGridSize;
    @FXML private TextField txtFieldOneFlagCount;
    @FXML private TextField txtFieldTwoFlagCount;
    @FXML private TextField txtFieldThreeFlagCount;
    @FXML private TextField txtFieldFourFlagCount;
    @FXML private Button btnSubGridSize;
    @FXML private Button btnAddGridSize;
    @FXML private Button btnSubOneFlag;
    @FXML private Button btnAddOneFlag;
    @FXML private Button btnSubTwoFlag;
    @FXML private Button btnAddTwoFlag;
    @FXML private Button btnSubThreeFlag;
    @FXML private Button btnAddThreeFlag;
    @FXML private Button btnSubFourFlag;
    @FXML private Button btnAddFourFlag;
    @FXML private CheckBox checkBoxAI;
    @FXML private CheckBox checkBoxPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ship1.setFitWidth(60);
        ship1.setFitHeight(60);
        ship2.setFitWidth(120);
        ship2.setFitHeight(60);
        ship3.setFitWidth(180);
        ship3.setFitHeight(60);
        ship4.setFitWidth(240);
        ship4.setFitHeight(60);
        txtFieldGridSize.setText(Integer.toString(MIN_GRID_SIZE));
        txtFieldOneFlagCount.setText(Integer.toString(MIN_SHIP_COUNT));
        txtFieldTwoFlagCount.setText(Integer.toString(MIN_SHIP_COUNT));
        txtFieldThreeFlagCount.setText(Integer.toString(MIN_SHIP_COUNT));
        txtFieldFourFlagCount.setText(Integer.toString(MIN_SHIP_COUNT));
        checkBoxAI.setSelected(true);
        checkBoxPlayer.setSelected(false);
    }

    public void btnStartHandler(ActionEvent event) throws Exception {
        GameDataManager.setGridSize(gridSize);
        GameDataManager.setVsAI(vsAi);
        GameDataManager.setOneFlagCount(oneFlagCount);
        GameDataManager.setTwoFlagCount(twoFlagCount);
        GameDataManager.setThreeFlagCount(threeFlagCount);
        GameDataManager.setFourFlagCount(fourFlagCount);
        changeView("shipPlacingView",
                (Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void btnCancelHandler(ActionEvent event) throws Exception {
        changeView("mainMenuView",
                (Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void btnAddHandler(ActionEvent event) throws Exception {
        if (event.getSource() == btnAddGridSize) {
            if (gridSize < MAX_GRID_SIZE) {
                gridSize++;
                changeTxtFieldText(txtFieldGridSize, gridSize);
            }
        } else if (event.getSource() == btnAddOneFlag) {
            if (oneFlagCount < MAX_SHIP_COUNT) {
                oneFlagCount++;
                changeTxtFieldText(txtFieldOneFlagCount, oneFlagCount);
            }
        } else if (event.getSource() == btnAddTwoFlag) {
            if (twoFlagCount < MAX_SHIP_COUNT) {
                twoFlagCount++;
                changeTxtFieldText(txtFieldTwoFlagCount, twoFlagCount);
            }
        } else if (event.getSource() == btnAddThreeFlag) {
            if (threeFlagCount < MAX_SHIP_COUNT) {
                threeFlagCount++;
                changeTxtFieldText(txtFieldThreeFlagCount, threeFlagCount);
            }
        } else if (event.getSource() == btnAddFourFlag) {
            if (fourFlagCount < MAX_SHIP_COUNT) {
                fourFlagCount++;
                changeTxtFieldText(txtFieldFourFlagCount, fourFlagCount);
            }
        }
    }

    public void btnSubHandler(ActionEvent event) throws Exception {
        if (event.getSource() == btnSubGridSize) {
            if (gridSize > MIN_GRID_SIZE) {
                gridSize--;
                changeTxtFieldText(txtFieldGridSize, gridSize);
            }
        } else if (event.getSource() == btnSubOneFlag) {
            if (oneFlagCount > MIN_SHIP_COUNT) {
                oneFlagCount--;
                changeTxtFieldText(txtFieldOneFlagCount, oneFlagCount);
            }
        } else if (event.getSource() == btnSubTwoFlag) {
            if (twoFlagCount > MIN_SHIP_COUNT) {
                twoFlagCount--;
                changeTxtFieldText(txtFieldTwoFlagCount, twoFlagCount);
            }
        } else if (event.getSource() == btnSubThreeFlag) {
            if (threeFlagCount > MIN_SHIP_COUNT) {
                threeFlagCount--;
                changeTxtFieldText(txtFieldThreeFlagCount, threeFlagCount);
            }
        } else if (event.getSource() == btnSubFourFlag) {
            if (fourFlagCount > MIN_SHIP_COUNT) {
                fourFlagCount--;
                changeTxtFieldText(txtFieldFourFlagCount, fourFlagCount);
            }
        }
    }

    public void checkBoxHandler(ActionEvent event) throws Exception {
        if (event.getSource() == checkBoxAI) {
            vsAi = true;
            changeCheckBoxState();
        } else if (event.getSource() == checkBoxPlayer) {
            vsAi = false;
            changeCheckBoxState();
        }
    }
    private void changeCheckBoxState() {
        if (vsAi) {
            checkBoxAI.setSelected(true);
            checkBoxPlayer.setSelected(false);
        } else {
            checkBoxAI.setSelected(false);
            checkBoxPlayer.setSelected(true);
        }
    }

    private void changeTxtFieldText(TextField txtField, int val) {
        System.out.println(val);
        txtField.setText(Integer.toString(val));
    }
}

