/*
 * *
 *  * Created by Arslan on 2/9/19 4:36 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 2/9/19 4:23 AM
 *
 */

package com.example.telenorassignmentapp.Activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import com.example.telenorassignmentapp.Adapters.MoviesAdapter;
import com.example.telenorassignmentapp.Models.FilmModel;
import com.example.telenorassignmentapp.Models.PeopleModel;
import com.example.telenorassignmentapp.R;
import com.example.telenorassignmentapp.Utility.BaseActivity;
import com.example.telenorassignmentapp.Utility.Constants;
import com.example.telenorassignmentapp.Utility.NetworkCalls;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class FilmListActivity extends BaseActivity {

    private List<FilmModel> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private String TAG = "Film Activity tag";
    private CoordinatorLayout coordinatorLayout;
    private ProgressBar pb_loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingToolbar(Constants.FilmToolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        pb_loader = findViewById(R.id.pb_loader);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        PeopleModel onePersonModel = (PeopleModel) Parcels.unwrap(getIntent().getParcelableExtra("films"));
        for (String urls: onePersonModel.getFilms()) {
            pb_loader.setVisibility(View.VISIBLE);
            NetworkCalls.callingFilmsWebApi(FilmListActivity.this, urls,
                    pb_loader, movieList, mAdapter,coordinatorLayout, TAG);

        }

    }

}
