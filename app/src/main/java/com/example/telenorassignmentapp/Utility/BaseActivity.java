/*
 * *
 *  * Created by Arslan on 2/9/19 4:37 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 2/9/19 4:09 AM
 *
 */

package com.example.telenorassignmentapp.Utility;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.telenorassignmentapp.Activities.MainActivity;
import com.example.telenorassignmentapp.R;

import gr.net.maroulis.library.EasySplashScreen;

public abstract class BaseActivity extends AppCompatActivity {
    protected void settingToolbar(String tName){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tName);
    }

    protected void showErrorMessage(String message, CoordinatorLayout coordinatorLayout){

        if(message.contains("java.net.UnknownHostException")){
            message = Constants.NoInternetConnection;
        }
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }


}
