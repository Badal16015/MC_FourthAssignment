package com.example.badal.fourth_assign;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Button button;
    FragmentTransaction fragmentTransaction;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //android.support.v7.app.ActionBar actionBar=getSupportActionBar();
       //actionBar.setDisplayUseLogoEnabled(true);
       //actionBar.setDisplayShowHomeEnabled(true);
       getSupportActionBar().setTitle("Movies List");
       FragmentManager fm = getSupportFragmentManager();
       Fragment fragment = fm.findFragmentById(R.id.frag_container);

       if (fragment == null) {
           fragment = createFragment();
           fm.beginTransaction()
                   .add(R.id.frag_container, fragment)
                   .commit();
       }
    }

    public Fragment createFragment() {
        return new MoviesListFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
       return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id=item.getItemId();
        if (id==R.id.add_icon){
            startActivity(new Intent(this,AddItem.class));
        }
        return true;
    }
}
