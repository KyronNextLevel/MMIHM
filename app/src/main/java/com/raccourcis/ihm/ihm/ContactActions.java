package com.raccourcis.ihm.ihm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ContactActions extends AppCompatActivity {
    ListView listApplication;
    String applicationsList[] = {"Appeler", "Messager", "supprimer"};
    Intent intent;
    Context context;
    Button btn_stop;
    int shorcut=MainActivity.shorcut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listApplication = (ListView)findViewById(R.id.ListView);
        intent = null;
        btn_stop= (Button) findViewById(R.id.btn_stop);
        detectMotherActivity();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, applicationsList);
        listApplication.setAdapter(adapter);
        listApplication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch(position) {

                    case 0: context = getApplicationContext();
                            Toast.makeText(context, "Appel en cours",Toast.LENGTH_LONG).show();
                            Intent callIntent = new Intent(Intent.ACTION_DIAL );
                            callIntent.setData(Uri.parse("tel:123456789"));
                            startActivity(callIntent);
                            break;
                    case 1: context = getApplicationContext();
                            Toast.makeText(context, "Message en cours",Toast.LENGTH_LONG).show();
                            break;
                    case 2: context = getApplicationContext();
                            Toast.makeText(context, "Suppression en cours",Toast.LENGTH_LONG).show();
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
