/*
 * *
 *  * Created by Arslan on 2/9/19 4:36 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 2/9/19 4:36 AM
 *
 */

package com.example.telenorassignmentapp.Adapters;



import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.telenorassignmentapp.Models.FilmModel;
import com.example.telenorassignmentapp.R;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<FilmModel> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, director, producer, release_date, score, description;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            description = view.findViewById(R.id.description);
            release_date = view.findViewById(R.id.release_date);
            score = view.findViewById(R.id.score);
            director = view.findViewById(R.id.director);
            producer = view.findViewById(R.id.producer);
        }
    }


    public MoviesAdapter(List<FilmModel> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_film_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FilmModel movie = moviesList.get(position);
        holder.title.setText( Html.fromHtml( "<b>" + "Title: " + "</b> " +  movie.getTitle()));
        holder.description.setText(Html.fromHtml( "<b>" + "Description: " + "</b> " +  movie.getDescription() ));
        holder.score.setText(Html.fromHtml( "<b>" + "Score: " + "</b> "  + movie.getRt_score()));
        holder.release_date.setText(Html.fromHtml( "<b>" + "Release Date: " + "</b> " + movie.getRelease_date()));
        holder.director.setText(Html.fromHtml( "<b>" + "Director: " + "</b> " +  movie.getDirector()));
        holder.producer.setText(Html.fromHtml( "<b>" + "Producer: " + "</b> " + movie.getProducer()));

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}