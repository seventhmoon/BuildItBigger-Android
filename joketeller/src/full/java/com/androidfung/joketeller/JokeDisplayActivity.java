package com.androidfung.joketeller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Intent intent = getIntent();
        String message = intent.getStringExtra("JOKE_MESSAGE");

        TextView textViewJoke = (TextView) findViewById(R.id.textview_joke);
        if (message != null) {
            textViewJoke.setText(message);
        }
    }
}
