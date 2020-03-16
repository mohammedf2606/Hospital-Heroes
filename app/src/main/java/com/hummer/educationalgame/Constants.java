package com.hummer.educationalgame;

import android.content.res.Resources;
/**
 * Represents constants of the characters
 *
 * @author Fahim Mohammed
 * @version 1.0
 */

public class Constants
{
    /**
     * The flag for whether the character will have the food procedure or not
     */

    private static boolean isFood, isBlack;

    /**
     * The character selected by the player
     */

    private static int playerCharacter;

    /**
     * The value for the sitting of the player
     */
    private static int playerSitting;
    public final static int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;
    public final static int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;

    /**
     * @return the procedure of the player (food or not i.e. injection).
     */
    public static boolean isFood() {
        return isFood;
    }
    /**
     * @param food the procedure of the player (food or not i.e. injection).
     */
    public static void setIsFood(boolean food) {
        isFood = food;
    }

    /**
     * @return the character of the player.
     */
    public static int getPlayerCharacter() {
        return playerCharacter;
    }

    /**
     * @param character the character of the player.
     */
    public static void setPlayerCharacter(int character) {
        playerCharacter = character;
    }

    /**
     * @return the sitting of the player.
     */
    public static int getPlayerSitting() {

        return playerSitting;
    }

    /**
     * @param character the character sitting of the player.
     */
    public static void setPlayerSitting(int character) {
        playerSitting = character;
    }

    public static void setIsBlack(boolean b) {
        isBlack = b;
    }

    public static boolean isBlack() {
        return isBlack;
    }
}
