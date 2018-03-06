package com.example.akshaygudi.myapp;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomGridView extends BaseAdapter {

    private Context context;

    public CustomGridView(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgView = null;

        if (convertView == null){
            imgView = new ImageView(context);
            imgView.setLayoutParams(new GridView.LayoutParams(85,85));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(8,8,8,8);
        }
        else{
            imgView = (ImageView) convertView;
        }

        imgView.setImageResource(imageIds[position]);

        return imgView;
    }

    public Integer[] imageIds = {R.drawable.image3,R.drawable.image4, R.drawable.image5, R.drawable.image6};

}
