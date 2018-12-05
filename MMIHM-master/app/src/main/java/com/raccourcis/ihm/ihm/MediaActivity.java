package com.raccourcis.ihm.ihm;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MediaActivity extends AppCompatActivity {
    ListView listApplication;
    String applicationsList[] = {"Images", "Music"};
    Intent intent;
    public static String shorcutName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        getSupportActionBar().setTitle("Applications");
        intent=null;
        shorcutName="Contacts";
        listApplication = (ListView)findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, applicationsList);
        listApplication.setAdapter(adapter);
        listApplication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch(position) {
                    case 0: intent = new Intent(v.getContext(), MusicActivity.class);
                        shorcutName="Images/";
                        startActivity(intent);break;
                    case 1: intent = new Intent(v.getContext(), PlayerActivity.class);
                        shorcutName="Music/";
                        startActivity(intent);break;

                }
            }
        });
    }
}
