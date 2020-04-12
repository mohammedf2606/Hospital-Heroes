package com.hummer.hospital_heroes.plate_minigame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;

/**
 * PlateActivity represents the class which contains the activity
 * the plate game runs in.
 *
 * @author Manav Parikh
 * @version 1.0
 */
public class PlateActivity extends AppActivity {

    private PlateView plateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        plateView = (PlateView) findViewById(R.id.plate_view);

        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);

        setContentView(R.layout.plate_minigame);
    }
}
