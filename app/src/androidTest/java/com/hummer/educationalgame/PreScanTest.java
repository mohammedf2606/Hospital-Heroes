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

public class PreScanTest
{
    @Rule
    public ActivityTestRule<PreScan> mActivityTestRule = new ActivityTestRule<PreScan>(PreScan.class);
    private PreScan mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(PreScan.class.getName(), null, false);

    @Before
    public void setUp() throws Exception
    {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void onCreate()
    {
        View view = mActivity.findViewById(R.id.pre_scan_room);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
    }
}