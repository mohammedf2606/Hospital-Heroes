package com.hummer.hospital_heroes.milk_minigame;

import android.os.Bundle;
import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;

public class MilkGameActivity extends AppActivity {

    private MilkGameView milkGameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        milkGameView = (MilkGameView) findViewById(R.id.milk_game_view);
        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);
        setContentView(R.layout.milk_minigame);
    }
}
