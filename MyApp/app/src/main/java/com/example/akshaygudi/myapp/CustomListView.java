package com.example.akshaygudi.myapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomListView extends ArrayAdapter {

    String[] imageName;
    Integer[] imageId;
    Activity context;

    public CustomListView(@NonNull Activity context, String[] imageName, Integer[] imageId) {
        super(context, R.layout.customlist_view, imageName);
        this.imageId = imageId;
        this.imageName = imageName;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View viewRows = inflater.inflate(R.layout.customlist_view,null,true);

        ImageView imgView  = (ImageView)viewRows.findViewById(R.id.imageId);
        TextView txtView = (TextView)viewRows.findViewById(R.id.textId);

        imgView.setImageResource(imageId[position]);
        txtView.setText(imageName[position]);

        return viewRows;
    }
}
