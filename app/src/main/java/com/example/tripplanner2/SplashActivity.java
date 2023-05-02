package com.example.tripplanner2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.logging.LogRecord;

public class SplashActivity extends AppCompatActivity {



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_layout);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
               startActivity(intent);
               finish();

           }
       },3000);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


    }
}