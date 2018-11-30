package com.noobs_team.avayeelahi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.noobs_team.avayeelahi.Data.HolidayList;
import com.noobs_team.avayeelahi.R;

import java.util.List;

public class HolidayAdapter extends ArrayAdapter {
    private List<HolidayList> holidays;

    public HolidayAdapter(Context context, int item_holiday, List<HolidayList> holidays) {
        super(context, R.layout.item_holiday, holidays);
        this.holidays = holidays;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolidayList holiday = holidays.get(position);
        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_holiday, parent, false);
            holder = new ViewHolder();
            holder.holidayDayOfWeek = (TextView) convertView.findViewById(R.id.holiday_day_of_week);
            holder.holidaySubject = (TextView) convertView.findViewById(R.id.holiday_subject);
            holder.holidaySubject.setSelected(true);
            holder.holidayShamsi = (TextView) convertView.findViewById(R.id.holiday_shamsi);
            holder.holidayMiladi = (TextView) convertView.findViewById(R.id.holiday_miladi);
            holder.holidayGhamari = (TextView) convertView.findViewById(R.id.holiday_ghamari);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fill(holiday);
        return convertView;
    }


    private class ViewHolder {
        public TextView holidayDayOfWeek;
        public TextView holidaySubject;
        public TextView holidayShamsi;
        public TextView holidayMiladi;
        public TextView holidayGhamari;

        public void fill(final HolidayList holiday) {
            holidayDayOfWeek.setText(holiday.getHolidayDayOfWeek());
            holidaySubject.setText(holiday.getHolidaySubject());
            holidayShamsi.setText(holiday.getHolidayShamsi());
            holidayMiladi.setText(holiday.getHolidayMiladi());
            holidayGhamari.setText(holiday.getHolidayGhamari());

        }

    }
}