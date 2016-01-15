package com.example.elise.rottentomatoes;

import java.io.Serializable;

/**
 * Created by Elise on 1/13/2016.
 */
public class Ratings implements Serializable {
    private String critics_rating;
    private int critics_score;
    private String audience_rating;
    private int audience_score;


    public int getCritics_score() {
        return critics_score;
    }

    public int getAudience_score() {
        return audience_score;
    }

    public String getCritics_rating() {
        return critics_rating;
    }

    public String getAudience_rating() {
        return audience_rating;
    }
}
