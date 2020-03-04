package com.hummer.educationalgame.injectionminigame;

import android.view.View;

import com.hummer.educationalgame.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class InjectionMainActivityTest
{
    @Rule
    public ActivityTestRule<InjectionMainActivity> mActivityTestRule = new ActivityTestRule<InjectionMainActivity>(InjectionMainActivity.class);

    private InjectionMainActivity mActivity = null;
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

    @After
    public void tearDown() throws Exception
    {
        mActivity = null;
    }
}