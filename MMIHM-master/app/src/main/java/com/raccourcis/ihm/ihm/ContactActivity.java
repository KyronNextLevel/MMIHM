package com.raccourcis.ihm.ihm;

import android.app.Activity;
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
    String contactsList[] = {"Achraf", "Ahmed", "Peo", "Rana","Antoine","Juan","Mostapha","Remi","Rami","So","Let","simba",};
    Intent intent;
    Button btn_stop;
    public static String shortcutName;
    public static String contactName;
    int shorcut=MainActivity.shorcut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        getSupportActionBar().setTitle("Contacts");
        shortcutName="Contacts";
        intent = null;
        btn_stop= (Button) findViewById(R.id.btn_stop);
        detectMotherActivity();
        listApplication = (ListView)findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, contactsList);
        listApplication.setAdapter(adapter);
        listApplication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                contactName="";
                switch(position) {

                    case 0:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[0];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[1];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[2];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(v.getContext(), ContactActions.class);
                        contactName=contactsList[3];
                        shortcutName="Contacts/"+contactName;
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    void detectMotherActivity(){
        if (shorcut==1) {
            btn_stop.setVisibility(View.VISIBLE);
            btn_stop.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    createShortcutOfApp(shortcutName);
                }
            });
        }
        else {
            btn_stop.setVisibility(View.GONE);
        }
    }

    public void createShortcutOfApp(String shortcutName) {
        Intent shortcutIntent = new Intent(getApplicationContext(), ContactActivity.class);
        shortcutIntent.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                R.mipmap.ic_launcher));

        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        addIntent.putExtra("duplicate", false);  //may it's already there so   don't duplicate
        getApplicationContext().sendBroadcast(addIntent);
    }
}

