package com.raccourcis.ihm.ihm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EmploisTemps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emplois_du_temps);
        TextView text = (TextView) findViewById(R.id.textView3);
        ImageView image = (ImageView) findViewById(R.id.imageView3);


    }
}
