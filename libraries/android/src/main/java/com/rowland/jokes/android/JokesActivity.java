package com.rowland.jokes.android;

import android.os.Bundle;
import android.widget.TextView;

import com.rowland.common.ui.activities.BaseToolBarActivity;


public class JokesActivity extends BaseToolBarActivity {

    // Logging tracker for this class
    private final String LOG_TAG = JokesActivity.class.getSimpleName();

    public final static String INTENT_DELIVERED_JOKE = "INTENT_DELIVERED_JOKES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        // Acquire the joke intent
        String joke = getIntent().getStringExtra(INTENT_DELIVERED_JOKE);
        TextView JokeTextView = (TextView) findViewById(R.id.jokes_textview);
        JokeTextView.setText(joke);
    }
}
