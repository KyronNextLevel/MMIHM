package com.example.ahmed.testapp1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OSActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os);

        final ListView listview = (ListView) findViewById(R.id.listview);
        String[] values = new String[]{"Browser", "Alarm", "Music", "Messages"};
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                //CHERCHER COMMENT DÉMARRER UNE ACTIVITÉ SUR UNE LISTE (AVEC INTENT OU NON)
                System.out.println("id " +id + " position " + position);
                //Navigation vers l'autre liste
                /*switch(position){
                    case 0 : Intent intent = new Intent(OSActivity.this,browser1Activity.class);
                             startActivity(intent);
                }*/


            }

        });

    }
}
