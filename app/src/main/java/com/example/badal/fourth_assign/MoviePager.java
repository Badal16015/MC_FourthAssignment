package com.example.badal.fourth_assign;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.UUID;

public class MoviePager extends FragmentActivity {
    private static final String EXTRA_MOVIE_TITLE ="com.example.badal.fourth_assign.MovieActivity";
    private ViewPager mViewPager;
    private List<Movies> mMovies;
    private int[] imageresources={R.drawable.sultan_poster,R.drawable.adhm_poster,R.drawable.airlift_poster,R.drawable.talaashposter,R.drawable.tamshaposter,R.drawable.fanposter};


    public static Intent newIntent(Context packageContext, String titla) {
        Intent intent = new Intent(packageContext, MoviePager.class);
        intent.putExtra(EXTRA_MOVIE_TITLE, titla);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_pager);
        String m_title = (String) getIntent()
                .getCharSequenceExtra(EXTRA_MOVIE_TITLE);
        mViewPager = (ViewPager) findViewById(R.id.activity_movie_pager_view_pager);
        mMovies = MovieTheater.get(this).getMovies();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                 Movies movies = mMovies.get(position);
                return MovieFragment.newInstance(movies.getMtitle());
             }

            @Override
            public int getCount() {
                return mMovies.size();
            }
        });
        for (int i = 0; i < mMovies.size(); i++) {
            if (mMovies.get(i).getMtitle().equals(m_title)) {
                mViewPager.setCurrentItem(i);
                mViewPager.setBackgroundResource(imageresources[i]);
                mViewPager.getBackground().setAlpha(166);
                break;
            }

        }

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.v("name",String.valueOf(position));
                mViewPager.setBackgroundResource(imageresources[position]);
                mViewPager.getBackground().setAlpha(166);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
