package com.example.eronmac.actwellness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import picturesofmeals.*;

import android.view.View;
import android.widget.*;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MealDetailActivity extends YouTubeBaseActivity {

    //private TextView textViewId;
    private TextView textViewName;
    private TextView textViewDescriptio;
    private TextView textViewCalories;
    private ImageView imageViewPhoto;
    //youtube buttons and player
    YouTubePlayerView mYouTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializeedListener;
    //youtube code


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);
        //youtube code
        btnPlay = (Button) findViewById(R.id.buttonPlay);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);


        mOnInitializeedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("IehX_6FHTNw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        btnPlay .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button to iniitialize video
                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), mOnInitializeedListener);
            }
        });


        //youtube code



        Intent intent = getIntent();
        Meal meal = (Meal) intent.getSerializableExtra("Meal");
        //this.textViewId = (TextView) findViewById(R.id.textViewId);
        //this.textViewId.setText(meal.getId());

        this.textViewName = (TextView) findViewById(R.id.textViewName);
        this.textViewName.setText(meal.getName());

        this.textViewDescriptio = (TextView) findViewById(R.id.textViewDescription);
        this.textViewDescriptio.setText(meal.getDescription());

        this.textViewCalories = (TextView) findViewById(R.id.textViewCalories);
        this.textViewCalories.setText(String.valueOf(meal.getPrice()));

        this.imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        this.imageViewPhoto.setImageResource(meal.getPhoto());

        //this.mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);
        //this.mYouTubePlayerView =setContentView();
    }

}


