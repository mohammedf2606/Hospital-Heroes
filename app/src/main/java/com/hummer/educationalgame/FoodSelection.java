package com.hummer.educationalgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class FoodSelection extends Activity implements View.OnClickListener {

    Button milk, hash_brown, beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
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

            case R.id.hash_browns:
        }
    }
}
