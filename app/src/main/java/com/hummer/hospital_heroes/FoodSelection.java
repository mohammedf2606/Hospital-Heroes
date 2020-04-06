package com.hummer.hospital_heroes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hummer.hospital_heroes.food_minigame.MainMenuForFood;
import com.hummer.hospital_heroes.milk_minigame.MainMenuForMilk;

/**
 * Class that represents the screen where the user selects a game mode:
 * - Milk game
 * - Food game
 *
 * @author Fahim Mohammed, Bleon Uka
 * @version 1.3
 */
public class FoodSelection extends AppActivity implements View.OnClickListener {

    Button milk, hash_brown;
    public static boolean isMilk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.food_selection);

        milk = (Button) findViewById(R.id.milk);
        milk.setOnClickListener(this);

        hash_brown = (Button) findViewById(R.id.hash_browns);
        hash_brown.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.milk:
                isMilk = true;
                Intent milk_game = new Intent(FoodSelection.this, MainMenuForMilk.class);
                startActivity(milk_game);
                break;
            case R.id.hash_browns:
                isMilk = false;
                Intent food_game = new Intent(FoodSelection.this, MainMenuForFood.class);
                startActivity(food_game);
                break;
        }
    }
}
