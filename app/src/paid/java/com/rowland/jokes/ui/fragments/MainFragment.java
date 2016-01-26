package com.rowland.jokes.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rowland.jokes.R;

import butterknife.ButterKnife;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    // Logging tracker for this class
    private final String LOG_TAG = MainFragment.class.getSimpleName();

    public MainFragment() {
    }

    public static MainFragment newInstance(Bundle args) {
        MainFragment fragment = new MainFragment();
        if (args != null) {
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        // Initialize the views
        ButterKnife.bind(this, rootView);
        // Return the view for this fragment
        return rootView;
    }
}
