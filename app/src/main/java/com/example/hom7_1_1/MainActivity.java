package com.example.hom7_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {   //timeInt lunch night

    private static final int MIDNIGHT_START_TIME_HOUR = 0;
    private static final int MORNING_START_TIME_HOUR = 6;
    private static final int AFTERNOON_START_TIME_HOUR = 14;
    private static final int EVENING_START_TIME_HOUR = 15;
    private static final int MIDNIGHT_ITEM_START_TIME_HOUR = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        Button button = findViewById(R.id.bottom_synchronization);
        final int timeInt = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        textView.setText("" + timeInt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SYNC);
                if (MIDNIGHT_START_TIME_HOUR <= timeInt && timeInt < MORNING_START_TIME_HOUR) {
                    intent.setData(Uri.parse("http://evening"));

                } else if (MORNING_START_TIME_HOUR <= timeInt && timeInt < AFTERNOON_START_TIME_HOUR) {
                    intent.setData(Uri.parse("http://morning"));

                } else if (timeInt == AFTERNOON_START_TIME_HOUR) {
                    intent.setData(Uri.parse("http://afternoon"));

                } else if (EVENING_START_TIME_HOUR <= timeInt && timeInt < MIDNIGHT_ITEM_START_TIME_HOUR) {
                    intent.setData(Uri.parse("http://evening"));

                }
                startActivity(intent);
            }
        });
    }
}
