package com.example.kyrsovaya2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.google.android.material.datepicker.MaterialTextInputPicker;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {
    Button button_sing_up, button_sing_in;
    RelativeLayout root;
    DBHelper dbHelper;
    TextInputLayout login_text;
    TextInputLayout passwd_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_sing_up = findViewById(R.id.button_sing_up);
        button_sing_in = findViewById(R.id.button_sing_in);
        //EditText login_text;
        //EditText passwd_text;
        root = findViewById(R.id.root_element);
        dbHelper = new DBHelper(this); //BD
        //Реализация кнопки регистрации
        button_sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_register_window();
            }
        });
        //Реализация кнопки входа
        button_sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_text = findViewById(R.id.textEditLogin);
                passwd_text = findViewById(R.id.textEditPasswd);
                //check_user(login_text.getText().toString(), passwd_text.getText().toString());
                System.out.println(login_text);
                System.out.println(passwd_text);
            }
        });
    }

    private int check_user(String log, String pass) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int loginIndex = cursor.getColumnIndex(DBHelper.KEY_LOGIN);
            int passwordIndex = cursor.getColumnIndex(DBHelper.KEY_PASSWD);
            do {
                if ((log == cursor.getString(loginIndex)) & (pass == cursor.getString(passwordIndex))) {
                    cursor.close();
                    return 1;
                }
            } while (cursor.moveToNext());
        } else {
            Log.d("mLog","0 rows");
            cursor.close();
            return 0;
            }
        return 0;
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

        //Кнопка выхода из меню регистрации
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        //Тестовая кнопка, вывести таблицы пользователей
        dialog.setNeutralButton("Show BD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                SQLiteDatabase database = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();

                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);
                    int loginIndex = cursor.getColumnIndex(DBHelper.KEY_LOGIN);
                    int passwordIndex = cursor.getColumnIndex(DBHelper.KEY_PASSWD);
                    do {
                        Log.d("mLog", "login = " + cursor.getString(loginIndex) +
                                ", email = " + cursor.getString(emailIndex) +
                                ", password = " + cursor.getString(passwordIndex));
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog","0 rows");

                cursor.close();
            }
        });

/*        //Тестовая кнопка, очистить БД
        dialog.setNeutralButton("Del BD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                SQLiteDatabase database = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();

                database.delete(DBHelper.TABLE_CONTACTS, null, null);
            }
        });*/

        //Кнопка подтверждения регистрации
        dialog.setPositiveButton("Sing up", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                SQLiteDatabase database = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();

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
                contentValues.put(DBHelper.KEY_EMAIL, email.getText().toString());
                contentValues.put(DBHelper.KEY_LOGIN, login.getText().toString());
                contentValues.put(DBHelper.KEY_PASSWD, passwd.getText().toString());

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
            }
        });

        dialog.show();
    }
}