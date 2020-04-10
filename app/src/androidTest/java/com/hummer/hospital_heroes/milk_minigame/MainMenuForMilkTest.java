package com.hummer.hospital_heroes.milk_minigame;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import com.hummer.hospital_heroes.R;
import com.hummer.hospital_heroes.injection_minigame.InjectionMainActivity;
import com.hummer.hospital_heroes.injection_minigame.InjectionMainMenu;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class MainMenuForMilkTest {
    @Rule
    public ActivityTestRule<MainMenuForMilk> mActivityTestRule = new ActivityTestRule<MainMenuForMilk>(MainMenuForMilk.class);
    private MainMenuForMilk mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MilkGameActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception
    {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.id.playButton);
        assertNotNull(view);
    }

    @Test
    public void launch()
    {
        Intents.init();
        Espresso.onView(withId(R.id.playButton)).perform(click());
        intended(hasComponent(MilkGameActivity.class.getName()));
        Intents.release();
    }

    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
    }
}