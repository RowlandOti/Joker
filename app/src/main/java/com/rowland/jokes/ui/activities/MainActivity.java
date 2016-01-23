package com.rowland.jokes.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rowland.common.ui.activities.BaseToolBarActivity;
import com.rowland.jokes.R;
import com.rowland.jokes.ui.fragments.MainFragment;


public class MainActivity extends BaseToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout
        setContentView(R.layout.activity_main);
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


    public void tellJoke(View view){
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }


}
