package com.example.afraaaldhaheri.ateducom;



import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashpage extends AppCompatActivity {

   /* public static final int STARTUP_DELAY = 300;
    public static final int ANIM_ITEM_DURATION = 1000;
    public static final int ITEM_DELAY = 300;
    private boolean animationStarted = false;*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
        Intent intent = new Intent(splashpage.this, loginpage.class);
        startActivity(intent);
        finish();       finish();
            }
        }, 4000);

    }}
