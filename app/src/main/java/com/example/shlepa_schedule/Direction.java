package com.example.shlepa_schedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Direction extends AppCompatActivity
        implements DirectionFragment.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);
    }

    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this, Schedule.class);
        startActivity(intent);
    }
}