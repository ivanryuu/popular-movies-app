package net.project_ivan.popularmovies;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ivanr_000 on 1/1/2016.
 */
public class MovieGridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movieList;

    public MovieGridAdapter(Context context, ArrayList<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public int getCount() {
        return movieList.size();
    }

    public Movie getItem(int position) {
        return movieList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public void clear() {
        movieList.clear();
    }

    public void add(Movie movie) {
        movieList.add(movie);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Movie movie = getItem(position);
        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            grid = inflater.inflate(R.layout.grid_single, null);

        } else {
            grid = convertView;
        }

        ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
        RatingBar ratingBar = (RatingBar) grid.findViewById(R.id.grid_rating_bar);
        TextView textView = (TextView) grid.findViewById(R.id.grid_vote_count);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(GridView.AUTO_FIT, 1000));
        imageView.setPadding(2, 2, 2, 2);
        Picasso.with(context).load(getPosterUri(movie.posterPath)).into(imageView);
        ratingBar.setRating(normalizeRating(movie.voteAverage));

        textView.setText(getVoteCount(movie.voteCount));

        return grid;
    }

    private String getVoteCount(int count) {
        return "(" + count + ")";
    }
    private float normalizeRating(double voteAverage) {
        return (float)(voteAverage / 2.0);
    }

    private String getPosterUri(String posterPath) {
        String base = "http://image.tmdb.org/t/p/w185/";
        return base + posterPath;
    }
}
