package com.hummer.hospital_heroes;

import android.app.Instrumentation;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

/**
 * The test class for EndScreen.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class EndScreenTest {

    @Rule
    public ActivityTestRule<EndScreen> mActivityTestRule = new ActivityTestRule<EndScreen>(EndScreen.class);
    private EndScreen mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(EndScreen.class.getName(), null, false);

    /**
     * Initialise the activity before being tested
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
        View view = mActivity.findViewById(R.layout.end_screen);
        assertNull(view);
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
}