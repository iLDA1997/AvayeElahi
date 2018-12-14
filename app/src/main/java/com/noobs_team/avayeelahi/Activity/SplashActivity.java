package com.noobs_team.avayeelahi.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.noobs_team.avayeelahi.R;

public class SplashActivity extends Activity implements Animation.AnimationListener {
    Animation animationFadeOut;
    ImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // load the animation
        animationFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.animation_fade_out);
        // set animation listener
        animationFadeOut.setAnimationListener(this);
        // animation for image
        splash = findViewById(R.id.splash);
        // start the animation
        splash.setVisibility(View.VISIBLE);
        splash.startAnimation(animationFadeOut);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    @Override
    public void onAnimationStart(Animation animation) {}

    @Override
    public void onAnimationEnd(Animation animation) {
        // Start Main Screen
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
        this.finish();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {}
}