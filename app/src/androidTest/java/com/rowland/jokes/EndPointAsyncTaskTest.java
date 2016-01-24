package com.rowland.jokes;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.text.TextUtils;
import android.widget.ProgressBar;

import com.rowland.jokes.asynctask.EndpointAsyncTask;
import com.rowland.jokes.ui.activities.MainActivity;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Oti Rowland on 1/24/2016.
 */

public class EndPointAsyncTaskTest extends InstrumentationTestCase {

    private static boolean mCalled;
    private String mResult = null;
    private CountDownLatch mSignal = null;

    @Override
    protected void setUp() throws Exception {
        mSignal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        mSignal.countDown();
    }

    public void testEndpointAsyncTask() throws InterruptedException {

        new EndpointAsyncTask(getInstrumentation().getContext(), new ProgressBar(getInstrumentation().getContext()), new MainActivity.onFinishCallBack() {
            @Override
            public void showActivity(Context context, String result) {
                mResult = result;
                mSignal.countDown();
                mCalled = true;
            }
        }).execute();
        mSignal.await();

        assertFalse(TextUtils.isEmpty(mResult));
        assertTrue(mCalled);
    }
}

