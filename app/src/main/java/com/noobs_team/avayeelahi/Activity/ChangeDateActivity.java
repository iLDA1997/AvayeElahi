package com.noobs_team.avayeelahi.Activity;

import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.noobs_team.avayeelahi.Fragments.FragmentGregorian;
import com.noobs_team.avayeelahi.Fragments.FragmentShamsi;
import com.noobs_team.avayeelahi.R;
import com.noobs_team.avayeelahi.Utils.TabLayoutUtil;

import java.util.Objects;

public class ChangeDateActivity extends AppCompatActivity {
    ViewPager viewPager;
    android.support.v7.widget.Toolbar toolbarChangeDate;
    TabLayout tabLayout;
    FragmentShamsi fragmentShamsi = new FragmentShamsi();
    FragmentGregorian fragmentGregorian = new FragmentGregorian();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_date);
        toolbarChangeDate = findViewById(R.id.toolbar_change_date);
        viewPager = findViewById(R.id.view_pager_Change_date);
        tabLayout = findViewById(R.id.tabs_change_date);
        toolbarChangeDate.setTitle(R.string.menu_change_date);
        setSupportActionBar(toolbarChangeDate);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarChangeDate.setTitleTextColor(getResources().getColor(R.color.textTitleColor));
        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setViewPager (ViewPager viewPager){
        TabLayoutUtil.ViewPagerAdapter adapter = new TabLayoutUtil.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(fragmentShamsi,"تبدیل شمسی به میلادی");
        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.textTitleColor)));
        adapter.addFragment(fragmentGregorian,"تبدیل میلادی به شمسی");
        viewPager.setAdapter(adapter);
    }

}
