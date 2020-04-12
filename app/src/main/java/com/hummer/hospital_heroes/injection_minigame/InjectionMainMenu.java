package com.hummer.hospital_heroes.injection_minigame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;

/**
 * main menu class represents the 'main menu' for
 * the game. In other words, it is the screen that appears before the game starts
 * and it showcases how the game works and sets the scene.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionMainMenu extends AppActivity
{
    /**
     *  create the activity that displays the main menu on the screen
     * @param savedInstanceState the bundle of the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.injectionminigame);

        findViewById(R.id.playButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InjectionMainMenu.this, InjectionMainActivity.class));
            }
        });
    }
}