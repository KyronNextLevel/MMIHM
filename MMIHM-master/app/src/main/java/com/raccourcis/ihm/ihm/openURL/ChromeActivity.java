package com.raccourcis.ihm.ihm.openURL;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.raccourcis.ihm.ihm.home.MainActivity;
import com.raccourcis.ihm.ihm.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChromeActivity extends AppCompatActivity {
    Intent intent;
    ListView listApplication;
    String applicationsList[] = {"GOOGLE", "YAHOO","YOUTUBE","Translate","facebook","Gmail","google map","Emplois du Temps"};
    Button btn_stop;
    int shorcut=MainActivity.shorcut;
    public static String shortcutName;
    private static final String FILE_NAME = "example.txt";
    String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        getSupportActionBar().setTitle("URL LIST");
        // Return Button on action Bar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        intent = null;
        URL="";
        btn_stop= (Button) findViewById(R.id.btn_stop);
        detectMotherActivity();
        listApplication = (ListView)findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, applicationsList);
        listApplication.setAdapter(adapter);
        listApplication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch(position) {
                    case 0:
                        URL = "http://www.google.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(URL));
                        shortcutName=applicationsList[0];
                        createShortcutOfApp2(shortcutName,URL);
                        save();
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 1:
                        URL = "http://www.yahoo.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(URL));
                        shortcutName=applicationsList[1];
                        createShortcutOfApp2(shortcutName,URL);
                        save();
                        if (shorcut==0)
                        startActivity(intent);

                        break;
                    case 2:
                        URL = "http://www.youtube.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(URL));
                        shortcutName=applicationsList[2];
                        createShortcutOfApp2(shortcutName,URL);
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 3:
                        URL = "https://translate.google.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(URL));
                        shortcutName=applicationsList[3];
                        createShortcutOfApp2(shortcutName,URL);
                        save();
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 4:
                        URL = "http://www.facebook.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(URL));
                        shortcutName=applicationsList[4];
                        createShortcutOfApp2(shortcutName,URL);
                        save();
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 5:
                        URL = "http://www.gmail.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(URL));
                        shortcutName=applicationsList[5];
                        createShortcutOfApp2(shortcutName,URL);
                        save();
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 6:
                        URL = "https://maps.google.com";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(URL));
                        shortcutName=applicationsList[6];
                        createShortcutOfApp2(shortcutName,URL);
                        save();
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                    case 7:
                        URL = "https://ade-sts.grenet.fr/direct/?data=1d04874d83cdeb5385d65d6b866a55a8d69dd3eac92a4c3b251eabfaebcfeeece1ad7e9965f1d08ec86f839c03d7c55aedc5434d4a4b357a3de531f9a55c6ba30d0c3641b6fe233b32a63d42d29c99af67c5f6923b60b09b60ebae19a89fba7d";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(URL));
                        shortcutName=applicationsList[7];
                        createShortcutOfApp2(shortcutName,URL);
                        save();
                        if (shorcut==0)
                            startActivity(intent);
                        break;
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);
        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);
        dialogBuilder.setTitle("Shortcut Name");
        dialogBuilder.setMessage("Enter yout shortcut name ");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
                shortcutName=edt.getText().toString();
                createShortcutOfApp(shortcutName);
                save();

            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
    void detectMotherActivity(){
        if (shorcut == 1) {
            btn_stop.setVisibility(View.VISIBLE);
            btn_stop.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    showChangeLangDialog();
                }
            });
        } else {
            btn_stop.setVisibility(View.GONE);
        }
    }
    public void save() {
        String text = shortcutName;
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(text.getBytes());
            fos.write(System.lineSeparator().getBytes());
            //Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void createShortcutOfApp2(String shortcutName, String URL) {
        Intent shortcutIntent = new Intent();
        shortcutIntent.setAction(Intent.ACTION_VIEW);
        shortcutIntent.setData(Uri.parse(URL));

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(getApplicationContext(),R.mipmap.ic_launcher));

        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        addIntent.putExtra("duplicate", false);  //may it's already there so   don't duplicate
        getApplicationContext().sendBroadcast(addIntent);
    }

    public void createShortcutOfApp(String shortcutName) {
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


}

