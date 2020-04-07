package com.example.sqlproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TestDataBase extends SQLiteOpenHelper {
    String TABLE_NAME = "student.db";

    public TestDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name  TEXT," +
                "family TEXT," +
                "grade INTEGER" +
                ")";
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  void insetIntoDb(String name , String family,int grade){
        String INSERT_INTO_DB = "INSERT INTO" +TABLE_NAME + "(name,family,grade) VALUES (" +
              "'" + name + "'" + "," +
             "'" + family + "'" + "," +
                grade
                + ")";

        SQLiteDatabase database =  this.getWritableDatabase();
        database.execSQL(INSERT_INTO_DB);
        database.close();
    }
    public String getAllName(){
        String GET_ALL_NAME = " SELECT name FROM " + TABLE_NAME;
        String names = "";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c =database.rawQuery(GET_ALL_NAME,null);
        while (c.moveToNext()){
            names = names + c.getString(0) +"\n";
        }
        database.close();
        return names;
    }
}
