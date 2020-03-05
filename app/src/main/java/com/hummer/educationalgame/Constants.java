package com.hummer.educationalgame;

public class Constants {
    private static boolean isFood;
    private static int playerCharacter;
    private static int playerSitting;

    public Constants()
    {

    }

    public static boolean isFood() {
        return isFood;
    }

    public static void setIsFood(boolean food) {
        isFood = food;
    }

    public static void setPlayerCharacter(int character) {
        playerCharacter = character;
    }

    public static void setPlayerSitting(int character) {
        playerSitting = character;
    }

    public static int getPlayerCharacter() {
        return playerCharacter;
    }

    public static int getPlayerSitting() {
        return playerSitting;
    }
}
