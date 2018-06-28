package gameData;

import javafx.beans.property.SimpleIntegerProperty;

public class GameDataManager {
    private static SimpleIntegerProperty playerOneMissedShots = new SimpleIntegerProperty(0);
    private static SimpleIntegerProperty playerOneSuccessfullShots = new SimpleIntegerProperty(0);
    private static SimpleIntegerProperty playerTwoMissedShots = new SimpleIntegerProperty(0);
    private static SimpleIntegerProperty playerTowSuccessfullShots = new SimpleIntegerProperty(0);

    private static boolean vsAI;
    private static int gridSize;
    private static int oneFlagCount;
    private static int twoFlagCount;
    private static int threeFlagCount;
    private static int fourFlagCount;

    public static int getPlayerOneMissedShots() {
        return playerOneMissedShots.get();
    }

    public static SimpleIntegerProperty playerOneMissedShotsProperty() {
        return playerOneMissedShots;
    }

    public static void setPlayerOneMissedShots(int playerOneMissedShots) {
        GameDataManager.playerOneMissedShots.set(playerOneMissedShots);
    }

    public static int getPlayerOneSuccessfullShots() {
        return playerOneSuccessfullShots.get();
    }

    public static SimpleIntegerProperty playerOneSuccessfullShotsProperty() {
        return playerOneSuccessfullShots;
    }

    public static void setPlayerOneSuccessfullShots(int playerOneSuccessfullShots) {
        GameDataManager.playerOneSuccessfullShots.set(playerOneSuccessfullShots);
    }

    public static int getPlayerTwoMissedShots() {
        return playerTwoMissedShots.get();
    }

    public static SimpleIntegerProperty playerTwoMissedShotsProperty() {
        return playerTwoMissedShots;
    }

    public static void setPlayerTwoMissedShots(int playerTwoMissedShots) {
        GameDataManager.playerTwoMissedShots.set(playerTwoMissedShots);
    }

    public static int getPlayerTowSuccessfullShots() {
        return playerTowSuccessfullShots.get();
    }

    public static SimpleIntegerProperty playerTowSuccessfullShotsProperty() {
        return playerTowSuccessfullShots;
    }

    public static void setPlayerTowSuccessfullShots(int playerTowSuccessfullShots) {
        GameDataManager.playerTowSuccessfullShots.set(playerTowSuccessfullShots);
    }

    public static boolean isVsAI() {
        return vsAI;
    }

    public static void setVsAI(boolean vsAI) {
        GameDataManager.vsAI = vsAI;
    }

    public static int getGridSize() {
        return gridSize;
    }

    public static void setGridSize(int gridSize) {
        GameDataManager.gridSize = gridSize;
    }

    public static int getOneFlagCount() {
        return oneFlagCount;
    }

    public static void setOneFlagCount(int oneFlagCount) {
        GameDataManager.oneFlagCount = oneFlagCount;
    }

    public static int getTwoFlagCount() {
        return twoFlagCount;
    }

    public static void setTwoFlagCount(int twoFlagCount) {
        GameDataManager.twoFlagCount = twoFlagCount;
    }

    public static int getThreeFlagCount() {
        return threeFlagCount;
    }

    public static void setThreeFlagCount(int threeFlagCount) {
        GameDataManager.threeFlagCount = threeFlagCount;
    }

    public static int getFourFlagCount() {
        return fourFlagCount;
    }

    public static void setFourFlagCount(int fourFlagCount) {
        GameDataManager.fourFlagCount = fourFlagCount;
    }

}
