package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityCalendar extends AppCompatActivity {

    private Button canMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        canMenu = findViewById(R.id.cancelMenu);

        applyClickAnimation(canMenu);

        canMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityCalendar.this, MainActivity.class);
                startActivity(intent);
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

                Intent intent = new Intent(ActivityCalendar.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
