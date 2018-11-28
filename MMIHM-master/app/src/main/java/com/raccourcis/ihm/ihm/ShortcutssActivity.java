package com.raccourcis.ihm.ihm;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShortcutssActivity extends AppCompatActivity {
    Intent intent;
    PackageManager packageManager;
    ListView apkList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shortcut);
        getSupportActionBar().setTitle("Shortcuts");
        //apkList = (ListView) findViewById(R.id.installed_app_list);
        ListView userInstalledApps = (ListView)findViewById(R.id.installed_app_list);

        List<AppList> installedApps = getInstalledApps();
        AppAdapter installedAppAdapter = new AppAdapter(this, installedApps);
        userInstalledApps.setAdapter(installedAppAdapter);

    }
    private List<AppList> getInstalledApps() {
        List<AppList> res = new ArrayList<AppList>();
        // List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
        Intent shortcutsIntent = new Intent(Intent.ACTION_CREATE_SHORTCUT);
        //Intent shortcutsIntent = new Intent(Intent.ACTION_MAIN);
        List<ResolveInfo> packs = getPackageManager().queryIntentActivities(shortcutsIntent, 0);
        for (int i = 0; i < packs.size(); i++) {
            ResolveInfo p = packs.get(i);
                String appName = p.activityInfo.loadLabel(getPackageManager()).toString();
                Drawable icon = p.activityInfo.loadIcon(getPackageManager());
                res.add(new AppList(appName, icon));
        }
        return res;
    }

    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true : false;
    }

      /*

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long row) {
        PackageInfo packageInfo = (PackageInfo) parent
                .getItemAtPosition(position);
        AppData appData = (AppData) getApplicationContext();
        appData.setPackageInfo(packageInfo);

        Intent appInfo = new Intent(getApplicationContext(), ApkInfo.class);
        startActivity(appInfo);
    }
    */

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

    }
        return(super.onOptionsItemSelected(item));
    }
}
