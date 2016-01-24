package com.rowland.jokes.asynctask;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.rowland.jokes.R;
import com.rowland.jokes.android.JokesActivity;
import com.rowland.jokes.backend.myApi.MyApi;
import com.rowland.jokes.backend.myApi.model.MyBean;
import com.rowland.jokes.ui.activities.MainActivity;

import java.io.IOException;

/**
 *
 */
public class EndpointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    // Logging tracker for this class
    private final String LOG_TAG = EndpointAsyncTask.class.getSimpleName();

    private static MyApi mApi = null;
    private Context mContext;
    private String mResult;
    private ProgressBar mProgressBar;
    private MainActivity.onFinishCallBack mCallBack;

    public EndpointAsyncTask(Context context, ProgressBar progressBar, MainActivity.onFinishCallBack callBack) {
        this.mContext = context;
        this.mProgressBar = progressBar;
        this.mCallBack = callBack;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        // Ensure we only have one instance
        if (mApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(mContext.getString(R.string.api_root_endpoint));
            mApi = builder.build();
        }
        try {
            return mApi.deliverJoke(new MyBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        mResult = result;
        mCallBack.showActivity(mContext, mResult);
    }
}