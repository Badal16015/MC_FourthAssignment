package com.example.badal.fourth_assign;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Badal on 07-11-2016.
 */
public class MovieTheater {
    private static MovieTheater mmovtheater;
    public static ArrayList<Movies> mmovies;


    public static MovieTheater get(Context context) {
        if (mmovtheater == null) {
            mmovtheater = new MovieTheater(context);
        }
        return mmovtheater;
    }

    public MovieTheater(Context context) {
        mmovies = new ArrayList<>();
        mmovies.add(new Movies("Sultan","Salman Khan","Anushka Sharma"));
       mmovies.add(new Movies("ADHM","Ranbir Kapoor","Anushka Sharma"));
        mmovies.add(new Movies("Airlift","Akshay Kumar","Nimrat Kaur"));
        mmovies.add(new Movies("Talaash","Aamir Khan","Rani Mukherjee"));
        mmovies.add(new Movies("Tamasha","Ranbir Kapoor","Deepika Padukone"));


    }

    public List<Movies> getMovies(){
        return mmovies;
    }

    public Movies getMovie(String title) {
        for (Movies movies : mmovies) {
            if (movies.getMtitle().equals(title)) {
                return movies;
            }
        }
        return null;
    }




}
