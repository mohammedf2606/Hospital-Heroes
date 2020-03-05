package com.hummer.educationalgame;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MusicService extends Service {

    private static MediaPlayer player;
    private static ArrayList<Integer> playlist;
    private Timer timer;
    private int i = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        playlist = new ArrayList<>();
        playlist.add(R.raw.background_music);
        playlist.add(R.raw.background_music_2);
        player = MediaPlayer.create(this, playlist.get(i));
        player.setLooping(true);
        player.setVolume(0.5f, 0.5f);
        player.start();
        timer = new Timer();
        if (playlist.size() > 1) playNext();
        return START_STICKY;
    }

    private void playNext() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.reset();
                player = MediaPlayer.create(MusicService.this, playlist.get(++i));
                player.start();
                if (playlist.size() > i+1) {
                    playNext();
                }
            }
        }, player.getDuration()+100);
    }

    public static void pause() {
        player.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        player.stop();
    }


}

