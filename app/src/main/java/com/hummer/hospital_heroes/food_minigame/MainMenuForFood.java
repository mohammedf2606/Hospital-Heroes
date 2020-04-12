package com.hummer.hospital_heroes.food_minigame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;
import com.hummer.hospital_heroes.cream_minigame.GameActivity;

/**
 * MainMenuForFood serves as a prompt before the food mini game starts
 *
 * @author Manav Parikh
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
