package com.example.elise.rottentomatoes;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;


public class MovieDetailAdapter extends PagerAdapter implements Serializable {

    private Movie[] movies;
    private TextView title, cast, criticsRating, audienceRating,
            mpaa_rating, synopsis, runtime, releaseDate;
    private ImageView poster, largeImage, criticsImage, audienceImage;
    private Context context;
    private int position;

    public MovieDetailAdapter(Movie[] movies, int position, Context context) {
        this.movies = movies;
        this.context = context;
        this.position = position;
    }

    @Override
    public int getCount() {
        return movies.length;
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
        View itemView = inflater.inflate(R.layout.movie_detail, null);

        largeImage = (ImageView) itemView.findViewById(R.id.largeImage);
        poster = (ImageView) itemView.findViewById(R.id.poster);
        title = (TextView) itemView.findViewById(R.id.title);
        criticsRating = (TextView) itemView.findViewById(R.id.critics);
        criticsImage = (ImageView) itemView.findViewById(R.id.criticsImage);
        audienceRating = (TextView) itemView.findViewById(R.id.audience);
        audienceImage = (ImageView) itemView.findViewById(R.id.audienceImage);
        synopsis = (TextView) itemView.findViewById(R.id.synopsis);
        mpaa_rating = (TextView) itemView.findViewById(R.id.mpaa_rating);
        runtime = (TextView) itemView.findViewById(R.id.runtime);
        releaseDate = (TextView) itemView.findViewById(R.id.releaseDate);
        cast = (TextView) itemView.findViewById(R.id.cast);


        Movie movie = movies[position];
        Picasso.with(context).load(movie.getPosters().getOriginal())
                .into(largeImage);
        Picasso.with(context).load(movie.getPosters().getProfile()).into(poster);
        title.setText(movie.getTitle());

        String rating = movie.getRatings().getCritics_rating();
        if (movie.getRatings().getCritics_score() > 0) {
            criticsRating.setText("Rotten Tomatoes Critics Score:    " + movie.getRatings().getCritics_score() + "%");

            if (rating.equalsIgnoreCase("fresh")) {
                criticsImage.setImageResource(R.drawable.tomatoe);
            } else if (rating.equalsIgnoreCase("certified fresh")) {
                criticsImage.setImageResource(R.drawable.certified_fresh);
            } else if (rating.equalsIgnoreCase("rotten")) {
                criticsImage.setImageResource(R.drawable.rotten);
            }
        }


        rating = movie.getRatings().getAudience_rating();

        if (movie.getRatings().getAudience_score() > 0) {
            if (rating == null) {
                audienceRating.setText("Flixter Want To See:    " + movie.getRatings().getAudience_score() + "%");

                audienceImage.setImageResource(R.drawable.plus);
            } else if (rating.equalsIgnoreCase("upright")) {
                audienceRating.setText("Flixter User Score:    " + movie.getRatings().getAudience_score() + "%");
                audienceImage.setImageResource(R.drawable.popcorn);
            } else {
                audienceRating.setText("Flixter User Score:    " + movie.getRatings().getAudience_score() + "%");
                audienceImage.setImageResource(R.drawable.popcornbad);
            }
        }

        synopsis.setText("Synopsis:\n" + movie.getSysnopsis() + "...");
        mpaa_rating.setText("Rated: " + movie.getMpaa_rating());
        runtime.setText("Running Time: " + movie.getRuntime() + " min.");
        releaseDate.setText("Theater Release Date: " + movie.getRelease_dates().getTheater());
        cast.setText(movie.printAbridged());
        container.addView(itemView);
        return itemView;

    }


}



