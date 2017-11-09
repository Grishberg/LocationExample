package com.grishberg.gpsexample;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestRunner;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testA() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.grishberg.gpsexample", appContext.getPackageName());
    }

    @Test
    @ClearData
    @LargeTest
    public void testB() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.grishberg.gpsexample", appContext.getPackageName());
    }
}
