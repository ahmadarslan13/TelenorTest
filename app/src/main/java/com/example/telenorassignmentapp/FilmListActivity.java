package com.example.telenorassignmentapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class FilmListActivity extends AppCompatActivity {

    private List<FilmModel> movieList = new ArrayList<>();
    private List<PeopleModel> peopleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private String TAG = "Film Activity tag";

    private ProgressBar pb_loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Film Names");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        pb_loader = findViewById(R.id.pb_loader);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        PeopleModel onePersonModel = (PeopleModel) Parcels.unwrap(getIntent().getParcelableExtra("films"));

        for (String urls: onePersonModel.getFilms()) {
            pb_loader.setVisibility(View.VISIBLE);
            callingFilmsWebApi(urls);
        }




    }

    private  void callingFilmsWebApi(String urls){
        /*-------------- Getting the filmList----------------*/

        AndroidNetworking.get(urls)
                .addPathParameter("userId", "1")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(FilmModel.class, new ParsedRequestListener<FilmModel>() {
                    @Override
                    public void onResponse(FilmModel films) {
                        // do anything with response
                        movieList.add(films);
                        mAdapter.notifyDataSetChanged();
                        pb_loader.setVisibility(View.GONE);

                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.d(TAG, "Error : " + anError.getErrorBody());
                        pb_loader.setVisibility(View.GONE);
                    }
                });
    }

 /*   private void callingPeopleWebAPi(){
        AndroidNetworking.get("https://ghibliapi.herokuapp.com/people/")
                .addPathParameter("pageNumber", "0")
//                .addQueryParameter("limit", "3")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(PeopleModel.class, new ParsedRequestListener<List<PeopleModel>>() {
                    @Override
                    public void onResponse(List<PeopleModel> films) {
                        // do anything with response
                        Log.d(TAG, "userList size : " + films.size());
                        for (PeopleModel oneFilm : films) {
                            Log.d(TAG, "id : " + oneFilm.getId());
                            Log.d(TAG, "firstname : " + oneFilm.getAge());
                            Log.d(TAG, "lastname : " + oneFilm.getGender());
                        }

                        peopleList.clear();
                        peopleList.addAll(films);


                        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

                        PeopleAdapter mPeopleAdapter = new PeopleAdapter(peopleList);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(mPeopleAdapter);


                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.d(TAG, "Error : " + anError.getErrorBody());
                    }
                });
    }*/


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
