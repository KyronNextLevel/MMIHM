package com.example.ahmed.testapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class browser1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser1);

        final ListView listviewBrowser = (ListView) findViewById(R.id.listview);
        String[] values = new String[]{"Search", "Bookmarks", "History"};
        final ArrayList<String> alistBrowser = new ArrayList<String>();
        for (int i = 0; i < values.length; i++) {
            alistBrowser.add(values[i]);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alistBrowser);
        listviewBrowser.setAdapter(adapter);

        listviewBrowser.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                //Navigation vers l'autre liste
                                view.setAlpha(1);
                            }
                        });
            }

        });
    }
}
