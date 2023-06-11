package com.example.kyrsovaya2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MireaVideoDB";
    public static final String DATABASE_CONTENT = "MireaVideoContent";

    public static final String TABLE_CONTACTS = "contacts";
    public static final String TABLE_INFO = "info";

    public static final String KEY_CONTENTNAME = "contentname";

    public static final String KEY_EMAIL = "email";
    public static final String KEY_LOGIN = "login";
    public static final String KEY_PASSWD = "passwd";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CONTACTS + " (" + KEY_EMAIL
                + " text," + KEY_LOGIN + " text primary key," + KEY_PASSWD + " text" + ")");

        db.execSQL("create table " + TABLE_INFO + " (" + KEY_CONTENTNAME
                + " text primary key" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_CONTACTS);

        onCreate(db);
    }
}
