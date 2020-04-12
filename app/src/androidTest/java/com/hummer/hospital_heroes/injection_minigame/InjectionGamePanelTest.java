package com.hummer.hospital_heroes.injection_minigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.hummer.hospital_heroes.cream_minigame.EndGameSticker;
import com.hummer.hospital_heroes.rocket_minigame.GameActivity;
import com.hummer.hospital_heroes.rocket_minigame.GameView;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class InjectionGamePanelTest {
    @Rule
    public ActivityTestRule<InjectionMainActivity> mActivityTestRule = new ActivityTestRule<>(InjectionMainActivity.class);

    /**
     * This tests checks if the resolution assigned matches 1024x600
     */
    @Test
    public void testResolution() {
        ArrayList reso = mActivityTestRule.getActivity().getGamePanel().getResolution();
        int x = (int) reso.get(0);
        int y = (int) reso.get(1);
        assertEquals(1024, x);
        assertEquals(600, y);
    }

    /**
     * This test checks if the right booleans are set once the game is complete
     */
    @Test
    public void testGameFinished() {
        InjectionGamePanel game = mActivityTestRule.getActivity().getGamePanel();
        game.setGameOver(true);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
        }
        assertTrue(game.isVictorySoundPlayedAlready());

        // test if sticker works
        EndGameSticker sticker = mActivityTestRule.getActivity().getGamePanel().getSticker();
        Canvas canvas = mActivityTestRule.getActivity().getGamePanel().getCanvas();
        int value = sticker.drawAnimation(canvas);
        assertEquals(sticker.getWidth(), value);
    }

    /**
     * This test checks if the canvas exists (is not null)
     */
    @Test
    public void testCanvasExists() {
        Canvas canvas = mActivityTestRule.getActivity().getGamePanel().getCanvas();
        assertNotNull(canvas);
    }

    /**
     * This test checks if the bitmaps used have the right dimensions
     */
    @Test
    public void testBitmaps() {
        ArrayList bitmaps = mActivityTestRule.getActivity().getGamePanel().getBitmaps();

        Bitmap background = (Bitmap) bitmaps.get(0);
        assertEquals(1024, background.getWidth());
        assertEquals(600, background.getHeight());

        Bitmap injection = (Bitmap) bitmaps.get(1);
        assertEquals(150, injection.getWidth());
        assertEquals(150, injection.getHeight());

        Bitmap injectionArm = (Bitmap) bitmaps.get(2);
        assertEquals(1024, injectionArm.getWidth());
        assertEquals(600, injectionArm.getHeight());

        Bitmap sticker = (Bitmap) bitmaps.get(3);
        assertEquals(400, sticker.getWidth());
        assertEquals(400, sticker.getHeight());
    }
}