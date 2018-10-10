package com.noobs_team.avayeelahi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.noobs_team.avayeelahi.R;

import ir.mirrajabi.persiancalendar.PersianCalendarView;
import ir.mirrajabi.persiancalendar.core.PersianCalendarHandler;
import ir.mirrajabi.persiancalendar.core.interfaces.OnDayClickedListener;
import ir.mirrajabi.persiancalendar.core.interfaces.OnMonthChangedListener;
import ir.mirrajabi.persiancalendar.core.models.CalendarEvent;
import ir.mirrajabi.persiancalendar.core.models.PersianDate;

public class CalendarActivity extends AppCompatActivity {

    LinearLayout comeBackCalendar;
    PersianCalendarHandler calendar;
    PersianDate today;
    PersianCalendarView persianCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        comeBackCalendar = findViewById(R.id.come_back_calendar);

        persianCalendarView  = (PersianCalendarView)findViewById(R.id.persian_calendar);
        calendar = persianCalendarView.getCalendar();
        today = calendar.getToday();
        /*calendar.addLocalEvent(new CalendarEvent(
                today, "Custom event", false
        ));
        calendar.addLocalEvent(new CalendarEvent(
                today.clone().rollDay(2,true), "Custom event 2", true
        ));
        calendar.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onChanged(PersianDate date) {
                Toast.makeText(CalendarActivity.this, calendar.getMonthName(date),Toast.LENGTH_SHORT).show();
            }
        });
        persianCalendarView.setOnDayClickedListener(new OnDayClickedListener() {
            @Override
            public void onClick(PersianDate date) {
                for(CalendarEvent e : calendar.getAllEventsForDay(date))
                    Toast.makeText(CalendarActivity.this, e.getTitle(), Toast.LENGTH_LONG).show();


                calendar.addLocalEvent(new CalendarEvent(
                        today.clone().rollDay(2, false), "Some event that will be added in runtime", false
                ));
                persianCalendarView.update();
            }
        });

        calendar.setHighlightOfficialEvents(false);
        TextView txtDayMonth = (TextView) findViewById(R.id.txt_day_month);
        TextView txtYear = (TextView) findViewById(R.id.txt_year);

        String dayAndMonth = calendar.getWeekDayName(today) + calendar.formatNumber(today.getDayOfMonth())
                + calendar.getMonthName(today);
        txtDayMonth.setText(dayAndMonth);
        txtYear.setText(calendar.formatNumber(today.getYear()));

        calendar.setColorBackground(getResources().getColor(android.R.color.holo_blue_dark));
        persianCalendarView.update();*/

        comeBackCalendar.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.come_back_calendar){
                calendar.getToday();
                persianCalendarView.update();
            }

        }
    };
}