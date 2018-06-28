package customFXComponents;

import javafx.scene.image.ImageView;

public abstract class BoardField extends ImageView {

    int posX;
    int posY;
    boolean hit;

    public BoardField(int posX, int posY, int fieldSize) {
        this.posX = posX;
        this.posY = posY;
        hit = false;
        setFitHeight(fieldSize);
        setFitWidth(fieldSize);
    }

    public void changeHitState() {
        hit = true;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public boolean isHit() {
        return hit;
    }

    public abstract boolean isEmpty();
}
