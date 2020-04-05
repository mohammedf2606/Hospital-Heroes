package com.hummer.hospital_heroes.cream_minigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.CoordinatesProvider;
import androidx.test.espresso.action.GeneralClickAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Tap;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Espresso.*;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;

import com.hummer.hospital_heroes.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class MiniGameTest {

    @Rule
    public ActivityTestRule<GameActivity> mActivityTestRule = new ActivityTestRule<>(GameActivity.class);


    public static ViewAction clickXY(final int x, final int y){
        return new GeneralClickAction(
                Tap.LONG,
                new CoordinatesProvider() {
                    @Override
                    public float[] calculateCoordinates(View view) {

                        final int[] screenPos = new int[2];
                        view.getLocationOnScreen(screenPos);

                        final float screenX = screenPos[0] + x;
                        final float screenY = screenPos[1] + y;
                        float[] coordinates = {screenX, screenY};

                        return coordinates;
                    }
                },
                Press.FINGER);
    }

    @Test
    public void testResolution() {
        ArrayList reso = mActivityTestRule.getActivity().getGameView().getResolution();
        int x = (int) reso.get(0);
        int y = (int) reso.get(1);
        assertEquals(1024, x);
        assertEquals(600, y);
    }

    @Test
    public void testClick() {
        onView(withId(R.drawable.injectionroombackground)).perform(longClick());
        Boolean touchingScreen = mActivityTestRule.getActivity().getGameView().isTouchingScreen();
        assertEquals(true, touchingScreen);
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
