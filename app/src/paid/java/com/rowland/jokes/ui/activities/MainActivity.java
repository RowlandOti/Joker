package com.rowland.jokes.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rowland.common.ui.activities.BaseToolBarActivity;
import com.rowland.jokes.R;
import com.rowland.jokes.android.JokesActivity;
import com.rowland.jokes.asynctask.EndpointAsyncTask;
import com.rowland.jokes.ui.fragments.MainFragment;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseToolBarActivity {

    // Logging tracker for this class
    private final String LOG_TAG = MainActivity.class.getSimpleName();

    // ButterKnife bound views
    @Bind(R.id.progressbar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout
        setContentView(R.layout.activity_main);
        // Initialize the views
        ButterKnife.bind(this);
        // However, if we're being restored from a previous state, then we don't need to do anything
        // and should return or else we could end up with overlapping fragments.
        if (savedInstanceState != null) {
            return;
        }
        // Create the detail fragment and add it to the activity
        // using a fragment transaction.
        else {
            // Pass bundle to the fragment
            showMainFragment(null);
        }
    }

    // Insert the MainFragment
    private void showMainFragment(Bundle args) {
        // Acquire the Fragment manger
        FragmentManager fm = getSupportFragmentManager();
        // Begin the transaction
        FragmentTransaction ft = fm.beginTransaction();
        // Create new fragment
        MainFragment mainFragment = MainFragment.newInstance(args);
        // Prefer replace() over add() see <a>https://github.com/RowlandOti/PopularMovies/issues/1</a>
        ft.replace(R.id.fragment_container, mainFragment);
        ft.commit();
    }

    public void tellJoke(View view) {
        //
        beginJoking();
    }

    private void beginJoking() {

        Toast.makeText(this, "Working on It", Toast.LENGTH_SHORT).show();

        new EndpointAsyncTask(this, mProgressBar, new onFinishCallBack() {
            @Override
            public void showActivity(Context context, String result) {
                // Acquire new Intent object
                Intent intent = new Intent(context, JokesActivity.class);
                // Send the result to the called activity
                intent.putExtra(JokesActivity.INTENT_DELIVERED_JOKE, result);
                // Retain a previous activity
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }).execute();
    }


    public interface onFinishCallBack {

        void showActivity(Context context, String result);
    }


}
