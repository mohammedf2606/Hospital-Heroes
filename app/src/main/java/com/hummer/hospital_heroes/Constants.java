package com.hummer.hospital_heroes;

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
     * The value for the sitting of the player
     */
    private static int playerSitting;
    /**
     * The value for the standing of the player
     */
    private static int playerStanding;
    /**
     * The value for the player sitting on the injection chair
     */
    private static int playerChair;

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
     * @return the sitting of the player.
     */
    public static int getPlayerSitting() {
        return playerSitting;
    }

    /**
     * @return the standing of the player.
     */
    public static int getPlayerStanding() {
        return playerStanding;
    }

    /**
     * @return the player sitting in a chair.
     */
    public static int getPlayerChair() {
        return playerChair;
    }

    /**
     * @param playerChair the player sitting in a chair.
     */
    public static void setPlayerChair(int playerChair) {
        Constants.playerChair = playerChair;
    }

    /**
     * @param character the character sitting of the player.
     */
    public static void setPlayerSitting(int character) {
        playerSitting = character;
    }

    /**
     * @param character the character standing of the player.
     */
    public static void setPlayerStanding(int character) {
        playerStanding = character;
    }

    public static void setIsBlack(boolean b) {
        isBlack = b;
    }

    public static boolean isBlack() {
        return isBlack;
    }
}
