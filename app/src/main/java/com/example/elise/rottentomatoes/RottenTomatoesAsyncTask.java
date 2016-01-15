package com.example.elise.rottentomatoes;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RottenTomatoesAsyncTask extends AsyncTask<Long, Void, NowPlaying_Upcoming> implements Serializable{
    private RottenTomatoes upcoming;
    private RottenTomatoes nowPlaying;
    private NowPlaying_Upcoming np_u_movies;
    private Context context;
    private ViewPager pager;

    public RottenTomatoesAsyncTask(ViewPager pager, Context context) {
        this.pager = pager;
        this.context = context;
    }

    @Override
    protected NowPlaying_Upcoming doInBackground(Long... params) {
        URL url = null;
        try {
            url = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=cart6246nbex6fqchrj5t4b8&limit=20");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            Gson gson = new Gson();
            nowPlaying = gson.fromJson(reader, RottenTomatoes.class);
            reader.close();

            url = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/upcoming.json?apikey=cart6246nbex6fqchrj5t4b8&limit=20");
            connection = (HttpURLConnection) url.openConnection();
            in = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            gson = new Gson();
            upcoming = gson.fromJson(reader, RottenTomatoes.class);
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        np_u_movies = new NowPlaying_Upcoming(nowPlaying, upcoming);
        return np_u_movies;
    }


    protected void onPostExecute(NowPlaying_Upcoming movies) {
        super.onPostExecute(movies);
        RottenTomatoesAdapter adapter = new RottenTomatoesAdapter(
                movies.getNowPlayingMovies().getMovies(),
                movies.getUpcomingMovies().getMovies(),
                context);
        pager.setAdapter(adapter);
    }
}
