package com.raccourcis.ihm.ihm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ContactActivity extends AppCompatActivity {
    ListView listApplication;
    String applicationsList[] = {"Achraf", "Ahmed", "Peo", "Rana"};
    Intent intent;
    Button btn_stop;
    int shorcut=MainActivity.shorcut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        intent = null;
        btn_stop= (Button) findViewById(R.id.btn_stop);
        detectMotherActivity();
        listApplication = (ListView)findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, applicationsList);
        listApplication.setAdapter(adapter);
        listApplication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch(position) {
                    case 0:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
    void detectMotherActivity(){

        if (shorcut==1) {
            btn_stop.setVisibility(View.VISIBLE);
        }
        else {
            btn_stop.setVisibility(View.GONE);
        }
    }
}
