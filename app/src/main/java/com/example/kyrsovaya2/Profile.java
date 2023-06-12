package com.example.kyrsovaya2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Profile extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Button bottom_admin;
    private TextView usernameText;
    private TextView usernameRights;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottom_admin = findViewById(R.id.Edit_Admin_button);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        usernameText = findViewById(R.id.username_text_login);
        usernameRights = findViewById(R.id.username_rights);
        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("login");
            String Rights = intent.getStringExtra("rights");
            usernameText.setText(username);
            usernameRights.setText(Rights);
            if (username.equals("admin") && Rights.equals("Administrator")) {
                bottom_admin.setVisibility(View.VISIBLE);
            } else { bottom_admin.setVisibility(View.INVISIBLE); }
        }
        bottom_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database_window();
            }
        });

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

    private void database_window() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Sing Up");
        dialog.setMessage("Enter data for registration");
        LayoutInflater inflater = LayoutInflater.from(this);
        View database_window = inflater.inflate(R.layout.register_window, null);
        dialog.setView(database_window);
        //final EditText email = register_window.findViewById(R.id.email_field);
        //final EditText passwd = register_window.findViewById(R.id.password_field);
        //final EditText login = register_window.findViewById(R.id.login_field);

        //Кнопка выхода из меню регистрации
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.show();
    }
}