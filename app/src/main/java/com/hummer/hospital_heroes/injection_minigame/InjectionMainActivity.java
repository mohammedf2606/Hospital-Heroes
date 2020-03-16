package com.hummer.hospital_heroes.injection_minigame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.hummer.hospital_heroes.PreScan;

/**
 * InjectionMainActivity is the class of the game that represents the main activity. It builds
 * and displays the main activity and all other components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionMainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        InjectionConstants.SCREEN_WIDTH = dm.widthPixels;
        InjectionConstants.SCREEN_HEIGHT = dm.heightPixels;
        setContentView(new InjectionGamePanel(this));
    }

    public void nextScene() {
        Intent pre_scan = new Intent(InjectionMainActivity.this, PreScan.class);
        startActivity(pre_scan);
    }
}
