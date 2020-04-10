package com.hummer.hospital_heroes;

import android.app.Instrumentation;
import android.view.View;

import com.hummer.hospital_heroes.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

/**
 * The test class for WaitingRoom.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class WaitingRoomTest
{
    @Rule
    public ActivityTestRule<WaitingRoom> mActivityTestRule = new ActivityTestRule<WaitingRoom>(WaitingRoom.class);
    private WaitingRoom mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SittingChair.class.getName(), null, false);

    /**
     * initialise the activity being tested
     */
    @Before
    public void setUp() throws Exception
    {
        mActivity = mActivityTestRule.getActivity();
    }

    /**
     * Test the view of the activity is displayed on screen.
     */
    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.id.character);
        assertNotNull(view);
    }

    /**
     * Release the activity after being tested
     */
    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
    }
}