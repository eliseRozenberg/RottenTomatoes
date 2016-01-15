package com.example.elise.rottentomatoes;

import java.io.Serializable;

/**
 * Created by Elise on 1/13/2016.
 */
public class AbridgedCast implements Serializable {

    private String name;
    private String[] characters;

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(" -> ");
        if (characters != null) {
            for (int i = 0; i < characters.length; i++) {
                builder.append(" " + characters[i]);
            }
        }
        return builder.toString();
    }
}
