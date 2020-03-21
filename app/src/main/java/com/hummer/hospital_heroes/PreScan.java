package com.hummer.hospital_heroes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class PreScan extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.pre_scan);
    }
}
