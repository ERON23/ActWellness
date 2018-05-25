package com.example.eronmac.actwellness;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        rb = (RatingBar) findViewById(R.id.ratingBar);
        final EditText to = (EditText) findViewById(R.id.name);
        final EditText subject = (EditText) findViewById(R.id.email);
        final EditText message = (EditText) findViewById(R.id.message);



        Button sendE = (Button) findViewById(R.id.sendEmail);
        sendE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toS = to.getText().toString();
                String subS = subject.getText().toString();
                String mesS = message.getText().toString();

                final Intent email =new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{toS});
                email.putExtra(Intent.EXTRA_SUBJECT,subS);
                email.putExtra(Intent.EXTRA_TEXT,mesS);

                rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        email.putExtra("rating ", rating);
                    }
                });

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose app to send mail"));

            }
        });
    }
}

