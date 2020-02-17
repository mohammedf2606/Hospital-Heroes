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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.food_selection);

        milk = (Button) findViewById(R.id.milk);
        milk.setOnClickListener(this);

        beans = (Button) findViewById(R.id.beans);
        beans.setOnClickListener(this);

        hash_brown = (Button) findViewById(R.id.hash_browns);
        hash_brown.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.milk:

            case R.id.beans:

            case R.id.hash_browns:
        }
    }
}
