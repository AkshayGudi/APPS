package com.example.akshaygudi.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UIControlActivity extends AppCompatActivity {

    String[] softwares = {"Gedit", "Kolour", "VLC", "KDE", "Audacity"};
    AutoCompleteTextView ACTextView;
    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicontrol);
        PopulateAutoCompleteTextView();

        Bundle b = getIntent().getExtras();
        String value = b.getString("One");
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();

        onClickFunction();
        CheckBoxTest();
        setSpinnerWid();
    }


    public void PopulateAutoCompleteTextView() {
        ACTextView = (AutoCompleteTextView) findViewById(R.id.auTextView);
        ArrayAdapter<String> softwareAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, softwares);
        ACTextView.setThreshold(2);
        ACTextView.setAdapter(softwareAdapter);
    }

    public void buttonClick(View view){
        Button b = (Button)view;
        Toast.makeText(this, b.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    public void onClickFunction(){
        button = (Button)findViewById(R.id.buttonTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(UIControlActivity.this,button.getText().toString() + " -- NEW",Toast.LENGTH_SHORT).show();

            }
        });
    }


/*    public void imageButtonCLick(View view){
        ImageButton imgButton = (ImageButton)view;
        Toast.makeText(this,imgButton.getTooltipText().toString(),Toast.LENGTH_SHORT).show();
    }*/

public void CheckBoxTest() {
        Button b = (Button) findViewById(R.id.checkboxButton);
        ch1 = (CheckBox) findViewById(R.id.checkBox1);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        ch3 = (CheckBox) findViewById(R.id.checkBox3);


        b.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        String ch1Result = ch1.isChecked() ? "  will be downloaded " : " will not be downloaded";
        String ch2Result = ch2.isChecked() ? "  will be downloaded " : " will not be downloaded";
        String ch3Result = ch3.isChecked() ? "  will be downloaded " : " will not be downloaded";


        StringBuffer result = new StringBuffer();
        result.append(ch1.getText().toString() + " -- " + ch1Result).append("\n");
        result.append(ch2.getText().toString() + " -- " + ch2Result).append("\n");
        result.append(ch3.getText().toString() + " -- " + ch3Result);

        Toast.makeText(UIControlActivity.this, result.toString(), Toast.LENGTH_SHORT).show();

        }
        });

    }


public void setSpinnerWid(){

    Spinner sp = (Spinner)findViewById(R.id.spinnerType);
    String[] newSource = {"Test1","Test2","Test3", "Test4"};
    Arrays.asList(newSource);
    List<String> sourceList = new ArrayList<>(Arrays.asList(newSource));
    //s.add("test12");
    //s.add("test13");
    //s.add("test14");
    //s.add("test15");
    //s.toArray();

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sourceList);
    //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    sp.setAdapter(adapter);
}

public void onClickOfSpinner(){

    Spinner sp =  (Spinner)findViewById(R.id.spinnerType);
    sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            //Toast.makeText(this,position)
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
}


public void onClickRadio(View view){

    RadioButton rB = (RadioButton)view;

    if(rB.getTag().toString().equalsIgnoreCase("One")){
        Intent i1 = new Intent(this,TimeActivity.class);
        this.startActivity(i1);

    }else if(rB.getTag().toString().equalsIgnoreCase("Two")){

    }else{

    }

}

}