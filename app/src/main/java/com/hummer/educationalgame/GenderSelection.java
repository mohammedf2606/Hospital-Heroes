package com.hummer.educationalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class GenderSelection extends Activity implements View.OnClickListener{

    Button male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gender_selection);

        male = (Button) findViewById(R.id.male_gender_sign);
        male.setOnClickListener(this);

        female = (Button) findViewById(R.id.female_gender_sign);
        female.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.male_gender_sign:
                Intent male_characters = new Intent(GenderSelection.this, MaleCharSelection.class);
                startActivity(male_characters);
                break;
            case R.id.female_gender_sign:
                Intent female_characters = new Intent(GenderSelection.this, FemaleCharSelection.class);
                startActivity(female_characters);
                break;
        }
    }
}
