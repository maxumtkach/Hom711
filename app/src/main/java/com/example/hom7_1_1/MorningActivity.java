package com.example.hom7_1_1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Date;

public class MorningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);

        TextView timeTextView = findViewById(R.id.time_text);
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        timeTextView.setText(currentTimeString);
    }
}