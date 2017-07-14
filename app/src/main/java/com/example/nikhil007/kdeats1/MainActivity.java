package com.example.nikhil007.kdeats1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
    // ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // spinner = (ProgressBar)findViewById(R.id.progressBar);

//hi
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(MainActivity.this,Second_ScreenActivity.class);
                MainActivity.this.startActivity(mainIntent);
                finish();
                // WelcomeActivity.this.finish();
            }
        }, 3000);
    }
    public void onBackPressed() {
        finish();

    }

}
