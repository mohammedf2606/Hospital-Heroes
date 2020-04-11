package com.hummer.hospital_heroes;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import com.hummer.hospital_heroes.rocket_minigame.MainMenu;

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

/**
 * The test class for StrapToChair.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class StrapToChairTest {


    @Rule
    public ActivityTestRule<StrapToChair> mActivityTestRule = new ActivityTestRule<>(StrapToChair.class);
    private StrapToChair mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainMenu.class.getName(), null, false);

    /**
     * Initialise the activity being tested
     */
    @Before
    public void setUp() throws Exception
    {
        Intents.init();
        mActivity = mActivityTestRule.getActivity();
    }

    /**
     * Test the view of the activity is displayed on screen.
     */
    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.id.strapping);
        assertNotNull(view);
    }

    /**
     * Test the button that launches the next activity displays the next screen.
     */
    @Test
    public void onClick()
    {
        assertNotNull(mActivity.findViewById(R.id.strapbackground));
        perform6clicks();
        Activity nextScene = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(nextScene);
        nextScene.finish();
    }

    /**
     * Test the view on the next activity shows on screen.
     */
    @Test
    public void launch()
    {

        perform6clicks();
        intended(hasComponent(MainMenu.class.getName()));
    }

    /**
     * Release the activity after being tested
     */
    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
        Intents.release();
    }

    public void perform6clicks() {
        for(int i = 0; i < 6; i++) {
            Espresso.onView(withId(R.id.strapbackground)).perform(click());
        }
    }
}