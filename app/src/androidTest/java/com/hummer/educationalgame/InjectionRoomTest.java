package com.hummer.educationalgame;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import com.hummer.educationalgame.PreScan;
import com.hummer.educationalgame.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class InjectionRoomTest
{
    @Rule
    public ActivityTestRule<InjectionRoom> mActivityTestRule = new ActivityTestRule<InjectionRoom>(InjectionRoom.class);
    private InjectionRoom mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SittingChair.class.getName(), null, false);

    @Before
    public void setUp() throws Exception
    {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.id.halo);
        assertNotNull(view);
    }

    @Test
    public void onClick()
    {
        assertNotNull(mActivity.findViewById(R.id.halo));
        onView(withId(R.id.halo)).perform(click());
        Activity nextScene = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(nextScene);
        nextScene.finish();
    }

    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
    }
}