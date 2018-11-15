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
    android.support.v7.widget.Toolbar toolbarHoliday;
    List<HolidayList> holidays;
    HolidayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);

        toolbarHoliday = findViewById(R.id.toolbar_holiday);
        toolbarHoliday.setTitle(R.string.app_activity_holidays);
        setSupportActionBar(toolbarHoliday);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarHoliday.setTitleTextColor(getResources().getColor(R.color.textTitleColor));


        holidayListView = (ListView) findViewById(R.id.holiday_list);
        holidays = new ArrayList<>();
        prepareData();
        refreshDisplay();
    }

    private void prepareData() {
        holidays.add(new HolidayList ("چهارشنبه","آغاز نوروز (تعطیل)– شهادت حضرت امام علی النقی الهادی علیه السلام (254 ه ق)","1 فروردین","21 مارس","3 رجب"));
        holidays.add(new HolidayList ("پنجشنبه","عید نوروز (تعطیل)","2 فروردین","22 مارس","4 رجب"));
        holidays.add(new HolidayList ("جمعه","عید نوروز (تعطیل)","3 فروردین","23 مارس","5 رجب"));
        holidays.add(new HolidayList ("شنبه","عید نوروز (تعطیل)","4 فروردین","24 مارس","6 رجب"));
        holidays.add(new HolidayList ("شنبه","ولادت حضرت امام علی علیه السلام (23 سال قبل از هجرت) (تعطیل)","11 فروردین","31 مارس","13 رجب"));
        holidays.add(new HolidayList ("یکشنبه","روز جمهوری اسلامی ایران (تعطيل)","12 فروردین","1 آوریل","14 رجب"));
        holidays.add(new HolidayList ("دوشنبه","روز طبیعت (تعطيل)– وفات حضرت زینب سلام الله علیها (62 ه ق)","13 فروردین","2 آوریل","15 رجب"));
        holidays.add(new HolidayList ("شنبه","مبعث حضرت رسول اكرم صلی الله علیه وآله (13 سال قبل از هجرت) (تعطیل)","25 فروردین","14 آوریل","27 رجب"));

        holidays.add(new HolidayList ("چهارشنبه","شهادت استاد مرتضی مطهری (1358 ه ش)– روز معلم– ولادت حضرت قائم عجل الله تعالی فرجه (255 ه ق) (تعطیل)","12 اردیبهشت","2 مه","15 شعبان"));

        holidays.add(new HolidayList ("دوشنبه","رحلت حضرت امام خمينی (رحمه الله علیه) رهبركبیر انقلاب و بنیانگذار جمهوری اسلامی ایران (1368 ه ش)– انتخاب حضرت آيت الله امام خامنه ای به رهبری (1368 ه ش) (تعطیل)– ضربت خوردن حضرت علی علیه السلام (40 ه ق)","14 خرداد","4 ژویٔن","19 رمضان"));
        holidays.add(new HolidayList ("سه شنبه","قیام خونین 15 خرداد (1342 ه ش) (تعطیل)– زندانی شدن حضرت امام خمینی (رحمه الله علیه) به دست ماموران ستم شاهی پهلوی (1342 ه ش)– شب قدر","15 خرداد","5 ژویٔن","20 رمضان"));
        holidays.add(new HolidayList ("چهارشنبه","شهادت حضرت علی علیه السلام (40 ه ق) (تعطیل)","16 خرداد","6 ژویٔن","21 رمضان"));
        holidays.add(new HolidayList ("جمعه","عید سعید فطر (تعطیل)","25 خرداد","15 ژویٔن","1 شوال"));
        holidays.add(new HolidayList ("شنبه","عید سعید فطر (تعطیل)","26 خرداد","16 ژویٔن","2 شوال"));

        holidays.add(new HolidayList ("دوشنبه","شهادت حضرت امام جعفر صادق علیه السلام (148 ه ق) (تعطیل)","18 تیر","9 ژویٔیه","25 شوال"));

        holidays.add(new HolidayList ("چهارشنبه","عید سعید قربان (تعطيل)","31 مرداد","22 اوت","10 ذی الحجه"));

        holidays.add(new HolidayList ("پنجشنبه","عید سعید غدیر خم (10 ه ق) (تعطیل)","8 شهریور","30 اوت","18 ذی الحجه"));
        holidays.add(new HolidayList ("چهارشنبه","تاسوعای حسینی (تعطیل)","28 شهریور","19 سپتامبر","9 محرم"));
        holidays.add(new HolidayList ("پنجشنبه","عاشورای حسینی (تعطیل)","29 شهریور","20 سپتامبر","10 محرم"));

        holidays.add(new HolidayList ("سه شنبه","اربعین حسینی ( تعطیل)","8 آبان","30 اکتبر","20 صفر"));
        holidays.add(new HolidayList ("چهارشنبه","رحلت حضرت رسول اکرم صلی الله علیه و آله (11 ه ق) (تعطیل)– شهادت حضرت امام حسن مجتبی علیه السلام (50 ه ق)","16 آبان","7 نوامبر","28 صفر"));
        holidays.add(new HolidayList ("پنجشنبه","شهادت حضرت امام رضا علیه السلام (203 ه ق) (تعطیل)","17 آبان","8 نوامبر","29 صفر"));
        holidays.add(new HolidayList ("جمعه","شهادت حضرت امام حسن عسکری علیه السلام (260 ه ق) و آغاز امامت حضرت ولی عصر (عج) (تعطیل)","25 آبان","16 نوامبر","8 ربیع الاول"));

        holidays.add(new HolidayList ("یکشنبه","ولادت حضرت رسول اكرم صلی الله علیه و آله (53 سال قبل از هجرت) و روز اخلاق و مهرورزی– ولادت حضرت امام جعفر صادق علیه السلام مؤسس مذهب جعفری(83 ه ق) (تعطیل)","4 آذر","25 نوامبر","17 ربیع الاول"));

        holidays.add(new HolidayList ("شنبه","شهادت حضرت فاطمه زهرا سلام الله علیها (11 ه ق) (تعطیل)","20 بهمن","9 فوریه","3 جمادی الثانی"));
        holidays.add(new HolidayList ("دوشنبه","پیروزی انقلاب اسلامی ايران و سقوط نظام شاهنشاهی (1357 ه ش) (تعطیل)","22 بهمن","11 فوریه","5 جمادی الثانی"));

        holidays.add(new HolidayList ("چهارشنبه","روز ملی شدن صنعت نفت ایران (1329 ه ش) (تعطیل)- ولادت حضرت امام علی علیه السلام (23 سال قبل از هجرت)","29 اسفند","20 مارس","13 رجب"));

    }

    private void refreshDisplay() {
        adapter = new HolidayAdapter(this,R.layout.item_holiday, holidays);
        holidayListView.setAdapter(adapter);
    }
}
