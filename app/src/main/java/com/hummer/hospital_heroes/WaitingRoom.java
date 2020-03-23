package com.hummer.hospital_heroes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.hummer.hospital_heroes.injection_minigame.InjectionMainMenu;

import java.util.ArrayList;

public class WaitingRoom extends AppActivity {

    ImageView waiting_room, character;
    ArrayList<Integer> timers = new ArrayList<>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.waiting_room);

        timers.add(0, R.drawable.waiting_room_00);
        timers.add(1, R.drawable.waiting_room_05);
        timers.add(2, R.drawable.waiting_room_10);
        timers.add(3, R.drawable.waiting_room_15);
        timers.add(4, R.drawable.waiting_room_20);
        timers.add(5, R.drawable.waiting_room_25);
        timers.add(6, R.drawable.waiting_room_30);
        timers.add(7, R.drawable.waiting_room_35);
        timers.add(8, R.drawable.waiting_room_40);
        timers.add(9, R.drawable.waiting_room_45);

        waiting_room = findViewById(R.id.waiting_room);

        character = findViewById(R.id.character);
        character.setImageResource(Constants.getPlayerSitting());

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(i < 10) {
                    waiting_room.setImageResource(timers.get(i));
                    i++;
                    handler.postDelayed(this, 500);
                }
                else {
<<<<<<< HEAD
<<<<<<< HEAD:app/src/main/java/com/hummer/educationalgame/WaitingRoom.java
                    // TODO: Fareed replace the 2nd parameter below with your MainActivity
                    Intent injection_minigame = new Intent(WaitingRoom.this, PreScan.class);
=======
=======
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
>>>>>>> 34882dc653dd04d3f38ae561a0bc34adc9590a59
                    Intent injection_minigame = new Intent(WaitingRoom.this, InjectionMainMenu.class);
>>>>>>> bd5f39c38d640068efccf61b9a9bac265ac6b6a4:app/src/main/java/com/hummer/hospital_heroes/WaitingRoom.java
                    startActivity(injection_minigame);
                }
            }
        }, 500);
    }


}
