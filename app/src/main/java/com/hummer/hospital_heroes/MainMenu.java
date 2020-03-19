package com.hummer.hospital_heroes;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainMenu extends Activity implements View.OnClickListener {

    ImageButton nurse, girl_eating;
    LinearLayout halo,halo2;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.menu);

        nurse = (ImageButton) findViewById(R.id.nurse);
        girl_eating = (ImageButton) findViewById(R.id.girl_eating);

        nurse.setOnClickListener(this);
        girl_eating.setOnClickListener(this);

        halo = (LinearLayout) findViewById(R.id.halo);
        halo2 = (LinearLayout) findViewById(R.id.halo2);
        animatorSet = new AnimatorSet();

        ObjectAnimator fadeAway = ObjectAnimator.ofFloat(halo, "alpha",0.5f,0.1f);
        fadeAway.setDuration(500);
        ObjectAnimator fadeAway2 = ObjectAnimator.ofFloat(halo2, "alpha",0.5f,0.1f);
        fadeAway2.setDuration(500);

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(halo, "alpha",0.1f,0.5f);
        fadeIn.setDuration(500);
        ObjectAnimator fadeIn2 = ObjectAnimator.ofFloat(halo2, "alpha",0.1f,0.5f);
        fadeIn2.setDuration(500);

        animatorSet.play(fadeIn).after(fadeAway);
        animatorSet.play(fadeIn2).after(fadeAway2);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animatorSet.start();
            }
        });

        animatorSet.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nurse:
                Constants.setIsFood(false);
                break;
            case R.id.girl_eating:
                Constants.setIsFood(true);
                break;
        }
        Intent main_page = new Intent(MainMenu.this, MainActivity.class);
        SoundEffects.initSounds(MainMenu.this);
        startService(new Intent(MainMenu.this, MusicService.class));
        startActivity(main_page);
    }
}
