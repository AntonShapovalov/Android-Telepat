package ru.org.adons.telepat

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Simple test, to try something with Android dependency
 */
@RunWith(AndroidJUnit4::class)
class AndroidSimple {

    @Test
    fun test() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("ru.org.adons.telepat", appContext.packageName)
    }

}
