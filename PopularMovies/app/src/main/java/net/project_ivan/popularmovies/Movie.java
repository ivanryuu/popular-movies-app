package net.project_ivan.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ivanr_000 on 1/1/2016.
 */
public class Movie implements Parcelable {

    public String posterPath;
    public String overview;
    public String originalTitle;
    public double popularity;
    public int voteCount;
    public double voteAverage;
    public String releaseDate;

    public Movie() {}

    public Movie(String posterPath, String overview, String originalTitle, double popularity,
                 int voteCount, double voteAverage, String releaseDate) {
        this.posterPath = posterPath;
        this.overview = overview;
        this.originalTitle = originalTitle;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.releaseDate = parseDate(releaseDate);
    }

    private String parseDate(String date) {
        return date.substring(0,4);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(posterPath);
        parcel.writeString(overview);
        parcel.writeString(originalTitle);
        parcel.writeDouble(popularity);
        parcel.writeInt(voteCount);
        parcel.writeDouble(voteAverage);
        parcel.writeString(releaseDate.toString());
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
        overview = in.readString();
        originalTitle = in.readString();
        popularity = in.readDouble();
        voteCount = in.readInt();
        voteAverage = in.readDouble();
        releaseDate = in.readString();
    }
}
