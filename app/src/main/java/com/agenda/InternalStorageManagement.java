package com.agenda;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InternalStorageManagement extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "task.db";
    public static final String TABLE_NAME = "task_table";
    public static final String COL_1 = "TITLE";
    public static final String COL_2 = "DUE";
    public static final String COL_3 = "PRIORITY";

    public InternalStorageManagement(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (TITLE TEXT, DUE TEXT, " + "PRIORITY INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String title, String due, int priority)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, title);
        contentValues.put(COL_2, due);
        contentValues.put(COL_3, priority);

        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1;
    }
}
