package com.hummer.hospital_heroes;

import android.app.Instrumentation;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class EndScreenTest {

    @Rule
    public ActivityTestRule<EndScreen> mActivityTestRule = new ActivityTestRule<EndScreen>(EndScreen.class);
    private EndScreen mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(EndScreen.class.getName(), null, false);

    @Before
    public void setUp() throws Exception
    {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.layout.end_screen);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
    }
}