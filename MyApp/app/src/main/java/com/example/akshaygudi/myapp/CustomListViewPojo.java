package com.example.akshaygudi.myapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomListViewPojo extends ArrayAdapter {

    String[] imageName;
    Integer[] imageId;
    Activity context;

    CustomListPojo[] rowItems;

    public CustomListViewPojo(@NonNull Activity context, CustomListPojo[] rowItems) {
        super(context, R.layout.customlist_view, rowItems);
        this.rowItems = rowItems;
        this.context = context;
    }

    public CustomListPojo getItem(int position){
        return this.rowItems[position];
    }

    //Can override - getItemId

    private class ViewHolder{
        ImageView imgView;
        TextView txtView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder = null;

        LayoutInflater inflater = context.getLayoutInflater();
        //inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View viewRows = inflater.inflate(R.layout.customlist_view,null,true);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.customlist_view,null,true);

            viewHolder  = new ViewHolder();
            viewHolder.imgView = (ImageView)convertView.findViewById(R.id.imageId);
            viewHolder.txtView = (TextView)convertView.findViewById(R.id.textId);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }


        viewHolder.imgView.setImageResource(getItem(position).getImageId());
        viewHolder.txtView.setText(getItem(position).getImageName());

        return convertView;
    }
}
