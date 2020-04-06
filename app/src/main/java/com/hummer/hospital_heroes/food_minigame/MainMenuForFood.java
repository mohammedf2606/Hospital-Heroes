package com.hummer.hospital_heroes.food_minigame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;
import com.hummer.hospital_heroes.cream_minigame.GameActivity;

/**
 * MainMenuForFood represents the class that acts as the 'main menu' for
 * the game. In other words, it is the screen that appears before the game starts
 * and it showcases how the game works and sets the scene.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class MainMenuForFood extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.food_background);

        findViewById(R.id.playButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuForFood.this, MainGameActivity.class));
            }
        });
    }
}
