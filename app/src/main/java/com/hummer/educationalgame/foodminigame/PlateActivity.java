package com.hummer.educationalgame.foodminigame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.hummer.educationalgame.R;
import com.hummer.educationalgame.WaitingRoom;

public class PlateActivity extends Activity {

    private PlateView plateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        plateView = (PlateView) findViewById(R.id.plate_view);
        setContentView(R.layout.plate_minigame);
    }
}
