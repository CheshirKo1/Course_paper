package com.example.kyrsovaya2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private TextView usernameText;
    private TextView usernameRights;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        usernameText = findViewById(R.id.username_text_login);
        usernameRights = findViewById(R.id.username_rights);
        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("login");
            String EmailAdd = intent.getStringExtra("rights");
            usernameText.setText(username);
            usernameRights.setText(EmailAdd);
        }
    }
}