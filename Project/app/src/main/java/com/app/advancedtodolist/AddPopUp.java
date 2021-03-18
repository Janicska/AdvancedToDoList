package com.app.advancedtodolist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class AddPopUp extends Activity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new EditText(this);
        EditText priority = new EditText(this);
        EditText what = new EditText(this);
        EditText duration = new EditText(this);
        EditText when = new EditText(this);
        EditText from = new EditText(this);
        EditText to = new EditText(this);
        Button but = new Button(this);
            tv.setText("Add a thing to the list.");
            tv.setEnabled(false);
            tv.setTextSize(40);
            tv.setGravity(Gravity.CENTER);

            priority.setHint("Priority");
            priority.setInputType(InputType.TYPE_CLASS_NUMBER);
            what.setHint("What?");
            what.setInputType(InputType.TYPE_CLASS_TEXT);
            duration.setHint("Duration..");
            duration.setInputType(InputType.TYPE_CLASS_NUMBER);
            when.setHint("When? (Optional)");
            when.setInputType(InputType.TYPE_CLASS_DATETIME);
            from.setHint("From.. (Optional)");
            from.setInputType(InputType.TYPE_CLASS_DATETIME);
            to.setHint("To.. (Optional)");
            to.setInputType(InputType.TYPE_CLASS_DATETIME);


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
            mainLayout.addView(priority);
            mainLayout.addView(what);
            mainLayout.addView(duration);
            mainLayout.addView(when);
            mainLayout.addView(from);
            mainLayout.addView(to);
            mainLayout.addView(but);

            setContentView(mainLayout);

    }
}