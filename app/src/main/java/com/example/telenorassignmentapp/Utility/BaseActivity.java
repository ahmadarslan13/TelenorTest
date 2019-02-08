package com.example.telenorassignmentapp.Utility;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.telenorassignmentapp.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected void settingToolbar(String tName){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tName);
    }

    protected void showErrorMessage(String message, CoordinatorLayout coordinatorLayout){
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }
}
