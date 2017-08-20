package com.arpan.applauncher;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mAppsRecyclerView;
    private static final String TAG = MainActivity.class.getSimpleName();
    private PackageManager pm;
    private List<App> mUApps = new ArrayList<App>();
    private App[] mApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppsRecyclerView = (RecyclerView) findViewById(R.id.AppsList);

        getAppsFromSystem(); //init mApps;

        AppsAdapter adapter = new AppsAdapter(mApps);
        mAppsRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mAppsRecyclerView.setLayoutManager(layoutManager);



    }

    private void getAppsFromSystem() {

        while (pm == null) {
            Log.d(TAG, "getAppsFromSystem: GETTING PACKAGE MANAGER...");
            pm = getPackageManager();
        }

        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        int i = 0;

        for (ApplicationInfo packageInfo : packages) {

            App app = new App(packageInfo.packageName, "" + pm.getLaunchIntentForPackage(packageInfo.packageName));
            mUApps.add(i, app);

//            Drawable drawable = packageInfo.

            Log.d(TAG, "getAppsFromSystem: APP ADDED AT INDEX " + i + "WITH: " + packageInfo.packageName + " | " + pm.getLaunchIntentForPackage(packageInfo.packageName));

            i++;
        }

        mApps = mUApps.toArray(new App[mUApps.size()]);

//        for (int j = 0; i < mUApps.size(); i++) {
//
//            mApps[j] = mUApps.get(j);
//
//        }

    }
}
