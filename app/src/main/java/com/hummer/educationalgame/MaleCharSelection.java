package com.hummer.educationalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MaleCharSelection extends Activity implements View.OnClickListener {

    Button male1, male2, male3, male4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.male_characters);

        male1 = (Button) findViewById(R.id.boy1);
        male1.setOnClickListener(this);

        male2 = (Button) findViewById(R.id.boy2);
        male2.setOnClickListener(this);

        male3 = (Button) findViewById(R.id.boy3);
        male3.setOnClickListener(this);

        male4 = (Button) findViewById(R.id.boy4);
        male4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boy1:
                Constants.setPlayerCharacter(R.id.boy1);
                break;
            case R.id.boy2:
                Constants.setPlayerCharacter(R.id.boy2);
                break;
            case R.id.boy3:
                Constants.setPlayerCharacter(R.id.boy3);
                break;
            case R.id.boy4:
                Constants.setPlayerCharacter(R.id.boy4);
                break;
        }
        if(Constants.isFood()) {
            Intent food_selection = new Intent(MaleCharSelection.this, FoodSelection.class);
            startActivity(food_selection);
        }
//        else {
//            Intent food_selection = new Intent(MaleCharSelection.this, FoodSelection.class);
//            startActivity(food_selection);
//        }
    }
}
