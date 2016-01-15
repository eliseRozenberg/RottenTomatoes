package com.example.elise.rottentomatoes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView.ItemDecoration;

import com.squareup.picasso.Picasso;


public class RottenTomatoesViewHolder extends RecyclerView.ViewHolder {

    private TextView title, cast, criticsRating, audienceRating, mpaa_rating, runtime;
    private ImageView poster, criticsImage, audienceImage;
    private Context context;

    public RottenTomatoesViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;

        poster = (ImageView) itemView.findViewById(R.id.poster);
        title = (TextView) itemView.findViewById(R.id.title);
        criticsImage = (ImageView) itemView.findViewById(R.id.criticsImage);
        criticsRating = (TextView) itemView.findViewById(R.id.criticsRating);
        audienceImage = (ImageView) itemView.findViewById(R.id.audienceImage);
        audienceRating = (TextView) itemView.findViewById(R.id.audienceRating);
        cast = (TextView) itemView.findViewById(R.id.cast);
        mpaa_rating = (TextView) itemView.findViewById(R.id.mpaa_rating);
        runtime = (TextView) itemView.findViewById(R.id.runtime);


    }

    public void bind(Movie movies) {
        Picasso.with(context).load(movies.getPosters().getProfile()).into(poster);
        title.setText(movies.getTitle());

        String rating = movies.getRatings().getCritics_rating();
        if (rating != null) {
            if (movies.getRatings().getCritics_score() > 0) {
                criticsRating.setText(String.valueOf(movies.getRatings().getCritics_score()) + "%     ");
            }
            if (rating.equalsIgnoreCase("fresh")) {
                criticsImage.setImageResource(R.drawable.tomatoe);
            } else if (rating.equalsIgnoreCase("certified fresh")) {
                criticsImage.setImageResource(R.drawable.certified_fresh);
            } else if (rating.equalsIgnoreCase("rotten")) {
                criticsImage.setImageResource(R.drawable.rotten);
            }
        }

        rating = movies.getRatings().getAudience_rating();
        if (rating != null) {
            audienceRating.setText(String.valueOf(movies.getRatings().getAudience_score() + "%"));
            if (movies.getRatings().getAudience_score() > 0) {
                audienceRating.setText(movies.getRatings().getAudience_score() + "%");
            }
            if (rating.equalsIgnoreCase("upright")) {
                audienceImage.setImageResource(R.drawable.popcorn);
            } else {
                audienceImage.setImageResource(R.drawable.popcornbad);
            }

        }

        cast.setText(movies.getAbridged_cast()[0].getName() + "   " + movies.getAbridged_cast()[1].getName());
        mpaa_rating.setText(movies.getMpaa_rating() + "  ,  ");
        runtime.setText(movies.getRuntime() + " min.  ");


    }
}


