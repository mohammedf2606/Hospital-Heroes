package com.hummer.hospital_heroes;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import com.hummer.hospital_heroes.R;

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

public class ReceptionTest
{
    @Rule
    public ActivityTestRule<Reception> mActivityTestRule = new ActivityTestRule<Reception>(Reception.class);
    private Reception mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CharacterSelection.class.getName(), null, false);

    @Before
    public void setUp() throws Exception
    {
        Intents.init();
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.id.reception);
        assertNotNull(view);
    }

    @Test
    public void onClick()
    {
        assertNotNull(mActivity.findViewById(R.id.receptionist));
        onView(withId(R.id.receptionist)).perform(click());
        Activity nextScene = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(nextScene);
        nextScene.finish();
    }

    @Test
    public void launch()
    {

        Espresso.onView(withId(R.id.receptionist)).perform(click());
        intended(hasComponent(CharacterSelection.class.getName()));
    }

    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
        Intents.release();
    }
}