package com.example.badal.fourth_assign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private static final String ARG_MOVIE_NAME = "movie_name";
    private Movies movies;
    private EditText mtitlefield;
    private EditText mactorfield;
    private EditText mactressfield;

    public static MovieFragment newInstance(String mtitle){
        Bundle args = new Bundle();
        //args.putSerializable(ARG_MOVIE_NAME, mtitle);
        args.putCharSequence(ARG_MOVIE_NAME, mtitle);
        MovieFragment fragment=new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //String m_tit = (String) getArguments().getCharSequence(ARG_MOVIE_NAME);
        String m_ntitle = (String) getArguments().getCharSequence(ARG_MOVIE_NAME);
        movies=MovieTheater.get(getActivity()).getMovie(m_ntitle);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_movie, container, false);
        mtitlefield=(EditText) v.findViewById(R.id.mve_title);
        mactorfield=(EditText) v.findViewById(R.id.actorname);
        mactressfield=(EditText) v.findViewById(R.id.actressname);
        mtitlefield.setText(movies.getMtitle());
        mactorfield.setText(movies.getActorname());
        mactressfield.setText(movies.getActressname());
        mtitlefield.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    movies.setMtitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mactorfield.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                movies.setActorname(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mactressfield.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                movies.setActressname(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return v;
    }

}
