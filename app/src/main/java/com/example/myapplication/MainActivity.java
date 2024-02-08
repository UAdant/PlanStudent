package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button opCal, showPanelButton, showPanelButtonNotion;
    private LinearLayout panelLayout, panelLayoutNotion;
    private ActivityMainBinding binding;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        opCal = findViewById(R.id.openCalendar);
        showPanelButton = findViewById(R.id.open_bs_btn);
        panelLayout = findViewById(R.id.panelLayout);
        showPanelButtonNotion = findViewById(R.id.openNotion);
        panelLayoutNotion = findViewById(R.id.panelLayoutNotion);

        binding.openBsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyBottomSheet myBottomsheet = new MyBottomSheet();
                myBottomsheet.show(getSupportFragmentManager(),"my bottom sheet dialog");
            }
        });

        opCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityCalendar.class);
                startActivity(intent);
            }
        });

//        showPanelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                panelLayout.setVisibility(View.VISIBLE);
//            }
//        });


        showPanelButtonNotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panelLayoutNotion.setVisibility(View.VISIBLE);
            }
        });



    }
}
