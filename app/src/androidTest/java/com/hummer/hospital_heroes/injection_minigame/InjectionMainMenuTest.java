package com.hummer.hospital_heroes.injection_minigame;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import com.hummer.hospital_heroes.R;
import com.hummer.hospital_heroes.cream_minigame.GameActivity;

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

public class InjectionMainMenuTest
{
    @Rule
    public ActivityTestRule<InjectionMainMenu> mActivityTestRule = new ActivityTestRule<InjectionMainMenu>(InjectionMainMenu.class);
    private InjectionMainMenu mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(InjectionMainActivity.class.getName(), null, false);

    /**
     * This method is called before every test, it initialises the activity
     */
    @Before
    public void setUp() throws Exception
    {
        Intents.init();
        mActivity = mActivityTestRule.getActivity();
    }

    /**
     * This test checks if the right view is created
     */
    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.id.playButton);
        assertNotNull(view);
    }

    /**
     * This test checks if the right activity shows up once the game is complete
     */
    @Test
    public void nextScene()
    {
        assertNotNull(mActivity.findViewById(R.id.playButton));
        onView(withId(R.id.playButton)).perform(click());
        Activity nextScene = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(nextScene);
        nextScene.finish();
    }

    /**
     * This test checks if the right class is launched upon starting the game
     */
    @Test
    public void launch()
    {
        Espresso.onView(withId(R.id.playButton)).perform(click());
        intended(hasComponent(InjectionMainActivity.class.getName()));
    }

    /**
     * This test checks if the right class is launched upon starting the game
     */
    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
        Intents.release();
    }
}