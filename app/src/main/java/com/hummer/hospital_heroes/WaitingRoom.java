package com.hummer.hospital_heroes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.hummer.hospital_heroes.injection_minigame.InjectionMainMenu;

import java.util.ArrayList;

/**
 * Class that shows the waiting room screen
 * The clock in the room counts for 45 mins in 5 min intervals
 *
 * @author Fahim Mohammed
 * @version 1.0
 */
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
                    Intent injection_minigame = new Intent(WaitingRoom.this, InjectionMainMenu.class);
                    startActivity(injection_minigame);
                }
            }
        }, 0);
    }


}
