package com.example.eronmac.actwellness;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zaira on 4/13/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "sample";
    public static final String DBPATH = "/data/data/com.example.eronmac.actwellness/databases/";
    private Context mycontext;
    private SQLiteDatabase mExDB;

    public DatabaseHelper (Context context){
        super(context, DBNAME, null, 1);
        this.mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase(){
        String dbpath = mycontext.getDatabasePath(DBNAME).getPath();
        if(mExDB != null && mExDB.isOpen()){
            return ;
        }
        mExDB = SQLiteDatabase.openDatabase(dbpath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mExDB != null){
            mExDB.close();
        }
    }

    public List<Excercises> getListExcercise() {
        Excercises excercise = null;
        List<Excercises> excercisesList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mExDB.rawQuery("SELECT * FROM EXCERCISES", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            excercise = new Excercises(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            excercisesList.add(excercise);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return excercisesList;

    }
}
