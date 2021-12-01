package com.example.td4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView show_sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_sec = findViewById(R.id.showsec);
    }

    @SuppressLint("SetTextI18n")
    public void startOperation(View v) {
        startService(new Intent(MainActivity.this, CountService.class));
        show_sec.setText("Clock is running, click on get to show when your counter is.");
    }

    public void stopOperation(View v){
        stopService(new Intent(MainActivity.this, CountService.class));
    }

    @SuppressLint("SetTextI18n")
    public void getcount(View v){
        show_sec.setText("Count : " + CountService.instance.getCount());
        try{
            show_sec.setText("Count : " + CountService.instance.getCount());
        }catch (Exception e) {
            show_sec.setText("Le service n'est pas démarré");
        }

    }
}