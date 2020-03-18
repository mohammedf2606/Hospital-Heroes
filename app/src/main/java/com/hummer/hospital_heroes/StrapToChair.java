package com.hummer.hospital_heroes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.util.ArrayList;

public class StrapToChair extends Activity implements View.OnClickListener {

    ImageButton strapping;
    ArrayList<Integer> differentStraps = new ArrayList<>();
    int i = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.strap_to_chair);

        strapping = (ImageButton) findViewById(R.id.strapping);

        strapping.setOnClickListener(this);

        differentStraps.add(0, R.drawable.timer_15);
        differentStraps.add(1, R.drawable.timer_30);
        differentStraps.add(2, R.drawable.timer_45);
    }


    @Override
    public void onClick(View v) {
        if(i < 3){
            strapping.setImageResource(differentStraps.get(i));
            i++;
        }
        else{
            Intent main_page = new Intent(StrapToChair.this, MainMenu.class);
            startActivity(main_page);
        }
    }
}
