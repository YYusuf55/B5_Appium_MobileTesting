package com.mobile.utilities;

public enum App {
    CALCULATOR(
            "com.google.android.calculator",
            "com.android.calculator2.Calculator"
    ),
    AMAZON(
            "com.amazon.mShop.android.shopping",
            "com.amazon.windowshop.home.HomeLauncherActivity"
    )
    ;

    public String appPackage;
    public String appActivity;

    App(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }
}
