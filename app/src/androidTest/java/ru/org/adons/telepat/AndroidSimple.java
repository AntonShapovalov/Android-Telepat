package ru.org.adons.telepat;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Simple test, to try something with Android dependency
 */
@RunWith(AndroidJUnit4.class)
public class AndroidSimple {

    @Test
    public void test() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("ru.org.adons.telepat", appContext.getPackageName());
    }

}
