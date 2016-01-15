package com.example.elise.rottentomatoes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RottenTomatoesViewHolder> implements Serializable {

    private Movie[] movies;

    public RecyclerViewAdapter(Movie[] movies) {
        this.movies = movies;
    }

    @Override
    public RottenTomatoesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        return new RottenTomatoesViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(final RottenTomatoesViewHolder holder, final int position) {
        holder.bind(movies[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra("MOVIES", movies);
                intent.putExtra("POSITION", position);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return movies.length;
    }
}
