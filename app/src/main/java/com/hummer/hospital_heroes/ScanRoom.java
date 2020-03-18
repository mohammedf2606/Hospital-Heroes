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
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ScanRoom extends Activity implements View.OnClickListener {

    ImageButton scanner;
    ImageView halo_right, halo_left;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.scan_room);

        scanner = (ImageButton) findViewById(R.id.scanner);

        scanner.setOnClickListener(this);

        halo_right = (ImageView) findViewById(R.id.halo_right);
        halo_left = (ImageView) findViewById(R.id.halo_left);
        animatorSet = new AnimatorSet();

        ObjectAnimator fadeAway = ObjectAnimator.ofFloat(halo_right, "alpha",0.5f,0.1f);
        fadeAway.setDuration(500);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(halo_right, "alpha",0.1f,0.5f);
        fadeIn.setDuration(500);

        ObjectAnimator fadeAway2 = ObjectAnimator.ofFloat(halo_left, "alpha",0.5f,0.1f);
        fadeAway.setDuration(500);
        ObjectAnimator fadeIn2 = ObjectAnimator.ofFloat(halo_left, "alpha",0.1f,0.5f);
        fadeIn.setDuration(500);

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
        Intent main_page = new Intent(ScanRoom.this, StrapToChair.class);
        startActivity(main_page);
    }
}
