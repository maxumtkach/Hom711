package com.example.hom7_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {   //timeInt lunch night

    private TextView textView;
    private String[] valuesTime;
    private int timeInt;
    private int nighttimeInt;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initV0iew();

        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        valuesTime = currentTimeString.split(":");

        String valuesTimeIndex = valuesTime[0];
        timeInt = Integer.parseInt(valuesTimeIndex);

        nighttimeInt = Integer.parseInt(valuesTimeIndex);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SYNC);
                if (14 > timeInt && timeInt >= 6) {
                    intent.setData(Uri.parse("http://morning"));

                } else if (timeInt == 14) {
                    intent.setData(Uri.parse("http://afternoon"));

                } else if (6 > timeInt) {
                    intent.setData(Uri.parse("http://evening"));

                } else if (nighttimeInt >= 15) {
                    intent.setData(Uri.parse("http://evening"));

                } else {
                    textView.setText(R.string.time_error);
                }
                startActivity(intent);
            }
        });
    }

    public void initV0iew() {
        textView = findViewById(R.id.text);
        button = findViewById(R.id.bottom_synchronization);

    }
}
