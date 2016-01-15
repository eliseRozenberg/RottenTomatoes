package com.example.elise.rottentomatoes;


public class NowPlaying_Upcoming {
    private RottenTomatoes upcoming;
    private RottenTomatoes nowPlaying;

    public NowPlaying_Upcoming(RottenTomatoes nowPlaying, RottenTomatoes upcoming) {
        this.nowPlaying = nowPlaying;
        this.upcoming = upcoming;
    }

    public RottenTomatoes getUpcomingMovies() {
        return upcoming;
    }

    public RottenTomatoes getNowPlayingMovies() {
        return nowPlaying;
    }

}
