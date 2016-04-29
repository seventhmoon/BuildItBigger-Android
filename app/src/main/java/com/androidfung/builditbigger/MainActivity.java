package com.androidfung.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.androidfung.joketeller.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity {

//    private TextView mTextViewJoke;

    private EndpointsAsyncTask.Callback mAsyncTaskCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        mTextViewJoke = (TextView) findViewById(R.id.textview_joke);
        setSupportActionBar(toolbar);

        mAsyncTaskCallback = new EndpointsAsyncTask.Callback(){
            @Override
            public void onTaskFinished(String result) {
                Intent intent = new Intent(getApplicationContext(), JokeDisplayActivity.class);
                intent.putExtra("JOKE_MESSAGE", result);
                startActivity(intent);
            }
        };

        loadJoke();



    }
    private void loadJoke(){
        Pair<Context, String> pair = new Pair<>(getApplicationContext(), "");
        new EndpointsAsyncTask(mAsyncTaskCallback).execute(pair);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }



}
