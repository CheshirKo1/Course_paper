package com.example.kyrsovaya2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private TextView usernameText;
    private TextView usernameRights;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        usernameText = findViewById(R.id.username_text_login);
        usernameRights = findViewById(R.id.username_rights);
        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("login");
            String EmailAdd = intent.getStringExtra("rights");
            usernameText.setText(username);
            usernameRights.setText(EmailAdd);
        }
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        // Handle profile selection
                        return true;
                    case R.id.add:
                        // Handle add selection
                        return true;
                    case R.id.find:
                        // Handle find selection
                        return true;
                    case R.id.gall_id:
                        // Handle gallery selection
                        Intent intent = new Intent(Profile.this, Gallery.class);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.profile);
    }
}