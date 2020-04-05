package com.hummer.hospital_heroes.rocket_minigame;

import android.graphics.Bitmap;

import androidx.test.rule.ActivityTestRule;

import com.hummer.hospital_heroes.R;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

public class RocketMiniGameTest {

    @Rule
    public ActivityTestRule<com.hummer.hospital_heroes.rocket_minigame.GameActivity> mActivityTestRule = new ActivityTestRule<>(GameActivity.class);

    @Test
    public void testResolution() {
        ArrayList reso = mActivityTestRule.getActivity().getGameView().getResolution();
        int x = (int) reso.get(0);
        int y = (int) reso.get(1);
        assertEquals(1024, x);
        assertEquals(600, y);
    }

//    @Test
//    public void testClick() {
//        onView(withId(R.drawable.injectionroombackground)).perform(longClick());
//        Boolean touchingScreen = mActivityTestRule.getActivity().getGameView().isTouchingScreen();
//        assertEquals(true, touchingScreen);
//    }

    @Test
    public void testBitmaps() {
        ArrayList bitmaps = mActivityTestRule.getActivity().getGameView().getBitmaps();

        Bitmap starBackground = (Bitmap) bitmaps.get(0);
        assertEquals(1024, starBackground.getWidth());
        assertEquals(600, starBackground.getHeight());

        Bitmap rocket = (Bitmap) bitmaps.get(1);
        assertEquals(150, rocket.getWidth());
        assertEquals(75, rocket.getHeight());

        Bitmap house = (Bitmap) bitmaps.get(2);
        assertEquals(200, house.getWidth());
        assertEquals(200, house.getHeight());

        Bitmap sticker = (Bitmap) bitmaps.get(3);
        assertEquals(400, sticker.getWidth());
        assertEquals(400, sticker.getHeight());

        Bitmap asteroid1 = (Bitmap) bitmaps.get(4);
        assertEquals(200, asteroid1.getWidth());
        assertEquals(200, asteroid1.getHeight());

        Bitmap asteroid2 = (Bitmap) bitmaps.get(5);
        assertEquals(200, asteroid2.getWidth());
        assertEquals(200, asteroid2.getHeight());

        Bitmap asteroid3 = (Bitmap) bitmaps.get(6);
        assertEquals(200, asteroid3.getWidth());
        assertEquals(200, asteroid3.getHeight());

        Bitmap asteroid4 = (Bitmap) bitmaps.get(6);
        assertEquals(200, asteroid4.getWidth());
        assertEquals(200, asteroid4.getHeight());
    }
}
