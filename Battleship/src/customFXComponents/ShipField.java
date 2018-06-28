package customFXComponents;

import javafx.animation.ScaleTransition;
import javafx.util.Duration;

public class ShipField extends BoardField {
    private ShipPart part;
    private ShipDirection direction;

    public ShipField(int posX, int posY, int fieldSize, ShipPart part, ShipDirection direction) {
        super(posX, posY, fieldSize);
        this.part = part;
        this.direction = direction;
        setDesign(part, direction);
        ScaleTransition transition = new ScaleTransition();
        transition.setDuration(Duration.seconds(1));
        transition.setNode(this);
        transition.setFromX(6);
        transition.setFromY(6);
        transition.setToX(1);
        transition.setToY(1);
        transition.setCycleCount(1);
        transition.setAutoReverse(false);
        transition.play();
    }

    private void setDesign(ShipPart part, ShipDirection direction) {
        switch (part) {
            case FRONT:
                if (direction == ShipDirection.UP) {
                    setStyle("-fx-image: url(" + "/img/front_down.png" +")");
                } else if (direction == ShipDirection.DOWN) {
                    setStyle("-fx-image: url(" + "/img/front_up.png" + ")");
                } else if (direction == ShipDirection.LEFT) {
                    setStyle("-fx-image: url(" + "/img/front_right.png" + ")");
                } else if (direction == ShipDirection.RIGHT) {
                    setStyle("-fx-image: url(" + "/img/front_left.png" + ")");
                }
                break;
            case MID:
                if (direction == ShipDirection.UP) {
                    setStyle("-fx-image: url(" + "/img/mid_down.png" + ")");
                } else if (direction == ShipDirection.DOWN) {
                    setStyle("-fx-image: url(" + "/img/mid_up.png" + ")");
                } else if (direction == ShipDirection.LEFT) {
                    setStyle("-fx-image: url(" + "/img/mid_right.png" + ")");
                } else if (direction == ShipDirection.RIGHT) {
                    setStyle("-fx-image: url(" + "/img/mid_left.png" + ")");
                }
                break;
            case END:
                if (direction == ShipDirection.UP) {
                    setStyle("-fx-image: url(" + "/img/back_down.png" + ")");
                } else if (direction == ShipDirection.DOWN) {
                    setStyle("-fx-image: url(" + "/img/back_up.png" + ")");
                } else if (direction == ShipDirection.LEFT) {
                    setStyle("-fx-image: url(" + "/img/back_right.png" + ")");
                } else if (direction == ShipDirection.RIGHT) {
                    setStyle("-fx-image: url(" + "/img/back_left.png" + ")");
                }
                break;
            case ONE_PIECE:
                if (direction == ShipDirection.UP) {
                    setStyle("-fx-image: url(" + "/img/one_piece_up.png" + ")");
                } else if (direction == ShipDirection.DOWN) {
                    setStyle("-fx-image: url(" + "/img/one_piece_down.png" + ")");
                }else if (direction == ShipDirection.LEFT) {
                    setStyle("-fx-image: url(" + "/img/one_piece_left.png" + ")");
                } else if (direction == ShipDirection.RIGHT) {
                    setStyle("-fx-image: url(" + "/img/one_piece_right.png" + ")");
                }
                break;
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
