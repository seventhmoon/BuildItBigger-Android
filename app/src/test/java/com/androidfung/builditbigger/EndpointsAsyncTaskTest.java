package com.androidfung.builditbigger;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by fung on 4/29/2016.
 */
public class EndpointsAsyncTaskTest {



    private static final String LOG_TAG = EndpointsAsyncTaskTest.class.getSimpleName();
    private static final int THREAD_TIMER = 8000;

    @Test
    public void testDoInBackground() throws Exception {

        EndpointsAsyncTask task = new EndpointsAsyncTask(new EndpointsAsyncTask.Callback() {
            @Override
            public void onTaskFinished(String result) {
                Log.i(LOG_TAG, "testDoInBackground(): EndpointsAsyncTask test complete. The joke result is: " + result);
                assertTrue("testDoInBackground(): ERROR: Joke was: " + result, result.contains("Why"));
            }
        });
        task.execute();

        // FIX: This is needed to handle an execution delay, particularly for emulators.
        Thread.sleep(THREAD_TIMER);
    }
}
