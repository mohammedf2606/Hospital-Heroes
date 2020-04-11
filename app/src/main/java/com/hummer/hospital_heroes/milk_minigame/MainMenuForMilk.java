package com.hummer.hospital_heroes.milk_minigame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;

/**
 * MainMenuForMilk serves as a prompt before the milk mini game starts
 *
 * @author Manav Parikh
 * @version 1.0
 */

public class MainMenuForMilk extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.food_background);

        findViewById(R.id.playButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuForMilk.this, MilkGameActivity.class));
            }
        });
    }
}
