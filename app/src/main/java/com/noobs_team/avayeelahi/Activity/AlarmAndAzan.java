package com.noobs_team.avayeelahi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.marcinmoskala.arcseekbar.ArcSeekBar;
import com.noobs_team.avayeelahi.R;

import java.util.Objects;

public class AlarmAndAzan extends AppCompatActivity {

    Toolbar toolbarAlarmAndAzan;
    Switch switchAlarmOne, switchAlarmTwo, switchAlarmThree, switchAlarmFour, switchAlarmFive, switchAlarmSix;
    ArcSeekBar seekArcOne, seekArcTwo, seekArcThree, seekArcFour, seekArcFive, seekArcSix;
    TextView tvNumAlarmOne,tvNumAlarmTwo,tvNumAlarmThree,tvNumAlarmFour,tvNumAlarmFive,tvNumAlarmSix;
    TextView tvNameAlarmOne,tvNameAlarmTwo,tvNameAlarmThree,tvNameAlarmFour,tvNameAlarmFive,tvNameAlarmSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_and_azan);

        toolbarAlarmAndAzan = findViewById(R.id.toolbar_alert_and_azan);
        setSupportActionBar(toolbarAlarmAndAzan);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        seekArcOne = findViewById(R.id.seek_arc_one);
        seekArcTwo = findViewById(R.id.seek_arc_two);
        seekArcThree = findViewById(R.id.seek_arc_three);
        seekArcFour = findViewById(R.id.seek_arc_four);
        seekArcFive = findViewById(R.id.seek_arc_five);
        seekArcSix = findViewById(R.id.seek_arc_six);
        switchAlarmOne = findViewById(R.id.switch_alarm_one);
        switchAlarmTwo = findViewById(R.id.switch_alarm_two);
        switchAlarmThree = findViewById(R.id.switch_alarm_three);
        switchAlarmFour = findViewById(R.id.switch_alarm_four);
        switchAlarmFive = findViewById(R.id.switch_alarm_five);
        switchAlarmSix = findViewById(R.id.switch_alarm_six);
        tvNameAlarmOne = findViewById(R.id.tv_name_alarm_one);
        tvNameAlarmTwo = findViewById(R.id.tv_name_alarm_two);
        tvNameAlarmThree = findViewById(R.id.tv_name_alarm_three);
        tvNameAlarmFour = findViewById(R.id.tv_name_alarm_four);
        tvNameAlarmFive = findViewById(R.id.tv_name_alarm_five);
        tvNameAlarmSix = findViewById(R.id.tv_name_alarm_six);
        tvNumAlarmOne = findViewById(R.id.tv_num_alarm_one);
        tvNumAlarmTwo = findViewById(R.id.tv_num_alarm_two);
        tvNumAlarmThree = findViewById(R.id.tv_num_alarm_three);
        tvNumAlarmFour = findViewById(R.id.tv_num_alarm_four);
        tvNumAlarmFive = findViewById(R.id.tv_num_alarm_five);
        tvNumAlarmSix = findViewById(R.id.tv_num_alarm_six);

        switchAlarmOne.setOnClickListener(alarmClick);
        switchAlarmTwo.setOnClickListener(alarmClick);
        switchAlarmThree.setOnClickListener(alarmClick);
        switchAlarmFour.setOnClickListener(alarmClick);
        switchAlarmFive.setOnClickListener(alarmClick);
        switchAlarmSix.setOnClickListener(alarmClick);
        seekArcOne.setOnClickListener(alarmClick);
        seekArcTwo.setOnClickListener(alarmClick);
        seekArcThree.setOnClickListener(alarmClick);
        seekArcFour.setOnClickListener(alarmClick);
        seekArcFive.setOnClickListener(alarmClick);
        seekArcSix.setOnClickListener(alarmClick);

    }

    View.OnClickListener alarmClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.switch_alarm_one){
                if (switchAlarmOne.isChecked()) {
                    seekArcOne.setVisibility(View.VISIBLE);
                    tvNameAlarmOne.setVisibility(View.VISIBLE);
                    tvNumAlarmOne.setVisibility(View.VISIBLE);

                } else {
                    seekArcOne.setVisibility(View.GONE);
                    tvNameAlarmOne.setVisibility(View.GONE);
                    tvNumAlarmOne.setVisibility(View.GONE);
                }
            }
            if(v.getId() == R.id.switch_alarm_two){
                if (switchAlarmTwo.isChecked()) {
                    seekArcTwo.setVisibility(View.VISIBLE);
                    tvNameAlarmTwo.setVisibility(View.VISIBLE);
                    tvNumAlarmTwo.setVisibility(View.VISIBLE);

                } else {
                    seekArcTwo.setVisibility(View.GONE);
                    tvNameAlarmTwo.setVisibility(View.GONE);
                    tvNumAlarmTwo.setVisibility(View.GONE);
                }
            }
            if(v.getId() == R.id.switch_alarm_three){
                if (switchAlarmThree.isChecked()) {
                    seekArcThree.setVisibility(View.VISIBLE);
                    tvNameAlarmThree.setVisibility(View.VISIBLE);
                    tvNumAlarmThree.setVisibility(View.VISIBLE);

                } else {
                    seekArcThree.setVisibility(View.GONE);
                    tvNameAlarmThree.setVisibility(View.GONE);
                    tvNumAlarmThree.setVisibility(View.GONE);
                }
            }
            if(v.getId() == R.id.switch_alarm_four){
                if (switchAlarmFour.isChecked()) {
                    seekArcFour.setVisibility(View.VISIBLE);
                    tvNameAlarmFour.setVisibility(View.VISIBLE);
                    tvNumAlarmFour.setVisibility(View.VISIBLE);

                } else {
                    seekArcFour.setVisibility(View.GONE);
                    tvNameAlarmFour.setVisibility(View.GONE);
                    tvNumAlarmFour.setVisibility(View.GONE);
                }
            }
            if(v.getId() == R.id.switch_alarm_five){
                if (switchAlarmFive.isChecked()) {
                    seekArcFive.setVisibility(View.VISIBLE);
                    tvNameAlarmFive.setVisibility(View.VISIBLE);
                    tvNumAlarmFive.setVisibility(View.VISIBLE);

                } else {
                    seekArcFive.setVisibility(View.GONE);
                    tvNameAlarmFive.setVisibility(View.GONE);
                    tvNumAlarmFive.setVisibility(View.GONE);
                }
            }
            if(v.getId() == R.id.switch_alarm_six){
                if (switchAlarmSix.isChecked()) {
                    seekArcSix.setVisibility(View.VISIBLE);
                    tvNameAlarmSix.setVisibility(View.VISIBLE);
                    tvNumAlarmSix.setVisibility(View.VISIBLE);

                } else {
                    seekArcSix.setVisibility(View.GONE);
                    tvNameAlarmSix.setVisibility(View.GONE);
                    tvNumAlarmSix.setVisibility(View.GONE);
                }
            }
        }
    };
}
