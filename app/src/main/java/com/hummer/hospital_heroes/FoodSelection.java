package com.hummer.hospital_heroes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.hummer.hospital_heroes.food_minigame.MainGameActivity;


public class FoodSelection extends AppActivity implements View.OnClickListener {

    Button milk, hash_brown, beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.food_selection);

        milk = (Button) findViewById(R.id.milk_game);
        milk.setOnClickListener(this);

        hash_brown = (Button) findViewById(R.id.food_game);
        hash_brown.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.milk:

            case R.id.food_game:
                Intent food_game = new Intent(FoodSelection.this, MainGameActivity.class);
                startActivity(food_game);
        }
    }
}
