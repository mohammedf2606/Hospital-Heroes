package com.hummer.educationalgame;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class Constants {
    private static boolean isFood;
    private static int playerCharacter;
    private static int playerSitting;
    public final static int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;
    public final static int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;

    static boolean isFood() {
        return isFood;
    }

    static void setIsFood(boolean food) {
        isFood = food;
    }

    static void setPlayerCharacter(int character) {
        playerCharacter = character;
    }

    static void setPlayerSitting(int character) {
        playerSitting = character;
    }

    static int getPlayerCharacter() {
        return playerCharacter;
    }

    static int getPlayerSitting() {
        return playerSitting;
    }
}
