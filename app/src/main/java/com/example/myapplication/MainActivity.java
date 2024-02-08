package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button opCal;
    private Button openBsBtn;

    private ActivityMainBinding binding;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        opCal = binding.openCalendar;
        openBsBtn = binding.openBsBtn;

        applyClickAnimation(opCal);
        applyClickAnimation(openBsBtn);

        binding.openBsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scaleAnim = new ScaleAnimation(1f, 0.8f, 1f, 0.8f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnim.setDuration(100);

                Animation alphaAnim = new AlphaAnimation(1f, 0.7f);
                alphaAnim.setDuration(100);

                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(scaleAnim);
                animationSet.addAnimation(alphaAnim);

                v.startAnimation(animationSet);
                MyBottomSheet myBottomsheet = new MyBottomSheet();
                myBottomsheet.show(getSupportFragmentManager(), "my bottom sheet dialog");
            }
        });
    }

    private void applyClickAnimation(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scaleAnim = new ScaleAnimation(1f, 0.8f, 1f, 0.8f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnim.setDuration(100);

                Animation alphaAnim = new AlphaAnimation(1f, 0.7f);
                alphaAnim.setDuration(100);

                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(scaleAnim);
                animationSet.addAnimation(alphaAnim);

                v.startAnimation(animationSet);

                Intent intent = new Intent(MainActivity.this, ActivityCalendar.class);
                startActivity(intent);
            }
        });
    }
}
