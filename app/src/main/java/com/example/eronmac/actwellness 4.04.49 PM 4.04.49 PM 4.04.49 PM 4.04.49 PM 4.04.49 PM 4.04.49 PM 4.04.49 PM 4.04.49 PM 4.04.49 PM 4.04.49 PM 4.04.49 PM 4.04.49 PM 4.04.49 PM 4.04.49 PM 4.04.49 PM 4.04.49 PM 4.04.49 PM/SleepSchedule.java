package com.example.eronmac.actwellness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.util.Calendar;

public class SleepSchedule extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "MESSAGE";
    private FeedReaderDbHelper mDbHelper;
    // The above creates or gets an existing database, as defined in FeedReaderContract

    private String awake_or_sleep;
    private Timestamp picked_time;
    private int picked_hours;
    private int picked_minutes;
    private Button setting_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep_schedule_menu);

        //btnAddItems = (Button) findViewById(R.id.add_item_screen);
        setting_button = (Button) findViewById(R.id.settings_btn);
        //moon = (ImageView) findViewById(R.id.imageView5);

        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newintent2 = new Intent(SleepSchedule.this, DeleteSleepTime.class);
                startActivity(newintent2);
            }
        });


        mDbHelper = new FeedReaderDbHelper(getApplicationContext());
    }

    private boolean db_new_entry(String what, DateTime when) {

        Log.d("NEW--", "new entry: what: "+what);


        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Format time
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        String formatted_when = fmt.print(when);

        Log.d("NEW--", "new entry: when: "+formatted_when);

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COL_WHAT, what);
        values.put(FeedReaderContract.FeedEntry.COL_WHEN, formatted_when);

        long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);


        Context context = getApplicationContext();
        CharSequence text = "New entry added!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        return true;
    }

    private boolean db_get_list(int length) {
        return false;
    }

    public boolean db_clear_all() {
        return false;
    }





    public void tap_sleep_btn(View view) {
        Log.d("MAIN >>> ", "TAP SLEEP");

        DateTime when = new DateTime();

        db_new_entry("Slept @", when);
    }

    public void tap_awake_btn(View view) {
        Log.d("MAIN >>> ", "TAP AWAKE");

        DateTime when = new DateTime();

        db_new_entry("Woke up @", when);
    }

    public void tap_sleep_then_btn(View view) {
        Log.d("MAIN >>> ", "TAP SLEEP THEN");

        awake_or_sleep = "Slept @";

        showTimePickerDialog(view);
    }

    public void tap_awake_then_btn(View view) {
        Log.d("MAIN >>> ", "TAP AWAKE THEN");

        awake_or_sleep = "Woke up @";

        showTimePickerDialog(view);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void set_time(int hour, int minute, View view) {
        Log.d("MAIN >>> ", "SET TIME TO: "+hour+":"+minute);

        picked_hours = hour;
        picked_minutes = minute;

        showDatePickerDialog(view);
    }

    public void set_date(int year, int month, int day) {
        Log.d("MAIN >>> ", "SET DATETIME TO: year: "+year+" month: "+month+" day: "+day);

        DateTime when = new DateTime(year, month, day, picked_hours, picked_minutes);

        if (!(awake_or_sleep == "Slept @" || awake_or_sleep == "Woke up @")) {
            Log.d("MAIN >>> ", "ERROR awake or sleep not properly set: " + awake_or_sleep.toString());
            return;
        }

        db_new_entry(awake_or_sleep, when);
    }




    public void tap_history_btn(View view) {
        Intent intent = new Intent(this, ListSleepActivity.class);
        startActivity(intent);
    }




    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            ((SleepSchedule)getActivity()).set_date(year, month+1, day);
        }
    }


    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            ((SleepSchedule)getActivity()).set_time(hourOfDay, minute, view);
        }


    }



}