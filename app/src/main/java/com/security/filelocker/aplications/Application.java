package com.security.filelocker.aplications;

import com.zer.android.newsdk.ZAndroidSDK;

/**
 * Created by Peih Gnaoh on 8/22/2017.
 */

public class Application extends android.app.Application  {
    @Override
    public void onCreate() {
        super.onCreate();
        ZAndroidSDK.initApplication(this, getPackageName());
    }
}
