package com.raccourcis.ihm.ihm.contacts;

import android.app.AlertDialog;
import android.content.Context;
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
import android.widget.Toast;

import com.raccourcis.ihm.ihm.home.MainActivity;
import com.raccourcis.ihm.ihm.R;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class ContactActions extends AppCompatActivity {
    ListView listApplication;
    String applicationsList[] = {"Appeler","Envoyer un message","supprimer"};
    Intent intent;
    Context context;
    Button btn_stop;
    public static String shortcutName;
    public static String contactName;
    int shorcut = MainActivity.shorcut;
    String phoneNumber;
    private static final String FILE_NAME = "example.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        contactName=ContactActivity.contactName;
        if(contactName=="Rana")
            phoneNumber="0652421124";
        if(contactName=="Achraf")
            phoneNumber="0725441237";
        if(contactName=="Ahmed")
            phoneNumber="0476881934";
        if(contactName=="Peo")
            phoneNumber="0605899910";
        getSupportActionBar().setTitle("Contacts - "+contactName);
        // Return Button on action Bar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        intent = null;
        context = getApplicationContext();
        btn_stop= (Button) findViewById(R.id.btn_stop);
        detectMotherActivity();
        listApplication = (ListView)findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, applicationsList);
        listApplication.setAdapter(adapter);
        listApplication.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch(position) {

                    case 0: shortcutName=applicationsList[0]+contactName;
                            intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parse("tel:"+phoneNumber));
                            if (shorcut==1)
                                createShortcutOfApp2(shortcutName,intent);
                            else {
                                Toast.makeText(context, "Appel en cours",Toast.LENGTH_LONG).show();
                                startActivity(intent);
                            }
                            break;
                    case 1: shortcutName=applicationsList[1]+contactName;
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("sms:"+phoneNumber));
                            if (shorcut==1)
                                createShortcutOfApp2(shortcutName,intent);
                            else {
                                Toast.makeText(context, "Message en cours",Toast.LENGTH_LONG).show();
                                startActivity(intent);
                            }
                            break;
                    case 2: shortcutName=applicationsList[2]+contactName;
                            Toast.makeText(context, "Suppression en cours",Toast.LENGTH_LONG).show();
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

    public void createShortcutOfApp(String shortcutName) {
        Intent shortcutIntent = new Intent(getApplicationContext(), ContactActions.class);
        shortcutIntent.setAction(Intent.ACTION_MAIN);
        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_TITLE,shortcutName);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.ic_launcher));
        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        addIntent.putExtra("duplicate", false);  //may it's already there so   don't duplicate
        getApplicationContext().sendBroadcast(addIntent);
    }

    public void createShortcutOfApp2(String shortcutName, Intent shortcutIntent) {
        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.ic_launcher));
        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        addIntent.putExtra("duplicate", false);  //may it's already there so   don't duplicate
        getApplicationContext().sendBroadcast(addIntent);
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
}
