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
import android.view.Menu;
import android.view.MenuItem;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<FilmModel> movieList = new ArrayList<>();
    private List<PeopleModel> peopleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private String TAG = "Scrolling Activity tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        callingPeopleWebAPi();


    }

    private  void callingFilmsWebApi(){
        /*-------------- Getting the filmList----------------*/
        AndroidNetworking.get("https://ghibliapi.herokuapp.com/films")
                .addPathParameter("pageNumber", "0")
//                .addQueryParameter("limit", "3")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(FilmModel.class, new ParsedRequestListener<List<FilmModel>>() {
                    @Override
                    public void onResponse(List<FilmModel> films) {
                        // do anything with response
                        Log.d(TAG, "userList size : " + films.size());
                        for (FilmModel oneFilm : films) {
                            Log.d(TAG, "id : " + oneFilm.getId());
                            Log.d(TAG, "firstname : " + oneFilm.getTitle());
                            Log.d(TAG, "lastname : " + oneFilm.getProducer());
                        }

                        movieList.clear();
                        movieList.addAll(films);


                        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

                        mAdapter = new MoviesAdapter(movieList);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(mAdapter);


                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.d(TAG, "Error : " + anError.getErrorBody());
                    }
                });
    }

    private void callingPeopleWebAPi(){
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
                        recyclerView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent myIntent = new Intent(MainActivity.this, FilmListActivity.class);
                                myIntent.putExtra("key", value); //Optional parameters
                                startActivity(myIntent);
                            }
                        });


                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.d(TAG, "Error : " + anError.getErrorBody());
                    }
                });
    }


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
