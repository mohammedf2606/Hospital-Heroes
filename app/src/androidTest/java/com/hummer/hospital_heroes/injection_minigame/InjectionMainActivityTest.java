
package com.hummer.hospital_heroes.injection_minigame;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import com.hummer.hospital_heroes.PreScan;
import com.hummer.hospital_heroes.R;

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

public class InjectionMainActivityTest
{
    @Rule
    public ActivityTestRule<InjectionMainActivity> mActivityTestRule = new ActivityTestRule<InjectionMainActivity>(InjectionMainActivity.class);
    private InjectionMainActivity mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(PreScan.class.getName(), null, false);

    @Before
    public void setUp() throws Exception
    {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.id.textView2);
        assertNotNull(view);
    }

    @Test
    public void nextScene()
    {
        assertNotNull(mActivity.findViewById(R.id.playButton));
        onView(withId(R.id.playButton)).perform(click());
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