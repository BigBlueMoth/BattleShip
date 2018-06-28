package customFXComponents;

import javafx.scene.Cursor;
import javafx.scene.image.Image;

public class EmptyField extends BoardField {

    public EmptyField(int posX, int posY, int fieldSize) {
        super(posX, posY, fieldSize);
        setDesign(fieldSize);
    }

    private void setDesign(int fieldSize) {
        setFitHeight(fieldSize);
        setFitWidth(fieldSize);
        setStyle("-fx-image: url(" + "/img/empty_field.png" +"); -fx-background-size: 100%");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
