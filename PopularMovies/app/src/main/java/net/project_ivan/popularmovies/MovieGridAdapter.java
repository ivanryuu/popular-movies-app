package net.project_ivan.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 1000));
            imageView.setPadding(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(context).load(getPosterUri(movie.posterPath)).into(imageView);

        return imageView;
    }

    private String getPosterUri(String posterPath) {
        String base = "http://image.tmdb.org/t/p/w185/";
        return base + posterPath;
    }
}
