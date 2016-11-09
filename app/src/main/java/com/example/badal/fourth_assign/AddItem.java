package com.example.badal.fourth_assign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AddItem extends AppCompatActivity {
    Button addbutton;
    EditText addnewmovie;
    MovieTheater movieTheater;
    EditText addnewactor;
    EditText addnewactress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getSupportActionBar().setTitle("Add Movies");
        addbutton=(Button)findViewById(R.id.add_movie);
        addnewmovie=(EditText)findViewById(R.id.new_movie);
        addnewactor=(EditText) findViewById(R.id.nactorname);
        addnewactress=(EditText) findViewById(R.id.nactressname);
        movieTheater=new MovieTheater(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addnewmovie.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Movie Title Empty", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    for (Movies movies : movieTheater.mmovies) {
                        if (movies.getMtitle().equals(addnewmovie.getText().toString())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Movie Already Exists", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                    }
                    boolean isadded = movieTheater.mmovies.add(new Movies(addnewmovie.getText().toString(),addnewactor.getText().toString(),addnewactress.getText().toString()));
                    if (isadded == true) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Movie Added Successfully", Toast.LENGTH_SHORT);
                        toast.show();
                        addnewmovie.setText("");
                        addnewactor.setText("");
                        addnewactress.setText("");

                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
    }
}
