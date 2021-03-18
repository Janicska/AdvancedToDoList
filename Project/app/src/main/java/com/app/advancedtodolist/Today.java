package com.app.advancedtodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Today extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        ListView lv = (ListView) findViewById(R.id.listview);
        TextView date = (TextView) findViewById(R.id.date);
        ImageView settingsImage = (ImageView) findViewById(R.id.settingsImg);
        ImageView addImage = (ImageView) findViewById(R.id.addImg);
        ImageView calendarImage = (ImageView) findViewById(R.id.calendarImg);

        settingsImage.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(Today.this, Settings.class));
            }
        });

        addImage.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(Today.this, AddPopUp.class));
            }
        });

        calendarImage.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(Today.this, Calendar.class));
            }
        });

        ArrayList<Item> items = new ArrayList<Item>();

        date.setText(getDate(System.currentTimeMillis()));


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                 toStringArray(items));

        lv.setAdapter(arrayAdapter);


    }

    private String getDate(long millis){
        return DateFormat.format("yyyy.MM.dd, hh:mm",millis).toString();
    }

    private ArrayList<String> toStringArray(ArrayList<Item> it){
        ArrayList<String> items = new ArrayList<>();
        for(Item i : it){
            items.add(i.toString());
        }
        return items;
    }
}