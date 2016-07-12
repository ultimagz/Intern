package com.example.intern.intern;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sodajune on 6/24/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "DB_Contact";
    public static final String DBTABLE = "Contact";
    public static final int DBVERSION = 1;


    public static final String contactID = "_id";
    public static final String th_fname = "fistName_TH";
    public static final String th_lname = "lastName_TH";
    public static final String th_nickname = "nickName_TH";
    public static final String en_fname = "fistName_EN";
    public static final String en_lname = "lastName_EN";
    public static final String en_nickname = "nickName_EN";
    public static final String position = "position";
    public static final String email = "email";
    public static final String mobile = "mobile";
    public static final String workphone = "workphone";
    public static final String line = "line";
    public static final String updateTime = "updateTime";

    public DatabaseHelper(Context context) {

        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DBTABLE + " ( " + contactID + " TEXT PRIMARY KEY, " +
                th_fname + " TEXT," +
                th_lname + " TEXT, " +
                th_nickname + " TEXT," +
                en_fname + " TEXT," +
                en_lname + " TEXT," +
                en_nickname + " TEXT," +
                position + " TEXT," +
                email + " TEXT," +
                mobile + " TEXT," +
                workphone + " TEXT," +
                line + " TEXT," +
                updateTime + " TEXT)");

        Log.w("CREATE TABLE", "Create Table Successfully.");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


}
