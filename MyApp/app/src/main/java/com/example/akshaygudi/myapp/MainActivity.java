package com.example.akshaygudi.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Button activityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        openNewActivity();
        longClick();
    }

    public void openNewActivity(){
        activityButton = (Button)findViewById(R.id.button2);
        activityButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent newIntent =  new Intent("com.example.akshaygudi.myapp.SubActivity");
                        startActivity(newIntent);
                    }
                }
        );
    }

    public void longClick(){
        activityButton = (Button)findViewById(R.id.button2);
        activityButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this,"Stop here",Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    public void openUIControlActivity(View view){
        Intent UiControlIntent = new Intent("com.example.akshaygudi.myapp.UIControlActivity");
        UiControlIntent.putExtra("One","TEST123");
        startActivity(UiControlIntent);
    }

    public void goToBrowser(View view){
        Intent intent = new Intent("com.example.akshaygudi.myapp.WebViewConnect");
        this.startActivity(intent);
        //startService(new Intent(getBaseContext(), TestService.class));

    }

    public void stopService(View view){
        stopService(new Intent(getBaseContext(),TestService.class));
    }
}
