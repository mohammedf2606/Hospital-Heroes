package com.hummer.educationalgame;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    private static MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this,R.raw.background_music);
        player.setLooping(true);
        player.setVolume(0.5f, 0.5f);
        player.start();
        return START_STICKY;
    }

    public static void pause() {
        player.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }


}

