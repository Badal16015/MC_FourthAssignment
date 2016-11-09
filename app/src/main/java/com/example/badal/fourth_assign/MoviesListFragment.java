package com.example.badal.fourth_assign;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesListFragment extends Fragment {
    RecyclerView mMoviesRecycler;
    private MovieAdapter mAdapter;
    private int[] imageresources={R.drawable.sultan_poster,R.drawable.adhm_poster,R.drawable.airlift_poster,R.drawable.talaashposter,R.drawable.tamshaposter,R.drawable.fanposter};
    private static final int REQUEST_MOVIE = 1;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private static Bundle mBundleRecyclerViewState;
    MovieTheater movieTheater;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_movies_list,container,false);
        mMoviesRecycler=(RecyclerView) view.findViewById(R.id.movies_recycler_view);
        mMoviesRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();

    }

    private class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        Movies movies=new Movies();
        public MovieHolder(View itemView) {
            super(itemView);
            mTitleTextView=(TextView) itemView.findViewById(R.id.mname_textView);
            itemView.setOnClickListener(this);
        }
        public void bindMovie(Movies movie) {
            this.movies=movie;
            mTitleTextView.setText(movies.getMtitle());
        }

        @Override
        public void onClick(View view) {
           //Intent intent=new Intent(getActivity(),MovieActivity.class);
            Intent intent=MoviePager.newIntent(getActivity(),movies.getMtitle());
            startActivityForResult(intent,REQUEST_MOVIE);
        }
    }

private class MovieAdapter extends RecyclerView.Adapter<MovieHolder>{
    private List<Movies> mmovies;
    public MovieAdapter(List<Movies> mov){
        this.mmovies=mov;
    }
    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater.inflate(R.layout.list_item_movies,parent,false);
        //.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        Movies movies=mmovies.get(position);
        //holder.mTitleTextView.setText(crime.getTitle());
        holder.bindMovie(movies);

    }

    @Override
    public int getItemCount() {
        return mmovies.size();
    }
}
    private void updateUI() {

        MovieTheater mtheater = MovieTheater.get(getActivity());
        List<Movies> movies = mtheater.getMovies();

        if (mAdapter == null) {
            mAdapter = new MovieAdapter(movies);
            mMoviesRecycler.setAdapter(mAdapter);
        }
        else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_MOVIE){

        }
    }




}




