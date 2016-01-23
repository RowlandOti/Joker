package com.rowland.jokes.backend;

import com.rowland.jokes.JokesVendor;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private JokesVendor jokeVendor;

    public MyBean() {
        jokeVendor = new JokesVendor();
    }

    public String getJoke() {
        return jokeVendor.getRandomJoke();
    }
}