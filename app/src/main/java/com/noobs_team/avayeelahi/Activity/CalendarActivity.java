package com.noobs_team.avayeelahi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
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

    ImageView calendarComeBack;
    PersianCalendarHandler calendar;
    PersianDate today;
    PersianCalendarView persianCalendarView;
    Button calendarMahanehButton;
    Button calendarRouzanehButton;
    ImageView calendarBackButton;
    ImageView calendarForwardButton;
    TextView calendarYear;
    TextView calendarDayAndMonth;
    String dayAndMonth;
    TextView eventText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarComeBack = findViewById(R.id.calendar_come_back);
        calendarMahanehButton = findViewById(R.id.calendar_top_button_mahaneh);
        calendarRouzanehButton = findViewById(R.id.calendar_top_button_rouzaneh);
        calendarYear = findViewById(R.id.calendar_year);
        calendarDayAndMonth = findViewById(R.id.calendar_day_and_month);
        calendarBackButton = findViewById(R.id.back_calendar);
        calendarForwardButton = findViewById(R.id.forward_calendar);
        eventText = findViewById(R.id.event_text);
        persianCalendarView = (PersianCalendarView) findViewById(R.id.persian_calendar);
        calendar = persianCalendarView.getCalendar();
        today = calendar.getToday();

        calendarComeBack.setOnClickListener(clickListener);
        calendarRouzanehButton.setOnClickListener(clickListener);
        calendarForwardButton.setOnClickListener(clickListener);
        calendarBackButton.setOnClickListener(clickListener);

        dayAndMonth = calendar.getWeekDayName(today) + " " + calendar.formatNumber(today.getDayOfMonth())
                + " " + calendar.getMonthName(today) + " ";
        calendarDayAndMonth.setText(dayAndMonth);
        calendarYear.setText(calendar.formatNumber(today.getYear()));

        if (calendar.getAllEventsForDay(today).isEmpty()){
            eventText.setText(getResources().getString(R.string.calendar_non_event));
        }
        else {
            for(CalendarEvent event : calendar.getAllEventsForDay(today))
                eventText.setText(event.getTitle());
        }

        calendar.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onChanged(PersianDate date) {
                calendarDayAndMonth.setText(
                        calendar.formatNumber(calendar.getWeekDayName(date) + " " +
                                calendar.formatNumber(date.getDayOfMonth()) + " " +
                                calendar.formatNumber(calendar.getMonthName(date)) + " "));
                calendarYear.setText(calendar.formatNumber(date.getYear()));

                if (calendar.getAllEventsForDay(today).size()==0){
                    eventText.setText(getResources().getString(R.string.calendar_non_event));
                }
                else {
                    for(CalendarEvent event : calendar.getAllEventsForDay(date))
                        eventText.setText(event.getTitle());
                }
            }
        });

        persianCalendarView.setOnDayClickedListener(new OnDayClickedListener() {
            @Override
            public void onClick(PersianDate date) {
                if (calendar.getAllEventsForDay(today).size()==0){
                    eventText.setText(getResources().getString(R.string.calendar_non_event));
                }
                else {
                    for(CalendarEvent event : calendar.getAllEventsForDay(date))
                        eventText.setText(event.getTitle());
                }
            }
        });

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.calendar_come_back) {
                dayAndMonth = calendar.getWeekDayName(today) + " " + calendar.formatNumber(today.getDayOfMonth())
                        + " " + calendar.getMonthName(today) + " ";
                calendarDayAndMonth.setText(dayAndMonth);
                calendarYear.setText(calendar.formatNumber(today.getYear()));
                persianCalendarView.update();

                if (calendar.getAllEventsForDay(today).size()==0){
                    eventText.setText(getResources().getString(R.string.calendar_non_event));
                }
                else {
                    for(CalendarEvent event : calendar.getAllEventsForDay(today))
                        eventText.setText(event.getTitle());
                }
            }
            if (v.getId() == R.id.calendar_top_button_mahaneh) {

            }
            if (v.getId() == R.id.calendar_top_button_rouzaneh) {

            }
            if (v.getId() == R.id.back_calendar) {
                persianCalendarView.goToPreviousMonth();
            }
            if (v.getId() == R.id.forward_calendar) {
                persianCalendarView.goToNextMonth();
            }

        }
    };
}