package com.example.akshaygudi.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Akshay.Gudi on 20-01-2018.
 */

public class CustomSpinnerListener implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position) == "Date" || parent.getItemAtPosition(position) == "Time" ) {
            Intent newIntent = new Intent(parent.getContext(),MainActivity.class);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
