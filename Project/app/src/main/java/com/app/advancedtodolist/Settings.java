package com.app.advancedtodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextInputEditText nameInput = (TextInputEditText) findViewById(R.id.nameInput);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", MODE_PRIVATE);
        String yourname=sharedPreferences.getString("name", "Your name");

        nameInput.setText(yourname);
        Button saveBtn = (Button) findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String newname=nameInput.getText().toString();
                if(newname.length()!=0)
                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", newname);
                    editor.commit();
                }
                startActivity(new Intent(Settings.this, Today.class));

            }
        });
    }
}