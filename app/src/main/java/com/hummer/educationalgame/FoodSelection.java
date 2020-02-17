package com.hummer.educationalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.hummer.educationalgame.foodminigame.*;

public class FoodSelection extends Activity implements View.OnClickListener {

    Button milk, hash_brown, beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.food_selection);

        milk = (Button) findViewById(R.id.milk);
        milk.setOnClickListener(this);

        hash_brown = (Button) findViewById(R.id.hash_browns);
        hash_brown.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.milk:

            case R.id.hash_browns:
                Intent food_game = new Intent(FoodSelection.this, MainGameActivity.class);
                startActivity(food_game);
        }
    }
}
