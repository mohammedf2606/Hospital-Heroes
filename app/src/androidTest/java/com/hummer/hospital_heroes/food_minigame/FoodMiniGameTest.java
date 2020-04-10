package com.hummer.hospital_heroes.food_minigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import androidx.test.rule.ActivityTestRule;

import com.hummer.hospital_heroes.Constants;
import com.hummer.hospital_heroes.cream_minigame.EndGameSticker;
import com.hummer.hospital_heroes.cream_minigame.GameActivity;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FoodMiniGameTest {

    @Rule
    public ActivityTestRule<MainGameActivity> mActivityTestRule = new ActivityTestRule<>(MainGameActivity.class);

    @Test
    public void testResolution() {
        assertEquals(1024, Constants.SCREEN_WIDTH);
        assertEquals(600, Constants.SCREEN_HEIGHT);
    }

    @Test
    public void testGameFinished() {
        GameView game = mActivityTestRule.getActivity().getGameView();
        game.finishGame();
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch(InterruptedException ex) {}
        assertTrue(game.isVictorySoundPlayedAlready());

        // test if sticker works
        EndGameSticker sticker = mActivityTestRule.getActivity().getGameView().getSticker();
        Canvas canvas = mActivityTestRule.getActivity().getGameView().getCanvas();
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

        Bitmap bowl = (Bitmap) bitmaps.get(0);
        assertEquals(1024, bowl.getWidth());
        assertEquals(600, bowl.getHeight());

        Bitmap hashBrown = (Bitmap) bitmaps.get(1);
        assertEquals(1024, hashBrown.getWidth());
        assertEquals(600, hashBrown.getHeight());

        Bitmap beans = (Bitmap) bitmaps.get(2);
        assertEquals(100, beans.getWidth());
        assertEquals(100, beans.getHeight());

        Bitmap background = (Bitmap) bitmaps.get(3);
        assertEquals(100, background.getWidth());
        assertEquals(100, background.getHeight());

        Bitmap sticker = (Bitmap) bitmaps.get(4);
        assertEquals(400, sticker.getWidth());
        assertEquals(400, sticker.getHeight());
    }
}
