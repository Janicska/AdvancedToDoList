package com.app.advancedtodolist;

import androidx.annotation.Nullable;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddPopUp extends Activity{

    TimePickerDialog picker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);


        TextView tv = new EditText(this);
        EditText priority = new EditText(this);
        EditText what = new EditText(this);
        EditText duration = new EditText(this);
        EditText when = new EditText(this);
        EditText from = new EditText(this);
        EditText to = new EditText(this);

        Button but = new Button(this); 

        ImageView priorityImg = new ImageView(this);
        priorityImg.setImageResource(R.drawable.ic_action_prio);
        ImageView whenImg = new ImageView(this);
        whenImg.setImageResource(R.drawable.ic_action_date);
        ImageView fromImg = new ImageView(this);
        fromImg.setImageResource(R.drawable.ic_action_from);
        fromImg.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                picker = new TimePickerDialog(AddPopUp.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        from.setText(hourOfDay+":"+minute);
                    }
                }, Calendar.HOUR_OF_DAY,Calendar.MINUTE,true);
                picker.show();
            }
        });
        ImageView toImg = new ImageView(this);
        toImg.setImageResource(R.drawable.ic_action_to);
        toImg.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                picker = new TimePickerDialog(AddPopUp.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        to.setText(hourOfDay+":"+minute);
                    }
                }, Calendar.HOUR_OF_DAY,Calendar.MINUTE,true);
                picker.show();
            }
        });

        LinearLayout prioLayout = new LinearLayout(this);
        LinearLayout whenLayout = new LinearLayout(this);
        LinearLayout fromLayout = new LinearLayout(this);
        LinearLayout toLayout = new LinearLayout(this);

        prioLayout.setOrientation(LinearLayout.HORIZONTAL);
        whenLayout.setOrientation(LinearLayout.HORIZONTAL);
        fromLayout.setOrientation(LinearLayout.HORIZONTAL);
        toLayout.setOrientation(LinearLayout.HORIZONTAL);

        tv.setText("Add a thing to the list.");
        tv.setEnabled(false);
        tv.setTextSize(40);
        tv.setGravity(Gravity.CENTER);

        priority.setHint("Priority");
        priority.setEnabled(false);
        what.setHint("What?");
        what.setEnabled(false);
        duration.setHint("Duration..");
        duration.setEnabled(false);
        when.setHint("When? (Optional)");
        when.setEnabled(false);
        from.setText("From.. (Optional)");
        from.setEnabled(false);
        to.setText("To.. (Optional)");
        to.setEnabled(false);

        prioLayout.addView(priority);
        prioLayout.addView(priorityImg);
        whenLayout.addView(when);
        whenLayout.addView(whenImg);
        fromLayout.addView(from);
        fromLayout.addView(fromImg);
        toLayout.addView(to);
        toLayout.addView(toImg);


        but.setText("Add");
        but.setGravity(Gravity.BOTTOM);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddPopUp.this, Today.class));
            }
        });

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.addView(tv);
        mainLayout.addView(prioLayout);
        mainLayout.addView(what);
        mainLayout.addView(duration);
        mainLayout.addView(whenLayout);
        mainLayout.addView(fromLayout);
        mainLayout.addView(toLayout);
        mainLayout.addView(but);

        setContentView(mainLayout);

    }
}
