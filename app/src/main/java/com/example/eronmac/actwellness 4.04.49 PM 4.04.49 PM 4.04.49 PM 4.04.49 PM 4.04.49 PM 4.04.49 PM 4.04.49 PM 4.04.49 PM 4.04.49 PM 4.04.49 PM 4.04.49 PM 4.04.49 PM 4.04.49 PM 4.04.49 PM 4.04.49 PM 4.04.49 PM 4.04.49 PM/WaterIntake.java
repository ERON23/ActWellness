package com.example.eronmac.actwellness;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by Danny on 4/29/17.
 */

public class WaterIntake extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);

        //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.tv);
        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);

        //Set TextView text color
        tv.setTextColor(Color.parseColor("#ffd32b3b"));

        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        np.setMinValue(0);
        //Specify the maximum value/number of NumberPicker
        np.setMaxValue(20);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        np.setWrapSelectorWheel(true);

        //Set a value change listener for NumberPicker
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                tv.setText("Selected: " + newVal + " cups of water");
            }
        });
    }
    public void gotoMealTracking (View view){

        Intent intent = new Intent(WaterIntake.this, MealTracking.class);
        startActivity(intent);
    }


}