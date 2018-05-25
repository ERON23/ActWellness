package com.example.eronmac.actwellness;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListSleepActivity extends AppCompatActivity {
    ListView listView ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sleep);

        // Get stuff from database:
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getApplicationContext());
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.COL_WHAT,
                FeedReaderContract.FeedEntry.COL_WHEN,
        };

        // Filter results WHERE "title" = 'My Title'
        //String selection = FeedReaderContract.FeedEntry.COL_DATE + " = ?";
        //String[] selectionArgs = { "My Title" };
        String selection = null;
        String[] selectionArgs = null;

        String sortOrder = FeedReaderContract.FeedEntry.COL_WHEN + " DESC";
        String limit = "10";
        String groupBy = null;
        String having = null;

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                groupBy,                                  // don't group the rows
                having,                                   // don't filter by row groups
                sortOrder,                                // The sort order
                limit
        );

        List<Long> itemIds = new ArrayList<>();
        List<String> itemWhens = new ArrayList<>();
        List<String> itemWhats = new ArrayList<>();

        while(cursor.moveToNext()) {

            int id_index = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID);
            long id_val = cursor.getLong(id_index);
            itemIds.add(id_val);

            int when_index = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COL_WHEN);
            String when_val = cursor.getString(when_index);
            itemWhens.add(when_val);

            int what_index = cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COL_WHAT);
            String what_val = cursor.getString(what_index);
            itemWhats.add(what_val);
        }
        cursor.close();



        List<String> values = new ArrayList<>();

        Log.d("LIST", "We got so many items: "+Integer.toString(itemIds.size()));

        for (int i = 0; i < itemIds.size(); i++) {
            String when = itemWhens.get(i);
            String what = itemWhats.get(i);
            long id = itemIds.get(i);

            values.add(what + " : " + when);
        }



        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        SleepAdapter my_adapter = new SleepAdapter(this, itemWhats, itemWhens);

        // Assign adapter to ListView
        listView.setAdapter(my_adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d("LIST >>>>", "item: "+position+" id: "+id);

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });
    }

}
