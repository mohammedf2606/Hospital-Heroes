package com.hummer.hospital_heroes.cream_minigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CreamMiniGameTest {

    @Rule
    public ActivityTestRule<GameActivity> mActivityTestRule = new ActivityTestRule<>(GameActivity.class);

    @Test
    public void testResolution() {
        ArrayList reso = mActivityTestRule.getActivity().getGameView().getResolution();
        int x = (int) reso.get(0);
        int y = (int) reso.get(1);
        assertEquals(1024, x);
        assertEquals(600, y);
    }

    @Test
    public void testGameFinished() {
        GameView game = mActivityTestRule.getActivity().getGameView();
        game.finishGame();
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch(InterruptedException ex) {}
        assertTrue(game.isGameFinished());
        assertTrue(game.isVictorySoundPlayedAlready());

        // test if sticker works
        EndGameSticker sticker = game.getSticker();
        Canvas canvas = game.getCanvas();
        int value = sticker.drawAnimation(canvas);
        assertEquals(sticker.getWidth(), value);
    }

    @Test
    public void testCanvasExists() {
        Canvas canvas = mActivityTestRule.getActivity().getGameView().getCanvas();
        assertNotNull(canvas);
    }

    @Test
    public void testBitmaps() {
        ArrayList bitmaps = mActivityTestRule.getActivity().getGameView().getBitmaps();

        Bitmap background = (Bitmap) bitmaps.get(0);
        assertEquals(1024, background.getWidth());
        assertEquals(600, background.getHeight());

        Bitmap armSprite = (Bitmap) bitmaps.get(1);
        assertEquals(1024, armSprite.getWidth());
        assertEquals(600, armSprite.getHeight());

        Bitmap creamSplat = (Bitmap) bitmaps.get(2);
        assertEquals(100, creamSplat.getWidth());
        assertEquals(100, creamSplat.getHeight());

        Bitmap creamTube = (Bitmap) bitmaps.get(3);
        assertEquals(100, creamTube.getWidth());
        assertEquals(100, creamTube.getHeight());

        Bitmap location1 = (Bitmap) bitmaps.get(4);
        assertEquals(100, location1.getWidth());
        assertEquals(100, location1.getHeight());

        Bitmap location2 = (Bitmap) bitmaps.get(5);
        assertEquals(100, location2.getWidth());
        assertEquals(100, location2.getHeight());

        Bitmap sticker = (Bitmap) bitmaps.get(6);
        assertEquals(400, sticker.getWidth());
        assertEquals(400, sticker.getHeight());
    }
}
