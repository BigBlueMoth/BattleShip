package controllers;

import customFXComponents.BoardField;
import customFXComponents.GameBoard;
import customFXComponents.ShipDirection;
import gameData.GameDataManager;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ShipPlacingController extends ViewController implements Initializable {

    class GridHoverHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                System.out.println("seconary");
                changePlacingDirection();
            } else if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                System.out.println("primary");
                BoardField bf =(BoardField)mouseEvent.getTarget();
                System.out.println(bf.getPosX() + " " + bf.getPosY());
                placeShip(bf.getPosX(), bf.getPosY());
            }
        }
    }

    @FXML HBox mainHBox;
    @FXML Button btnShip1;
    @FXML Button btnShip2;
    @FXML Button btnShip3;
    @FXML Button btnShip4;
    @FXML Label lblShip1count;
    @FXML Label lblShip2count;
    @FXML Label lblShip3count;
    @FXML Label lblShip4count;

    private SimpleIntegerProperty oneFlagCount = new SimpleIntegerProperty(GameDataManager.getOneFlagCount());
    private SimpleIntegerProperty twoFlagCount = new SimpleIntegerProperty(GameDataManager.getTwoFlagCount());
    private SimpleIntegerProperty threeFlagCount = new SimpleIntegerProperty(GameDataManager.getThreeFlagCount());
    private SimpleIntegerProperty fourFlagCount = new SimpleIntegerProperty(GameDataManager.getFourFlagCount());
    private boolean oneFlagSelected = false;
    private boolean twoFlagSelected = false;
    private boolean threeFlagSelected = false;
    private boolean fourFlagSelected = false;
    private ShipDirection placingDirection = ShipDirection.UP;

    private BoardField[][] fields;
    private GameBoard gameBoard;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblShip1count.setText(Integer.toString(oneFlagCount.get()));
        lblShip2count.setText(Integer.toString(twoFlagCount.get()));
        lblShip3count.setText(Integer.toString(threeFlagCount.get()));
        lblShip4count.setText(Integer.toString(fourFlagCount.get()));
        gameBoard = new GameBoard(GameDataManager.getGridSize());
        gameBoard.setTranslateX(gameBoard.getTranslateX() + 50);
        gameBoard.setOnMouseClicked(new GridHoverHandler());
        fields = gameBoard.getGameBoard();
        mainHBox.getChildren().add(gameBoard);

    }

    public void btnResetBoardHandler(ActionEvent event) {
        gameBoard.resetBoard();
    }

    public void btnCancelHandler(ActionEvent event) throws Exception {
        changeView("gameSettingsView",
                (Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void btnRandomizeHandler(ActionEvent event) {
        gameBoard.resetBoard();
        randomizeShipPlacing();
    }


    private void placeShip(int x, int y) {
        if (oneFlagSelected) {
            if (canPlaceShip(1, placingDirection, x, y))
                gameBoard.placeShip(1, x, y, placingDirection);
        } else if (twoFlagSelected) {
            if (canPlaceShip(2, placingDirection, x, y))
                gameBoard.placeShip(2, x, y,  placingDirection);
        } else if (threeFlagSelected) {
            if (canPlaceShip(3, placingDirection, x, y))
                gameBoard.placeShip(3, x, y, placingDirection);
        } else if (fourFlagSelected) {
            if (canPlaceShip(4, placingDirection, x, y)) {
                gameBoard.placeShip(4, x, y, placingDirection);
            }
        }
    }

    private void changePlacingDirection() {
        switch (placingDirection) {
            case UP:
                placingDirection = ShipDirection.RIGHT;
                break;
            case RIGHT:
                placingDirection = ShipDirection.DOWN;
                break;
            case DOWN:
                placingDirection = ShipDirection.LEFT;
                break;
            case LEFT:
                placingDirection = ShipDirection.UP;
                break;
        }
    }


    private void randomizeShipPlacing() {
        Random random  = new Random();
        for (int i=0; i<oneFlagCount.get(); i++) {
            ShipDirection direction = randomizeDirection();
            int posX = random.nextInt(GameDataManager.getGridSize());
            int posY = random.nextInt(GameDataManager.getGridSize());
            if (canPlaceShip(1, direction, posX, posY)) {
                gameBoard.placeShip(1, posX, posY, direction);
            } else {
                i = i-1;
            }
        }
        for (int i=0; i<twoFlagCount.get(); i++) {
            ShipDirection direction = randomizeDirection();
            int posX = random.nextInt(GameDataManager.getGridSize());
            int posY = random.nextInt(GameDataManager.getGridSize());
            if (canPlaceShip(2, direction, posX, posY)) {
                gameBoard.placeShip(2, posX, posY, direction);
            } else {
                i = i-1;
            }
        }
        for (int i=0; i<threeFlagCount.get(); i++) {
            ShipDirection direction = randomizeDirection();
            int posX = random.nextInt(GameDataManager.getGridSize());
            int posY = random.nextInt(GameDataManager.getGridSize());
            if (canPlaceShip(3, direction, posX, posY)) {
                gameBoard.placeShip(3, posX, posY, direction);
            } else {
                i = i-1;
            }
        }
        for (int i=0; i<fourFlagCount.get(); i++) {
            ShipDirection direction = randomizeDirection();
            int posX = random.nextInt(GameDataManager.getGridSize());
            int posY = random.nextInt(GameDataManager.getGridSize());
            if (canPlaceShip(4, direction, posX, posY)) {
                gameBoard.placeShip(4, posX, posY, direction);
            } else {
                i = i-1;
            }
        }
    }

    public void btnShipHandler(ActionEvent event) {
        if (event.getSource() == btnShip1) {
            oneFlagSelected = true;
            twoFlagSelected = false;
            threeFlagSelected = false;
            fourFlagSelected = false;
        } else if (event.getSource() == btnShip2) {
            twoFlagSelected = true;
            oneFlagSelected = false;
            threeFlagSelected = false;
            fourFlagSelected = false;
        } else if (event.getSource() == btnShip3) {
            threeFlagSelected = true;
            oneFlagSelected = false;
            twoFlagSelected = false;
            fourFlagSelected = false;
        } else if (event.getSource() == btnShip4) {
            fourFlagSelected = true;
            oneFlagSelected = false;
            twoFlagSelected = false;
            threeFlagSelected = false;
        }
    }

    private boolean canPlaceShip(int flagCount, ShipDirection direction, int posX, int posY) {
        if (!outOfBounds(posX, posY, flagCount, direction)) {
            return isNotColliding(posX, posY, flagCount, direction);
        }
        return false;
    }

    private boolean outOfBounds(int posX, int posY, int flagCount, ShipDirection direction) {
        switch (direction) {
            case UP:
                return (posY - flagCount) < 0;
            case DOWN:
                return (posY + flagCount) > GameDataManager.getGridSize();
            case LEFT:
                return (posX - flagCount) < 0;
            case RIGHT:
                return (posX + flagCount) > GameDataManager.getGridSize();
            default:
                return false;
        }
    }

    private boolean isNotColliding(int posX, int posY, int flagCount, ShipDirection direction) {
        switch (direction) {
            case UP:
                for (int i = 0; i < flagCount; i++) {
                    if (!fields[posX][posY - i].isEmpty()) {
                        return false;
                    }
                }
                return true;
            case DOWN:
                for (int i = 0; i < flagCount; i++) {
                    if (!fields[posX][posY + i].isEmpty()) {
                        return false;
                    }
                }
                return true;
            case LEFT:
                for (int i = 0; i < flagCount; i++) {
                    if (!fields[posX - i][posY].isEmpty()) {
                        return false;
                    }
                }
                return true;
            case RIGHT:
                for (int i = 0; i < flagCount; i++) {
                    if (!fields[posX + i][posY].isEmpty()) {
                        return false;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    private ShipDirection randomizeDirection() {
        ShipDirection direction = ShipDirection.UP;
        Random random = new Random();
        int r = random.nextInt(4);
        if (r == 0) {
            direction = ShipDirection.UP;
        } else if (r == 1) {
            direction = ShipDirection.DOWN;
        } else if (r == 2) {
            direction = ShipDirection.LEFT;
        } else if (r == 3) {
            direction = ShipDirection.RIGHT;
        }
        return direction;
    }
}
