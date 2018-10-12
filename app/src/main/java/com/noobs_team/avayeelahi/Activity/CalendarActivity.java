package com.noobs_team.avayeelahi.Activity;

import android.content.BroadcastReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.noobs_team.avayeelahi.R;

import ir.mirrajabi.persiancalendar.PersianCalendarView;
import ir.mirrajabi.persiancalendar.core.PersianCalendarHandler;
import ir.mirrajabi.persiancalendar.core.interfaces.OnMonthChangedListener;
import ir.mirrajabi.persiancalendar.core.models.PersianDate;


public class CalendarActivity extends AppCompatActivity {

    ImageView calendarComeBack;
    PersianCalendarHandler calendar;
    PersianDate today;
    PersianCalendarView persianCalendarView;
    Button calendarMahanehButton;
    Button calendarRouzanehButton;
    TextView calendarNumberOfYear;
    TextView calendarNameOfMonth;
    TextView calendarNumberOfDay;
    TextView calendarNameOfWeek;
    String month;
    int year;
    String week;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarComeBack = findViewById(R.id.calendar_come_back);
        calendarMahanehButton = findViewById(R.id.calendar_top_button_mahaneh);
        calendarRouzanehButton = findViewById(R.id.calendar_top_button_rouzaneh);
        calendarNumberOfYear = findViewById(R.id.calendar_number_of_year);
        calendarNameOfMonth = findViewById(R.id.calendar_name_of_month);
        calendarNumberOfDay = findViewById(R.id.calendar_number_of_day);
        calendarNameOfWeek = findViewById(R.id.calendar_name_of_week);

        persianCalendarView = (PersianCalendarView) findViewById(R.id.persian_calendar);
        calendar = persianCalendarView.getCalendar();
        today = calendar.getToday();
        //   month = persianCalendarView.get;
        //   week =;

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

        String dayAndMonth = calendar.getWeekDayName(today) + calendar.formatNumber(today.getDayOfMonth())
                + calendar.getMonthName(today);
        txtDayMonth.setText(dayAndMonth);
        txtYear.setText(calendar.formatNumber(today.getYear()));

        calendar.setColorBackground(getResources().getColor(android.R.color.holo_blue_dark));
        persianCalendarView.update();*/
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        calendarComeBack.setOnClickListener(clickListener);
        calendarRouzanehButton.setOnClickListener(clickListener);

        calendar.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onChanged(PersianDate date) {
                month = calendar.getMonthName(date);
                calendarNameOfMonth.setText(month);
            }
        });

        if (persianCalendarView.isSelected()) {

    //        persianCalendarView.;
    //        calendarNumberOfYear.setText(calendar.formatNumber();
    //        calendarNumberOfDay.setText(calendar.formatNumber();
    //        calendarNameOfMonth.setText(calendar.getMonthName();
    //        calendarNameOfWeek.setText(calendar.formatNumber();


        }
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.calendar_come_back) {
                day = today.getDayOfMonth();
                month = calendar.getMonthName(today);
                week = calendar.getWeekDayName(today);
                year = today.getYear();

                calendarNameOfMonth.setText(month);
                calendarNameOfWeek.setText(week);
                calendarNumberOfDay.setText(day + "");
                calendarNumberOfYear.setText(year + "");
                persianCalendarView.goToToday();
            }
            if (v.getId() == R.id.calendar_top_button_mahaneh) {

            }
            if (v.getId() == R.id.calendar_top_button_rouzaneh) {

            }
        }
    };
}