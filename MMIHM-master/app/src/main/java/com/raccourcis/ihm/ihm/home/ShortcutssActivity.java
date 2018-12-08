package com.raccourcis.ihm.ihm.home;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.Toast;

import com.raccourcis.ihm.ihm.R;
import com.raccourcis.ihm.ihm.contacts.ContactActions;
import com.raccourcis.ihm.ihm.contacts.ContactActivity;
import com.raccourcis.ihm.ihm.dailyActivities.AlarmActivity;
import com.raccourcis.ihm.ihm.dailyActivities.DailyActivities;
import com.raccourcis.ihm.ihm.openURL.ChromeActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ShortcutssActivity extends AppCompatActivity {
    Intent intent;
    String URL;
    PackageManager packageManager;
    ArrayList<String> lines = new ArrayList<String>();
    ListView shortcuts;
    static final int READ_BLOCK_SIZE = 100;
    private static final String FILE_NAME = "example.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shortcut);
        getSupportActionBar().setTitle("Shortcuts");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        intent =null;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(getFilesDir() + "/" + FILE_NAME));
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                lines.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.close();
        shortcuts = (ListView)findViewById(R.id.installed_app_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, lines);
        shortcuts.setAdapter(adapter);
        shortcuts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String name = (String) parent.getItemAtPosition(position);
                if(name.toLowerCase().contains("alarm")) {
                    intent = new Intent(ShortcutssActivity.this, AlarmActivity.class);
                    startActivity(intent);
                }
                if(name.toLowerCase().contains("daily")) {
                    intent = new Intent(ShortcutssActivity.this, DailyActivities.class);
                    startActivity(intent);
                }
                if(name.toLowerCase().contains("daily")) {
                    intent = new Intent(ShortcutssActivity.this, DailyActivities.class);
                    startActivity(intent);
                }
                if(name.toLowerCase().contains("url") || name.toLowerCase().contains("website")) {
                    intent = new Intent(ShortcutssActivity.this, ChromeActivity.class);
                    startActivity(intent);
                }
                if( name.toLowerCase().contains("rana") && name.toLowerCase().contains("appel")) {
                    ContactActivity.contactName="Rana";
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0652421124"));
                    Toast.makeText(getApplicationContext(), "Appel en cours",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                if( name.toLowerCase().contains("achraf") && name.toLowerCase().contains("appel")) {
                    ContactActivity.contactName="Achraf";
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0725441237"));
                    Toast.makeText(getApplicationContext(), "Appel en cours",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                if( name.toLowerCase().contains("ahmed") && name.toLowerCase().contains("appel")) {
                    ContactActivity.contactName="Ahmed";
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0476881934"));
                    Toast.makeText(getApplicationContext(), "Appel en cours",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                if( name.toLowerCase().contains("peo") && name.toLowerCase().contains("appel")) {
                    ContactActivity.contactName="Peo";
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0605899910"));
                    Toast.makeText(getApplicationContext(), "Appel en cours",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                if( (name.toLowerCase().contains("rana") && name.toLowerCase().contains("contact")) || name.toLowerCase().contains("rana") ) {
                    ContactActivity.contactName="Rana";
                    intent = new Intent(ShortcutssActivity.this, ContactActions.class);
                    startActivity(intent);
                }
                if( (name.toLowerCase().contains("achraf") && name.toLowerCase().contains("contact")) || name.toLowerCase().contains("achraf") ) {
                    ContactActivity.contactName="Achraf";
                    intent = new Intent(ShortcutssActivity.this, ContactActions.class);
                    startActivity(intent);
                }
                if( (name.toLowerCase().contains("ahmed") && name.toLowerCase().contains("contact")) || name.toLowerCase().contains("ahmed") ) {
                    ContactActivity.contactName="Ahmed";
                    intent = new Intent(ShortcutssActivity.this, ContactActions.class);
                    startActivity(intent);
                }
                if( (name.toLowerCase().contains("peo") && name.toLowerCase().contains("contact")) || name.toLowerCase().contains("peo") ) {
                    ContactActivity.contactName="Peo";
                    intent = new Intent(ShortcutssActivity.this, ContactActions.class);
                    startActivity(intent);
                }
                if(name.toLowerCase().toLowerCase().contains("google")){
                    URL = "http://www.google.com";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(URL));
                    startActivity(intent);
                }
                if(name.toLowerCase().contains("yahoo")){
                    URL = "http://www.yahoo.com";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(URL));
                    startActivity(intent);
                }
                if(name.toLowerCase().contains("youtube")){
                    URL = "http://www.youtube.com";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(URL));
                    startActivity(intent);
                }
                if(name.toLowerCase().contains("facebook")){
                    URL = "http://www.facebook.com";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(URL));
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.add:
            intent = new Intent(ShortcutssActivity.this, ApplicationsActivity.class);
            startActivity(intent);
            return(true);
        case android.R.id.home:
            //Write your logic here
            this.finish();
            return true;
    }
        return(super.onOptionsItemSelected(item));
    }

}