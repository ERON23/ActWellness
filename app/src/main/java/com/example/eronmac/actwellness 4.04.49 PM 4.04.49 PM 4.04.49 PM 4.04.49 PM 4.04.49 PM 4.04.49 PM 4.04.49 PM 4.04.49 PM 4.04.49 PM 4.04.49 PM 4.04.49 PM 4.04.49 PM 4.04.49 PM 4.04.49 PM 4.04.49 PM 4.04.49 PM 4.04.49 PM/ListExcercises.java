package com.example.eronmac.actwellness;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by zaira on 4/19/2017.
 */

public class ListExcercises extends AppCompatActivity{
    private ListView lvExcercise;
    private ExcerciseAdapter adapter;
    private List<Excercises> mExcerciseList;
    private DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_excercise);

        lvExcercise = (ListView)findViewById(R.id.listview_product);
        mDBHelper = new DatabaseHelper(this);
        //btnAdd = (Button)findViewById(R.id.btnAdd);

        //Check database exists
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if(!database.exists()){
            mDBHelper.getReadableDatabase();
            //Copy database
            if(copyDatabase(this)){
                Toast.makeText(this, "Copy database success", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        //
        mExcerciseList = mDBHelper.getListExcercise();
        adapter = new ExcerciseAdapter(this, mExcerciseList);
        lvExcercise.setAdapter(adapter);

    }

    private boolean copyDatabase(Context context){
        try{
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBPATH + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length =0;
            while((length = inputStream.read(buff))>0){
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.v("ListExcercise", "DB copied");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
