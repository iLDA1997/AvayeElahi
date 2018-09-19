package com.noobs_team.avayeelahi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.noobs_team.avayeelahi.Adapter.HolidayAdapter;
import com.noobs_team.avayeelahi.Data.HolidayList;
import com.noobs_team.avayeelahi.R;

import java.util.ArrayList;
import java.util.List;

public class HolidaysActivity extends AppCompatActivity {

    ListView holidayListView;

    List<HolidayList> holidays;
    HolidayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);
        holidayListView = (ListView) findViewById(R.id.holiday_list);
        holidays = new ArrayList<>();
        prepareData();
        refreshDisplay();
    }

    private void prepareData() {
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("شنبه","تعطیل","1397/02/30","2018/08/08","1432/05/25"));
        holidays.add(new HolidayList ("یکشنبه","عید سعید فطر، رحلت امام (رره)، روز جهانی درخت کاری ، روز من","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));
        holidays.add(new HolidayList ("1","2","3","4","5"));








    }

    private void refreshDisplay() {
        adapter = new HolidayAdapter(this,R.layout.item_holiday, holidays);
        holidayListView.setAdapter(adapter);
    }
}
