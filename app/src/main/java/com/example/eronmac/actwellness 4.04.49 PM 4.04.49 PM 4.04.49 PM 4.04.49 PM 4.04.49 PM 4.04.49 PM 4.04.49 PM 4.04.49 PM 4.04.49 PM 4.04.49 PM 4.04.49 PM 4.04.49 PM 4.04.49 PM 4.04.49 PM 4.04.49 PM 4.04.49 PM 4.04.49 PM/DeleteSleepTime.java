package com.example.eronmac.actwellness;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class DeleteSleepTime extends AppCompatActivity {

    private FeedReaderDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletetimes);

        mDbHelper = new FeedReaderDbHelper(getApplicationContext());
    }

    public void tap_delete_all_btn(View view) {
        Log.d("SETTINGS >>> ", "TAP DELETE ALL");
        getApplicationContext().deleteDatabase(FeedReaderDbHelper.DATABASE_NAME);


        Context context = getApplicationContext();
        CharSequence text = "Database deleted!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void tap_delete_last_btn(View view) {

        Log.d("SETTINGS >>> ", "TAP DELETE LAST");

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        String table = FeedReaderContract.FeedEntry.TABLE_NAME;
        String[] columns = {FeedReaderContract.FeedEntry._ID};
        String whereClause = null;
        String[] whereArgs = null;
        String orderBy = FeedReaderContract.FeedEntry.COL_WHEN+" DESC";
        String limit = "1";

        // FIRST, GET ID OF LAST ENTRY
        Cursor cursor = db.query(table, columns, whereClause, whereArgs, null, null, orderBy, limit);

        if (cursor.moveToNext()) {
            int id_index = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID);
            long id_val = cursor.getLong(id_index);

            Log.d("SETTINGS >>>", " DELETE LAST: GOT AN ID: "+id_val);


            whereClause = FeedReaderContract.FeedEntry._ID +" = "+id_val;
            whereArgs = null;

            db.delete(table, whereClause, whereArgs);


            Context context = getApplicationContext();
            CharSequence text = "Deleted last entry!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "No entries found!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}
