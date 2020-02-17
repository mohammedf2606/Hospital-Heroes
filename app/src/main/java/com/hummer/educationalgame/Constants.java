package com.hummer.educationalgame;

public class Constants {
    private static boolean isFood;
    private static int playerCharacter;

    public static boolean isFood() {
        return isFood;
    }

    public static void setIsFood(boolean food) {
        isFood = food;
    }

    public static void setPlayerCharacter(int character) {
        playerCharacter = character;
    }

    public static int getPlayerCharacter() {
        return playerCharacter;
    }
}
