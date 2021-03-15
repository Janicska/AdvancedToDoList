package com.app.advancedtodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        TextInputEditText input = (TextInputEditText) findViewById(R.id.input);
        Button next = (Button) findViewById(R.id.buttonNext);

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                editor.putString("name", input.getText().toString());
                editor.commit();

                startActivity(new Intent(MainActivity.this, today.class));
            }
        });
    }
}