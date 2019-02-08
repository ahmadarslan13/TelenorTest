package com.example.telenorassignmentapp.Adapters;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.telenorassignmentapp.Activities.FilmListActivity;
import com.example.telenorassignmentapp.Models.PeopleModel;
import com.example.telenorassignmentapp.R;

import org.parceler.Parcels;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.MyViewHolder> {

    private List<PeopleModel> peopleList;
    Activity mActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, age, gender, eye_color, hair_color;
        public RelativeLayout rl_people_list;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.title);
            gender = view.findViewById(R.id.gender);
            age = view.findViewById(R.id.age);
            eye_color = view.findViewById(R.id.eye_color);
            hair_color = view.findViewById(R.id.hair_color);

            rl_people_list = view.findViewById(R.id.rl_people_list);
        }
    }


    public PeopleAdapter(List<PeopleModel> moviesList, Activity activity) {
        this.peopleList = moviesList;
        this.mActivity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_people_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final PeopleModel movie = peopleList.get(position);

        holder.name.setText(Html.fromHtml( "<b>" + "Name: " + "</b> " +  movie.getName() ));
        holder.gender.setText(Html.fromHtml( "<b>" + "Gender: " + "</b> "  + movie.getGender()));
        holder.age.setText(Html.fromHtml( "<b>" + "Age: " + "</b> " + movie.getAge()));
        holder.eye_color.setText(Html.fromHtml( "<b>" + "Eye Color: " + "</b> " +  movie.getEye_color()));
        holder.hair_color.setText(Html.fromHtml( "<b>" + "Hair Color: " + "</b> " + movie.getHair_color()));

        holder.rl_people_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mActivity, FilmListActivity.class);
                myIntent.putExtra("films", Parcels.wrap(movie)); //Optional parameters
                mActivity.startActivity(myIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }
}