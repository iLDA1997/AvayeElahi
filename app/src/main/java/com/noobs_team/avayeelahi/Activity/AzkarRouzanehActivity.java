package com.noobs_team.avayeelahi.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.noobs_team.avayeelahi.Adapter.ExpandableListAdapter;
import com.noobs_team.avayeelahi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AzkarRouzanehActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarAzkarRouzaneh;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    ImageView fingerTap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_rouzaneh);
        toolbarAzkarRouzaneh = findViewById(R.id.toolbar_azkar_rouzaneh);
        toolbarAzkarRouzaneh.setTitle(R.string.app_activity_azkar_rouzaneh);
        setSupportActionBar(toolbarAzkarRouzaneh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarAzkarRouzaneh.setTitleTextColor(getResources().getColor(R.color.textTitleColor));
        fingerTap=findViewById(R.id.finger_tap);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        expListView.setBackgroundColor(Color.parseColor("#a1ff97"));
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(getResources().getString(R.string.azkar_rouzaneh_shanbeh));
        listDataHeader.add(getResources().getString(R.string.azkar_rouzaneh_yek_shanbeh));
        listDataHeader.add(getResources().getString(R.string.azkar_rouzaneh_doshanbeh));
        listDataHeader.add(getResources().getString(R.string.azkar_rouzaneh_se_shanbeh));
        listDataHeader.add(getResources().getString(R.string.azkar_rouzaneh_chahar_shanbeh));
        listDataHeader.add(getResources().getString(R.string.azkar_rouzaneh_panj_shanbeh));
        listDataHeader.add(getResources().getString(R.string.azkar_rouzaneh_jomee));


        // Adding child data
        List<String> shanbeh = new ArrayList<String>();
        shanbeh.add(getResources().getString(R.string.azkar_rouzaneh_doa_shanbeh));

        List<String> yekShanbeh = new ArrayList<String>();
        yekShanbeh.add(getResources().getString(R.string.azkar_rouzaneh_doa_yek_shanbeh));

        List<String> douShanbeh = new ArrayList<String>();
        douShanbeh.add(getResources().getString(R.string.azkar_rouzaneh_doa_doshanbeh));

        List<String> seShanbeh = new ArrayList<String>();
        seShanbeh.add(getResources().getString(R.string.azkar_rouzaneh_doa_se_shanbeh));

        List<String> chaharShanbeh = new ArrayList<String>();
        chaharShanbeh.add(getResources().getString(R.string.azkar_rouzaneh_doa_chahar_shanbeh));

        List<String> panjShanbeh = new ArrayList<String>();
        panjShanbeh.add(getResources().getString(R.string.azkar_rouzaneh_doa_panj_shanbeh));

        List<String> jomee = new ArrayList<String>();
        jomee.add(getResources().getString(R.string.azkar_rouzaneh_doa_jomee));

        listDataChild.put(listDataHeader.get(0), shanbeh); // Header, Child data
        listDataChild.put(listDataHeader.get(1), yekShanbeh);
        listDataChild.put(listDataHeader.get(2), douShanbeh);
        listDataChild.put(listDataHeader.get(3), seShanbeh);
        listDataChild.put(listDataHeader.get(4), chaharShanbeh);
        listDataChild.put(listDataHeader.get(5), panjShanbeh);
        listDataChild.put(listDataHeader.get(6), jomee);
    }

}