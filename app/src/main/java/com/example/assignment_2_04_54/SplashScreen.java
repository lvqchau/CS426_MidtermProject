package com.example.assignment_2_04_54;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.assignment_2_04_54.ui.login.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    ImageView logo;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        logo = findViewById(R.id.splashlogo);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
        logo.startAnimation(animation);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2800);
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}

