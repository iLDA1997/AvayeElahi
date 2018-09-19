package com.noobs_team.avayeelahi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.noobs_team.avayeelahi.Data.AsmaAllahList;
import com.noobs_team.avayeelahi.R;

import java.util.List;

public class AsmaAllahAdapter extends ArrayAdapter {
    private List <AsmaAllahList> asmaAllah;

    public AsmaAllahAdapter(Context context, int item_asma_allah, List<AsmaAllahList> asmaAllah) {
        super(context, R.layout.item_asma_allah, asmaAllah);
        this.asmaAllah = asmaAllah;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AsmaAllahList asmaAllahList = asmaAllah.get(position);
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_asma_allah, parent, false);
            holder = new ViewHolder();
            holder.asmaAllahEn = (TextView) convertView.findViewById(R.id.allah_name_en);
            holder.asmaAllahFa = (TextView) convertView.findViewById(R.id.allah_name_fa);
            holder.nameMeaning = (TextView) convertView.findViewById(R.id.name_meaning);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fill(asmaAllahList);
        return convertView;
    }


    private class ViewHolder {
        public TextView asmaAllahEn;
        public TextView asmaAllahFa;
        public TextView nameMeaning;

        public void fill(AsmaAllahList asmaAllah){
            asmaAllahEn.setText(asmaAllah.getAllahNameEn());
            asmaAllahFa.setText(asmaAllah.getAllahNameFa());
            nameMeaning.setText(asmaAllah.getNameMeaning());
        }
    }

}