package com.hummer.educationalgame;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

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

/*
 MainMenu, MainActivity, Reception, GenderSelection, (Fe)MaleCharSelection,
 FoodSelection/InjectionRoom, WaitingRoom, SittingChair, PreScan
*/
public class MainMenuTest
{
    @Rule
    public ActivityTestRule<MainMenu> mActivityTestRule = new ActivityTestRule<MainMenu>(MainMenu.class);
    private MainMenu mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception
    {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.id.girl_eating);
        assertNotNull(view);
    }

    @Test
    public void onClick()
    {
        assertNotNull(mActivity.findViewById(R.id.nurse));
        onView(withId(R.id.nurse)).perform(click());
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