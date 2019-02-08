/*
 * *
 *  * Created by Arslan on 2/9/19 4:37 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 2/9/19 4:23 AM
 *
 */

package com.example.telenorassignmentapp.Utility;

import android.app.Activity;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.telenorassignmentapp.Activities.FilmListActivity;
import com.example.telenorassignmentapp.Activities.MainActivity;
import com.example.telenorassignmentapp.Adapters.MoviesAdapter;
import com.example.telenorassignmentapp.Adapters.PeopleAdapter;
import com.example.telenorassignmentapp.Models.FilmModel;
import com.example.telenorassignmentapp.Models.PeopleModel;

import java.util.List;

public class NetworkCalls {
    /**
     * method to call all the people list
     * these are all the casts of the movie
     *
     * @param mActivity
     * @param URL
     * @param pb_loader
     * @param peopleList
     * @param mPeopleAdapter
     * @param coordinatorLayout
     * @param TAG
     */
    public static void callingPeopleWebAPi(final Activity mActivity, String URL, final ProgressBar pb_loader,
                                           final List<PeopleModel> peopleList, final PeopleAdapter mPeopleAdapter,
                                           final CoordinatorLayout coordinatorLayout, final String TAG){
        AndroidNetworking.get(URL)
                .addPathParameter("pageNumber", "0")
                .setTag(mActivity)
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsObjectList(PeopleModel.class, new ParsedRequestListener<List<PeopleModel>>() {
                    @Override
                    public void onResponse(List<PeopleModel> films) {
                        // do anything with response
                        pb_loader.setVisibility(View.GONE);

                        peopleList.clear();
                        peopleList.addAll(films);
                        mPeopleAdapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.d(TAG, "Error : " + anError.getErrorBody());
                        pb_loader.setVisibility(View.GONE);
                        ((BaseActivity) mActivity).showErrorMessage(String.valueOf(anError.getMessage()), coordinatorLayout);
                    }
                });
    }


    /**
     * Downloading list of film of each cast
     *  and showing it in the recycler view ater clicked on each people
     *  @param mActivity
     * @param urls
     * @param pb_loader
     * @param movieList
     * @param mAdapter
     * @param coordinatorLayout
     * @param TAG
     */
    public static void callingFilmsWebApi(final Activity mActivity, String urls, final ProgressBar pb_loader,
                                          final List<FilmModel> movieList, final MoviesAdapter mAdapter, final CoordinatorLayout coordinatorLayout, final String TAG){
        /*-------------- Getting the filmList----------------*/

        AndroidNetworking.get(urls)
//                .addPathParameter("userId", "1")
                .setTag(mActivity)
                .setPriority(Priority.IMMEDIATE)
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
                        ((BaseActivity) mActivity).showErrorMessage(String.valueOf(anError.getMessage()), coordinatorLayout);
                    }
                });
    }


}
