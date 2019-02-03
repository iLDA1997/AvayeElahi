package com.noobs_team.avayeelahi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.noobs_team.avayeelahi.R;

public class AlertAndAzan extends AppCompatActivity {

    Toolbar toolbarAlertAndAzan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_and_azan);

        toolbarAlertAndAzan = findViewById(R.id.toolbar_alert_and_azan);
        setSupportActionBar(toolbarAlertAndAzan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


}
