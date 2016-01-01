package net.project_ivan.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by ivanr_000 on 1/1/2016.
 */
public class Movie implements Parcelable {

    public String posterPath;
    public String overview;
    public String originalTitle;
    public int popularity;
    public int voteCount;
    public Date releaseDate;

    public Movie() {}

    public Movie(String posterPath, String overview, String originalTitle, int popularity,
                 int voteCount, String releaseDate) {
        this.posterPath = posterPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(posterPath);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    private Movie(Parcel in) {
        posterPath = in.readString();
    }
}
