package com.raccourcis.ihm.ihm.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.raccourcis.ihm.ihm.contacts.ContactActivity;
import com.raccourcis.ihm.ihm.dailyActivities.DailyActivities;
import com.raccourcis.ihm.ihm.media.MediaActivity;
import com.raccourcis.ihm.ihm.openURL.ChromeActivity;
import com.raccourcis.ihm.ihm.R;

public class ApplicationsActivity extends AppCompatActivity {
    ListView listApplication;
    Button btn_stop;
    String applicationsList[] = {"Contacts", "OpenUrl","Media", "Daily Activities"};
    Intent intent;
    public static String shorcutName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        getSupportActionBar().setTitle("Applications");
        // Return Button on action Bar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        intent=null;
        btn_stop= (Button) findViewById(R.id.btn_stop);
        listApplication = (ListView)findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, applicationsList);
        listApplication.setAdapter(adapter);
        listApplication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch(position) {
                    case 0: intent = new Intent(v.getContext(), ContactActivity.class);
                            shorcutName="Contacts/";
                            startActivity(intent);break;
                    case 1: intent = new Intent(v.getContext(), ChromeActivity.class);
                            shorcutName="Open URL/";
                            startActivity(intent);break;
                    case 2: intent = new Intent(v.getContext(),MediaActivity.class);
                            shorcutName="Media/";
                            startActivity(intent);break;
                    case 3: intent = new Intent(v.getContext(),DailyActivities.class);
                            shorcutName="Daily Activities/";
                            startActivity(intent);break;
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                intent = new Intent(ApplicationsActivity.this,ShortcutssActivity.class);
                startActivity(intent);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}