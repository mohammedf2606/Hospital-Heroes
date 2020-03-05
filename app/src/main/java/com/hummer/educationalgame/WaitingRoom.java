package com.hummer.educationalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.hummer.educationalgame.injectionminigame.InjectionMainActivity;
import com.hummer.educationalgame.rocketminigame.MainMenu;

import java.util.ArrayList;

public class WaitingRoom extends Activity {

    ImageView character_chair, timer;
    ArrayList<Integer> timers = new ArrayList<>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.waiting_room);

        timers.add(0, R.drawable.timer_15);
        timers.add(1, R.drawable.timer_30);
        timers.add(2, R.drawable.timer_45);

        character_chair = findViewById(R.id.chair_with_character);
        character_chair.setImageResource(Constants.getPlayerSitting());

        timer = findViewById(R.id.timer);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(i < 3) {
                    timer.setImageResource(timers.get(i));
                    i++;
                    handler.postDelayed(this, 2000);
                }
                else {
                    // TODO: Fareed replace the 2nd parameter below with your MainActivity
                    Intent injection_minigame = new Intent(WaitingRoom.this, MainMenu.class);
                    startActivity(injection_minigame);
                }
            }
        }, 2000);
    }


}
