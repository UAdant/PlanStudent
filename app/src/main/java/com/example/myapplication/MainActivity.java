package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button opCal;

    private ActivityMainBinding binding;

    View layExams,layPractick, layLection, laySeminar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        opCal = findViewById(R.id.openCalendar);

        layExams = findViewById(R.id.opCardExams);
        layLection = findViewById(R.id.opCardLection);
        layPractick = findViewById(R.id.opCardPractick);
        laySeminar = findViewById(R.id.opCardSeminar);


        layExams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exams.class);
                startActivity(intent);
            }
        });

        layLection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lection.class);
                startActivity(intent);
            }
        });

        layPractick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Practick.class);
                startActivity(intent);
            }
        });

        laySeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Seminar.class);
                startActivity(intent);
            }
        });


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





    }
}
