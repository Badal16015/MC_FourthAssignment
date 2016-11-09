package com.example.badal.fourth_assign;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MovieActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE_TITLE ="com.example.badal.fourth_assign.MovieActivity";
    public static Intent newIntent(Context packageContext, String movie_title) {
        Intent intent = new Intent(packageContext,MovieActivity.class);
        intent.putExtra(EXTRA_MOVIE_TITLE,movie_title);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

    }

    public Fragment createFragment() {
       String movietit= (String) getIntent().getCharSequenceExtra(EXTRA_MOVIE_TITLE);
        return MovieFragment.newInstance(movietit);
    }
}