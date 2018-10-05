package com.noobs_team.avayeelahi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.noobs_team.avayeelahi.R;

import ir.mirrajabi.persiancalendar.PersianCalendarView;
import ir.mirrajabi.persiancalendar.core.PersianCalendarHandler;
import ir.mirrajabi.persiancalendar.core.models.PersianDate;

public class CalendarActivity extends AppCompatActivity {

    com.noobs_team.avayeelahi.Activity.Time.PersianCalendar persianCalendarView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        PersianCalendarView calendarView  = (PersianCalendarView) findViewById(R.id.persian_calendar);
        PersianCalendarHandler calendarHandler = persianCalendarView.getCalendar();
        PersianDate today = calendar.getToday();
    }
}
