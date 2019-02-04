package com.noobs_team.avayeelahi.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.noobs_team.avayeelahi.R;
import com.noobs_team.avayeelahi.Utils.CityDatabase;
import com.noobs_team.avayeelahi.Utils.CustomDialog;

import java.util.Objects;


public class SettingActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarSetting;
    LinearLayout settingDefault;
    LinearLayout settingAlertAndAzan;

    @SuppressLint({"ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        toolbarSetting = findViewById(R.id.toolbar_setting);
        setSupportActionBar(toolbarSetting);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        settingDefault = findViewById(R.id.setting_default);
        settingAlertAndAzan = findViewById(R.id.setting_alert_and_azan);

        settingDefault.setOnClickListener(SettingsClick);
        settingAlertAndAzan.setOnClickListener(SettingsClick);

        final CityDatabase ada = new CityDatabase(this);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, R.xml.row_spn, ada.getOstan());
        adapter.setDropDownViewResource(R.xml.row_spn_dropdown);

        final Spinner spn_label = (Spinner) findViewById(R.id.spinner_ostan);
        spn_label.setAdapter(adapter);

        ArrayAdapter<String> adaptercity =
                new ArrayAdapter<>(SettingActivity.this, R.xml.row_spn, ada.getcity(1));
        adaptercity.setDropDownViewResource(R.xml.row_spn_dropdown);

        final Spinner spn_city = (Spinner) findViewById(R.id.spinner_city);
        spn_city.setAdapter(adaptercity);
        spn_label.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayAdapter<String> adaptercity =
                        new ArrayAdapter<>(SettingActivity.this
                                , R.xml.row_spn
                                , ada.getcity(position + 1));
                adaptercity.setDropDownViewResource(R.xml.row_spn_dropdown);

                spn_city.setAdapter(adaptercity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    View.OnClickListener SettingsClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.setting_default) {
                CustomDialog alert = new CustomDialog();
                alert.showDialog(SettingActivity.this);
            }
            if (v.getId() == R.id.setting_alert_and_azan) {
                Intent intent = new Intent(SettingActivity.this, AlertAndAzan.class);
                startActivity(intent);
            }
        }
    };
}
