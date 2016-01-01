package net.project_ivan.popularmovies;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailsActivityFragment extends Fragment {

    public MovieDetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent data = getActivity().getIntent();
        Movie movie = data.getParcelableExtra("movie");
        View rootView = inflater.inflate(R.layout.fragment_movie_details, container, false);

        TextView title = (TextView) rootView.findViewById(R.id.title);
        TextView releaseDate = (TextView) rootView.findViewById(R.id.release_date);
        TextView popularity = (TextView) rootView.findViewById(R.id.popularity);
        TextView overview = (TextView) rootView.findViewById(R.id.overview);
        ImageView poster = (ImageView) rootView.findViewById(R.id.poster);

        title.setText(movie.originalTitle);
        releaseDate.setText(movie.releaseDate.toString());
        popularity.setText(""+movie.popularity);
        overview.setText(movie.overview);
        Picasso.with(getContext()).load(getPosterUri(movie.posterPath)).into(poster);

        return rootView;
    }

    private String getPosterUri(String posterPath) {
        String base = "http://image.tmdb.org/t/p/w185/";
        return base + posterPath;
    }
}
