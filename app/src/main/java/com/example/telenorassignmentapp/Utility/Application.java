package com.example.telenorassignmentapp.Utility;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.androidnetworking.AndroidNetworking;
import com.jacksonandroidnetworking.JacksonParserFactory;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class Application extends MultiDexApplication {
    private static Context context;

    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context){
        Application application = (Application) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        // initialize the AdMob app
//        MobileAds.initialize(this, getString(R.string.admob_app_id));
        Application.context = getApplicationContext();

        AndroidNetworking.initialize(getApplicationContext());

        // Adding an Network Interceptor for Debugging purpose :
//        OkHttpClient okHttpClient = new OkHttpClient() .newBuilder()
//                .addNetworkInterceptor(new StethoInterceptor())
//                .build();
//        AndroidNetworking.initialize(getApplicationContext(),okHttpClient);

        // Then set the JacksonParserFactory like below
        AndroidNetworking.setParserFactory(new JacksonParserFactory());

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher = LeakCanary.install(this);
    }
    public static Context getAppContext() {
        return Application.context;
    }
}
