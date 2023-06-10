package com.example.kyrsovaya2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.material.datepicker.MaterialTextInputPicker;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    Button button_sing_up, button_sing_in;
    RelativeLayout root;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_sing_up = findViewById(R.id.button_sing_up);
        button_sing_in = findViewById(R.id.button_sing_in);
        root = findViewById(R.id.root_element);
        dbHelper = new DBHelper(this); //BD

        button_sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_register_window();
            }
        });
    }

    private void show_register_window() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Sing Up");
        dialog.setMessage("Enter data for registration");

        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.register_window, null);
        dialog.setView(register_window);

        final EditText email = register_window.findViewById(R.id.email_field);
        final EditText passwd = register_window.findViewById(R.id.password_field);
        final EditText login = register_window.findViewById(R.id.login_field);

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Sing up", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())) {
                    Snackbar.make(root, "Error: Enter your email", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(login.getText().toString())) {
                    Snackbar.make(root, "Error: Enter your login", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passwd.getText().toString())) {
                    Snackbar.make(root, "Error: Enter your password", Snackbar.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        dialog.show();

    }
}