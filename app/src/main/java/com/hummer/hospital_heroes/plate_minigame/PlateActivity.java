package com.hummer.hospital_heroes.plate_minigame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;

public class PlateActivity extends AppActivity {

    private PlateView plateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        plateView = (PlateView) findViewById(R.id.plate_view);

        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);

        setContentView(R.layout.plate_minigame);
    }
}
