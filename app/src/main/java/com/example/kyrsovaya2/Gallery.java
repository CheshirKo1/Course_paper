package com.example.kyrsovaya2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Gallery extends Activity {
    private BottomNavigationView bottomNavigationView;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        Intent intentProf = new Intent(Gallery.this, Profile.class);
                        startActivity(intentProf);
                        return true;
                    case R.id.add:
                        // Handle add selection
                        return true;
                    case R.id.find:
                        // Handle find selection
                        Intent intentFind = new Intent(Gallery.this, FindActivity.class);
                        startActivity(intentFind);
                        return true;
                    case R.id.gall_id:
                        // Handle gallery selection
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.gall_id);
    }


    public void biggerView(View v)
    {
        im=(ImageView)findViewById(R.id.selected);

        switch (v.getId())
        {
            case R.id.image1: im.setImageResource(R.drawable.im1);
                break;
            case R.id.image2: im.setImageResource(R.drawable.im2);
                break;
            case R.id.image3: im.setImageResource(R.drawable.im3);
                break;
            case R.id.image4: im.setImageResource(R.drawable.im4);
                break;
            case R.id.image5: im.setImageResource(R.drawable.im5);
                break;
            case R.id.image6: im.setImageResource(R.drawable.im6);
                break;
            case R.id.image7: im.setImageResource(R.drawable.im7);
                break;
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
}