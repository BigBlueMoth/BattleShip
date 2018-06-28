package customFXComponents;

import javafx.scene.layout.GridPane;

public class GameBoard extends GridPane {
    private static final int BOARD_SIZE = 500;

    private BoardField[][] gameBoard;
    private int fieldSize;
    private int gridCount;

    public GameBoard(int gridCount) {
        this.gridCount = gridCount;
        fieldSize = BOARD_SIZE/(gridCount+3);
        gameBoard = new BoardField[gridCount][gridCount];
        prefHeight(BOARD_SIZE);
        prefWidth(BOARD_SIZE);
        initEmptyFields();
        setGridLinesVisible(true);
    }

    public static GameBoard createGameBoard(int gridCount) {
        GameBoard res = new GameBoard(gridCount);
        return res;
    }

    private void initEmptyFields() {
        for (int x = 0; x<gridCount; x++) {
            for (int y = 0; y<gridCount; y++) {
                gameBoard[x][y] = new EmptyField(x, y, fieldSize);
                add(gameBoard[x][y], x, y);
            }
        }
    }

    public void placeShip(int flagCount, int posX, int posY, ShipDirection direction) {
        if (flagCount == 1) {
            placeOneFlagShip(posX, posY, direction);
        } else if (flagCount == 2) {
            placeTwoFlagShip(posX, posY, direction);
        } else if (flagCount == 3) {
            placeThreeFlagShip(posX, posY, direction);
        } else if (flagCount == 4) {
            placeFourFlagShip(posX, posY, direction);
        }
    }

    private void placeOneFlagShip(int posX, int posY, ShipDirection direction) {
        placeShipField(posX, posY, ShipPart.ONE_PIECE, direction);
    }

    private void placeTwoFlagShip(int posX, int posY, ShipDirection direction) {
        placeShipField(posX, posY, ShipPart.FRONT, direction);
        switch (direction) {
            case UP:
                placeShipField(posX, posY-1, ShipPart.END, direction);
                break;
            case DOWN:
                placeShipField(posX, posY+1, ShipPart.END, direction);
                break;
            case LEFT:
                placeShipField(posX-1, posY, ShipPart.END, direction);
                break;
            case RIGHT:
                placeShipField(posX+1, posY, ShipPart.END, direction);
                break;
        }
    }

    private void placeThreeFlagShip(int posX, int posY, ShipDirection direction) {
        placeShipField(posX, posY, ShipPart.FRONT, direction);
        switch (direction) {
            case UP:
                placeShipField(posX, posY-1, ShipPart.MID, direction);
                placeShipField(posX, posY-2, ShipPart.END, direction);
                break;
            case DOWN:
                placeShipField(posX, posY+1, ShipPart.MID, direction);
                placeShipField(posX, posY+2, ShipPart.END, direction);
                break;
            case LEFT:
                placeShipField(posX-1, posY, ShipPart.MID, direction);
                placeShipField(posX-2, posY, ShipPart.END, direction);
                break;
            case RIGHT:
                placeShipField(posX+1, posY, ShipPart.MID, direction);
                placeShipField(posX+2, posY, ShipPart.END,direction);
                break;
        }
    }

    private void placeFourFlagShip(int posX, int posY, ShipDirection direction) {
        placeShipField(posX, posY, ShipPart.FRONT, direction);
        switch (direction) {
            case UP:
                placeShipField(posX, posY-1, ShipPart.MID, direction);
                placeShipField(posX, posY-2, ShipPart.MID, direction);
                placeShipField(posX, posY-3, ShipPart.END, direction);
                break;
            case DOWN:
                placeShipField(posX, posY+1, ShipPart.MID, direction);
                placeShipField(posX, posY+2, ShipPart.MID, direction);
                placeShipField(posX, posY+3, ShipPart.END, direction);
                break;
            case LEFT:
                placeShipField(posX-1, posY, ShipPart.MID, direction);
                placeShipField(posX-2, posY, ShipPart.MID, direction);
                placeShipField(posX-3, posY, ShipPart.END, direction);
                break;
            case RIGHT:
                placeShipField(posX+1, posY, ShipPart.MID, direction);
                placeShipField(posX+2, posY, ShipPart.MID, direction);
                placeShipField(posX+3, posY, ShipPart.END, direction);
                break;
        }
    }

    public void resetBoard() {
        for (int x=0; x<gridCount; x++) {
            for (int y=0; y<gridCount; y++) {
                placeEmptyField(x, y);
            }
        }
        setGridLinesVisible(true);
    }

    private void placeShipField(int posX, int posY, ShipPart part, ShipDirection direction) {
        gameBoard[posX][posY] = new ShipField(posX, posY, fieldSize, part, direction);
        replaceBoardField(gameBoard[posX][posY]);
    }

    private void placeEmptyField(int posX, int posY) {
        getChildren().remove(gameBoard[posX][posY]);
        gameBoard[posX][posY] = new EmptyField(posX, posY, fieldSize);
        add(gameBoard[posX][posY], posX, posY);
    }

    private void replaceBoardField(BoardField newField) {
        getChildren().remove(gameBoard[newField.getPosX()][newField.getPosY()]);
        add(newField, newField.getPosX(), newField.getPosY());
    }

    public BoardField[][] getGameBoard() {
        return gameBoard;
    }

}
