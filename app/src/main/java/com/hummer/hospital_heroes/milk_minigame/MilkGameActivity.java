package com.hummer.hospital_heroes.milk_minigame;

import android.os.Bundle;
import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;
import com.hummer.hospital_heroes.food_minigame.GameView;

/**
 * MilkGameActivity represents the class which contains the activity
 * the game runs in.
 *
 * @author Manav Parikh
 * @version 1.0
 */
public class MilkGameActivity extends AppActivity {

    private MilkGameView milkGameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        milkGameView = new MilkGameView(this);
        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);
        setContentView(milkGameView);
    }

    public MilkGameView getGameView() {
        return milkGameView;
    }
}
