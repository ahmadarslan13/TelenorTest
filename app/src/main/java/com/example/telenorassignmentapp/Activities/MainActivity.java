package com.example.telenorassignmentapp.Activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.telenorassignmentapp.Adapters.PeopleAdapter;
import com.example.telenorassignmentapp.Models.PeopleModel;
import com.example.telenorassignmentapp.R;
import com.example.telenorassignmentapp.Utility.BaseActivity;
import com.example.telenorassignmentapp.Utility.Constants;
import com.example.telenorassignmentapp.Utility.NetworkCalls;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private CoordinatorLayout coordinatorLayout;
    private List<PeopleModel> peopleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PeopleAdapter mPeopleAdapter;
    private String TAG = "Scrolling Activity tag";
    private ProgressBar pb_loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingToolbar(Constants.peopleToolbar);

        recyclerView = findViewById(R.id.recycler_view);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        mPeopleAdapter = new PeopleAdapter(peopleList, MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mPeopleAdapter);


        pb_loader = findViewById(R.id.pb_loader);
        pb_loader.setVisibility(View.VISIBLE);

        NetworkCalls.callingPeopleWebAPi(MainActivity.this, Constants.BaseURL + Constants.peopleAPI ,pb_loader, peopleList, mPeopleAdapter,coordinatorLayout, TAG);

    }

 }
