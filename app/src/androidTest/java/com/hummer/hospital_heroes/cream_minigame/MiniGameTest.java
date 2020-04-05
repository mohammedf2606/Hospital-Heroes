package com.hummer.hospital_heroes.cream_minigame;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class MiniGameTest {

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
}
