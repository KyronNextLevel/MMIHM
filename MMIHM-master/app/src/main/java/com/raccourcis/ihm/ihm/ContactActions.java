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
    String applicationsList[] = {"Appeler","Envoyer un message","supprimer"};
    Intent intent;
    Context context;
    Button btn_stop;
    String shortcutName=ContactActivity.shortcutName;
    String contactName=ContactActivity.contactName;
    int shorcut=MainActivity.shorcut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        getSupportActionBar().setTitle("Contacts - "+contactName);
        intent = null;
        btn_stop= (Button) findViewById(R.id.btn_stop);
        detectMotherActivity();
        listApplication = (ListView)findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, applicationsList);
        listApplication.setAdapter(adapter);
        listApplication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch(position) {

                    case 0: context = getApplicationContext();
                            shortcutName=applicationsList[0]+contactName;
                            Toast.makeText(context, "Appel en cours",Toast.LENGTH_LONG).show();
                            if (shorcut==1)
                                createShortcutOfApp(shortcutName);
                            Intent callIntent = new Intent(Intent.ACTION_DIAL );
                            callIntent.setData(Uri.parse("tel:123456789"));
                            startActivity(callIntent);
                            break;
                            case 1: context = getApplicationContext();
                            shortcutName=applicationsList[1]+contactName;
                            Toast.makeText(context, "Message en cours",Toast.LENGTH_LONG).show();
                            if (shorcut==1)
                                createShortcutOfApp(shortcutName);
                            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                            sendIntent.setData(Uri.parse("sms:"));
                            startActivity(sendIntent);
                            break;
                    case 2: context = getApplicationContext();
                            shortcutName=applicationsList[2]+contactName;
                            Toast.makeText(context, "Suppression en cours",Toast.LENGTH_LONG).show();
                            break;
                }
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createShortcutOfApp(shortcutName);
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

    public void createShortcutOfApp(String shortcutName) {
        Intent shortcutIntent = new Intent(getApplicationContext(), ContactActions.class);
        shortcutIntent.setAction(Intent.ACTION_MAIN);
        Intent addIntent = new Intent();

        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_TITLE,shortcutName);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                R.mipmap.ic_launcher));

        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        addIntent.putExtra("duplicate", false);  //may it's already there so   don't duplicate
        getApplicationContext().sendBroadcast(addIntent);
    }
}
