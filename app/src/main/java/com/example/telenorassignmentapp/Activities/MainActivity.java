/*
 * *
 *  * Created by Arslan on 2/9/19 4:37 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 2/9/19 4:14 AM
 *
 */

package com.example.telenorassignmentapp.Activities;

import android.os.Bundle;
import android.view.View;
import com.example.telenorassignmentapp.R;
import com.example.telenorassignmentapp.Utility.BaseActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen config = new EasySplashScreen(MainActivity.this)
                .withFullScreen()
                .withTargetActivity(PeopleListActivity.class)
                .withSplashTimeOut(3000)
                .withLogo(R.drawable.telenor_logo);

        //create the view
        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }

}
