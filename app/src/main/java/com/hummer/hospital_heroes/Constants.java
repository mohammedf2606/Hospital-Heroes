package com.hummer.hospital_heroes;

import java.util.ArrayList;

/**
 * Represents constants used throughout the game that are shared between different sections of the game
 *
 * @author Fahim Mohammed
 * @version 1.0
 */

public class Constants {

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
    /**
     * An arraylist that stores all images of a certain character being strapped
     */
    private static ArrayList<Integer> playerGettingStrapped = new ArrayList<>();

    /**
     * Two constants for calculating the screen size
     */
    public static int SCREEN_HEIGHT;
    public static int SCREEN_WIDTH;

    /**
     * @param screenHeight the height of the screen
     */
    public static void setScreenHeight(int screenHeight) {
        SCREEN_HEIGHT = screenHeight;
    }

    /**
     * @param screenWidth the width of the screen
     */
    public static void setScreenWidth(int screenWidth) {
        SCREEN_WIDTH = screenWidth;
    }

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

    public static ArrayList<Integer> getPlayerStraps(){ return playerGettingStrapped; }

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

    /**
     * @param b whether a character is black or not
     */
    public static void setIsBlack(boolean b) {
        isBlack = b;
    }

    /**
     * @param index the location of where the picture will be stored
     * @param strap the image of the character getting strapped in
     */
    public static void setPlayerGettingStrapped(int index, int strap) {
        playerGettingStrapped.add(index, strap);
    }

    /**
     * @return whether the character is black
     */
    public static boolean isBlack() {
        return isBlack;
    }

}
