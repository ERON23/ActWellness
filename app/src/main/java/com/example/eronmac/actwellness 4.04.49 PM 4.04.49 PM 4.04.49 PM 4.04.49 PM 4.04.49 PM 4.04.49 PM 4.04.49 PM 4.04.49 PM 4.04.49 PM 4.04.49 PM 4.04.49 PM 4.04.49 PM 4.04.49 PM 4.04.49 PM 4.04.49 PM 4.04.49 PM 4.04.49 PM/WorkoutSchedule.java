package com.example.eronmac.actwellness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WorkoutSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_schedule);

    }

   public void gotoListExcercises (View view){
       Intent intent = new Intent(this, ListExcercises.class);
       startActivity(intent);
    }
}
