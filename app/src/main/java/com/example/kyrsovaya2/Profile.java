package com.example.kyrsovaya2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    Button button_gallery;
    private TextView usernameText;
    private TextView usernameRights;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button_gallery = findViewById(R.id.gall_id);
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
/*        button_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Gallery.class);
                startActivity(intent);
            }
        });*/
    }
}