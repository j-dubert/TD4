package com.example.td4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class CountService extends Service {

    private int count = 0;

    public static CountService instance = null;

    private Thread countService = new Thread(new Runnable() {
        @Override
        public void run() {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    count +=1;
                }
            }, 1, 1000);
        }
    });

    @Override
    public void onCreate(){
        instance = this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);
        countService.start();

        return START_STICKY;
    }

    public void onDestroy(){
        super.onDestroy();
    }


    public String getCount(){
        return String.valueOf(count);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
