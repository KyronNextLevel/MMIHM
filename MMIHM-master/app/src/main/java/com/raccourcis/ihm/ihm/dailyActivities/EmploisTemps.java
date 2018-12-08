package com.raccourcis.ihm.ihm.dailyActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.raccourcis.ihm.ihm.R;

public class EmploisTemps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emplois_du_temps);
        TextView text = (TextView) findViewById(R.id.textView3);
        ImageView image = (ImageView) findViewById(R.id.imageView3);


    }
}
