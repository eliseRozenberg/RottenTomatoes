package com.example.elise.rottentomatoes;

import java.io.Serializable;


public class Movie implements Serializable {

    private String title;
    private String mpaa_rating;
    private String runtime;
    private String synopsis;
    private Posters posters;
    private ReleaseDates release_dates;
    private Ratings ratings;
    private AbridgedCast[] abridged_cast;


    public String getTitle() {
        return title;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public ReleaseDates getRelease_dates() {
        return release_dates;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public String getSysnopsis() {
        return synopsis;
    }

    public Posters getPosters() {
        return posters;
    }

    public AbridgedCast[] getAbridged_cast() {
        return abridged_cast;
    }

    public String printAbridged() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cast:\n");
        for (AbridgedCast cast : abridged_cast) {
            builder.append(cast.toString() + "\n");
        }
        return builder.toString();
    }


}
