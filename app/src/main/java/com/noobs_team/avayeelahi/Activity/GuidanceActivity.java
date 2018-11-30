package com.noobs_team.avayeelahi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.noobs_team.avayeelahi.R;

public class GuidanceActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbarGuidence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidance);

        toolbarGuidence = findViewById(R.id.toolbar_guidence);
        toolbarGuidence.setTitle(R.string.app_activity_guide_compass);
        setSupportActionBar(toolbarGuidence);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarGuidence.setTitleTextColor(getResources().getColor(R.color.textTitleColor));

        //rahnamaye darbareh ma

    }
}
