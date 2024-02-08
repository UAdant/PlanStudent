package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button opCal, showPanelButton, showPanelButtonNotion;
    private LinearLayout panelLayout, panelLayoutNotion;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opCal = findViewById(R.id.openCalendar);
        showPanelButton = findViewById(R.id.addEvent);
        panelLayout = findViewById(R.id.panelLayout);

        showPanelButtonNotion = findViewById(R.id.openNotion);
        panelLayoutNotion = findViewById(R.id.panelLayoutNotion);

        opCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityCalendar.class);
                startActivity(intent);
            }
        });

        showPanelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panelLayout.setVisibility(View.VISIBLE);
            }
        });


        showPanelButtonNotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panelLayoutNotion.setVisibility(View.VISIBLE);
            }
        });



    }
}
