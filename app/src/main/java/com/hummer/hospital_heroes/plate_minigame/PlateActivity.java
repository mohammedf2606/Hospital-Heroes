package com.hummer.hospital_heroes.plate_minigame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.hummer.hospital_heroes.R;

public class PlateActivity extends Activity {

    private PlateView plateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        plateView = (PlateView) findViewById(R.id.plate_view);

        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);

        setContentView(R.layout.plate_minigame);
    }
}
