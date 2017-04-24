package com.example.angelina.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ItemAdapter extends ArrayAdapter<SplitItem> {
    private static class ViewHolder {
        private TextView itemView;
    }

    public ItemAdapter(Context context, int resourceId, ArrayList<SplitItem> itemList){
        super(context, resourceId, itemList);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.set_up_textview, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.itemView = (TextView) convertView.findViewById(R.id.personName);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SplitItem item = getItem(position);

        if(item != null){
            viewHolder.itemView.setText(item.getName() + "\t\t\t\t\t" + "$" + String.valueOf(item.getCostPerPerson()));
        }
        return convertView;
    }

}
