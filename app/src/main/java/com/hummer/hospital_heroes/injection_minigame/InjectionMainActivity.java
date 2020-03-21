package com.hummer.hospital_heroes.injection_minigame;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;

/**
 * InjectionMainActivity is the class of the game that represents the main activity. It builds
 * and displays the main activity and all other components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionMainActivity extends AppActivity
{
    private InjectionGamePanel gamePanel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);

        gamePanel = new InjectionGamePanel(this, displayMetrics.widthPixels, displayMetrics.heightPixels);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        InjectionConstants.SCREEN_WIDTH = dm.widthPixels;
        InjectionConstants.SCREEN_HEIGHT = dm.heightPixels;

        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);

        setContentView(gamePanel);
        gamePanel.setGameActivity(this);
    }

}
