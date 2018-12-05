package com.raccourcis.ihm.ihm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ChromeActivity extends AppCompatActivity {
    Intent intent;
    ListView listApplication;
    String applicationsList[] = {"GOOGLE", "YAHOO","YOUTUBE","Translate","facebook","Gmail","google map","Emplois du Temps"};
    Button btn_stop;
    public static String shortcutName="Browser/";
    int shorcut=MainActivity.shorcut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        getSupportActionBar().setTitle("Browser");
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
                        String url = "http://www.google.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        shortcutName+=applicationsList[0];
                        createShortcutOfApp(shortcutName);
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 1:
                        String url1 = "http://www.yahoo.com";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url1));
                        shortcutName+=applicationsList[1];
                        createShortcutOfApp(shortcutName,intent);
                        if (shorcut==0)
                        startActivity(intent);

                        break;
                    case 2:
                        String url2 = "http://www.youtube.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url2));
                        shortcutName+=applicationsList[2];
                        createShortcutOfApp(shortcutName);
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 3:
                        String url3 = "https://translate.google.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url3));
                        shortcutName+=applicationsList[3];
                        createShortcutOfApp(shortcutName);
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 4:
                        String url4 = "http://www.facebook.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url4));
                        shortcutName+=applicationsList[4];
                        createShortcutOfApp(shortcutName);
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 5:
                        String url5 = "http://www.gmail.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url5));
                        shortcutName+=applicationsList[5];
                        createShortcutOfApp(shortcutName);
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 6:
                        String url6 = "https://maps.google.com";
                        Intent c = new Intent(Intent.ACTION_VIEW);
                        c.setData(Uri.parse(url6));
                        shortcutName+=applicationsList[6];
                        createShortcutOfApp(shortcutName);
                        if (shorcut==0)
                            startActivity(c);
                        break;
                    case 7:
                        String url8 = "https://ade-sts.grenet.fr/direct/?data=1d04874d83cdeb5385d65d6b866a55a8d69dd3eac92a4c3b251eabfaebcfeeece1ad7e9965f1d08ec86f839c03d7c55aedc5434d4a4b357a3de531f9a55c6ba30d0c3641b6fe233b32a63d42d29c99af67c5f6923b60b09b60ebae19a89fba7d";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url8));
                        shortcutName+=applicationsList[7];
                        createShortcutOfApp(shortcutName);
                        if (shorcut==0)
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
    public void createShortcutOfApp(String shortcutNamen) {
        Intent shortcutIntent = new Intent(getApplicationContext(), ChromeActivity.class);
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

    public void createShortcutOfApp(String shortcutNamen, Intent shortcutIntent) {
        Intent shortcut = new Intent(getApplicationContext(), ChromeActivity.class);
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

