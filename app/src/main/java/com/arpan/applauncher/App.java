package com.arpan.applauncher;

public class App {

    private String mAppName;
    private String mAppActivity;

    public App(String appName, String appActivity) {
        mAppName = appName;
        mAppActivity = appActivity;
    }

    public String getAppName() {
        return mAppName;
    }

    public void setAppName(String appName) {
        mAppName = appName;
    }

    public String getAppActivity() {
        return mAppActivity;
    }

    public void setAppActivity(String appActivity) {
        mAppActivity = appActivity;
    }
}
