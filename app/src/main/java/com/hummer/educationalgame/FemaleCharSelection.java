package com.hummer.educationalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class FemaleCharSelection extends Activity implements View.OnClickListener {

    Button female1, female2, female3, female4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.female_characters);

        female1 = (Button) findViewById(R.id.girl1);
        female1.setOnClickListener(this);

        female2 = (Button) findViewById(R.id.girl2);
        female2.setOnClickListener(this);

        female3 = (Button) findViewById(R.id.girl3);
        female3.setOnClickListener(this);

        female4 = (Button) findViewById(R.id.girl4);
        female4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.girl1:
                Constants.setPlayerCharacter(R.id.girl1);
                break;
            case R.id.girl2:
                Constants.setPlayerCharacter(R.id.girl2);
                break;
            case R.id.girl3:
                Constants.setPlayerCharacter(R.id.girl3);
                break;
            case R.id.girl4:
                Constants.setPlayerCharacter(R.id.girl4);
                break;
        }
        if(Constants.isFood()) {
            Intent food_selection = new Intent(FemaleCharSelection.this, FoodSelection.class);
            startActivity(food_selection);
        }
        else {
            Intent injection_room = new Intent(FemaleCharSelection.this, InjectionRoom.class);
            startActivity(injection_room);
        }
    }
}
