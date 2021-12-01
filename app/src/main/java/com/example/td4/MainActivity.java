package com.example.td4;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Thread count_service = new Thread(new Runnable() {
        @Override
        public void run() {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (count_service_running) counter +=1;
                }
            }, 1, 1000);
        }
    });
    private boolean count_service_running = false;
    private int counter = 0;
    private TextView show_sec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count_service.start();
        show_sec = (TextView) findViewById(R.id.showsec);
    }

    public void startOperation(View v) {
        if (count_service_running) {
            return;
        }
        count_service_running = true;
        counter = 0;
    }

    public void stopOperation(View v) {
        count_service_running=false;
    }

    public void getcount(View v){
        show_sec.setText(String.valueOf(counter));
    }
}