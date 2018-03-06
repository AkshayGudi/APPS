package com.example.akshaygudi.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    String[] countryList = {"India","SriLanka","Nepal","Bhutan"};
    ListView itemListView;
    String[] imageName = {"internet","settings"};
    Integer[] imageId = {R.drawable.image3,R.drawable.image4};
    ListView customListView;
    CustomListPojo[] customListPojos = {new CustomListPojo(R.drawable.image3,"internet"), new CustomListPojo(R.drawable.image4,"settings")};
    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        populateArrayList();
        populateCustomListView();
        populateGridView();
    }

    public void populateArrayList(){
        itemListView = (ListView)findViewById(R.id.itemLists) ;
        ArrayAdapter<String> newArrayAdapter = new ArrayAdapter<String>(this,R.layout.itemlist_view,countryList);
        itemListView.setAdapter(newArrayAdapter);

        itemListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView temp = (TextView)view;
                        Toast.makeText(SubActivity.this,"Position: "  + position + " Value: " + temp.getText(), Toast.LENGTH_SHORT).show();
                    }
                }

        );
    }

    public void populateCustomListView(){

        CustomListViewPojo customListAdapter = new CustomListViewPojo(SubActivity.this,customListPojos);
        //CustomListView customListAdapter1 = new CustomListView(SubActivity.this, imageName, imageId);
        customListView = (ListView)findViewById(R.id.customItems);
        customListView.setAdapter(customListAdapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SubActivity.this, customListPojos[position].toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void populateGridView(){
        CustomGridView customGridView = new CustomGridView(this);
        gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(customGridView);

        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(getApplicationContext(), OpenGrid.class);
                        i.putExtra("id", position);
                        startActivity(i);
                    }
                }
        );
    }

}
