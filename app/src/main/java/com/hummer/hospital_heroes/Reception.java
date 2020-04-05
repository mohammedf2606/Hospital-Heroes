package com.hummer.hospital_heroes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reception extends AppActivity implements View.OnClickListener{

    Button receptionist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.activity_reception);

        receptionist = (Button) findViewById(R.id.receptionist);
        receptionist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent character_selection = new Intent(Reception.this, CharacterSelection.class);
        startActivity(character_selection);
    }

}
