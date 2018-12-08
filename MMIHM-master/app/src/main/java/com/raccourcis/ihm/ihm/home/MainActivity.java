package com.raccourcis.ihm.ihm.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;

import com.raccourcis.ihm.ihm.R;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    public static int shorcut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Menu");
        intent=null;
        Button buttonApp = (Button)  findViewById(R.id.buttonApp);
        Button buttonShortCut = (Button)  findViewById(R.id.buttonShortCut);
        Button buttonVocalRec = findViewById(R.id.buttonVocalRec);
        buttonApp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(v.getContext(), ApplicationsActivity.class);
                shorcut=0;
                startActivity(intent);
            }
        });
        buttonShortCut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(v.getContext(), ShortcutssActivity.class);
                //intent.putExtra("classShortcut", "classShortcut");
                shorcut=1;
                startActivity(intent);
            }
        });
        buttonVocalRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ReconnaissanceVocale.class);
                startActivity(intent);

            }
        });
    }
}