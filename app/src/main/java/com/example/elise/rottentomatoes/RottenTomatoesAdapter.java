package com.example.elise.rottentomatoes;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

/**
 * Created by Elise on 1/14/2016.
 */
public class
        RottenTomatoesAdapter extends PagerAdapter {

    private Movie[] nowPlaying;
    private Movie[] upcoming;
    private int position;
    private Context context;

    public RottenTomatoesAdapter(Movie[] nowPlaying, Movie[] upcoming, Context context) {
        this.nowPlaying = nowPlaying;
        this.upcoming = upcoming;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.movie_list, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(context).build());

        if (position == 0) {
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(nowPlaying);
            recyclerView.setAdapter(adapter);
        }
        if (position == 1) {
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(upcoming);
            recyclerView.setAdapter(adapter);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation((LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);


        container.addView(view);
        return view;
    }


}