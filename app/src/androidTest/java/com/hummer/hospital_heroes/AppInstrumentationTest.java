package com.hummer.hospital_heroes;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on to check app context on device.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
@RunWith(AndroidJUnit4.class)
public class AppInstrumentationTest
{
    @Test
    public void useAppContext()
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.hummer.educationalgame", appContext.getPackageName());
    }
}
