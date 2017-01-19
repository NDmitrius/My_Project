package entityLayer;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by DMITRIUS on 20.12.2016.
 */
public class Movie implements Entity {

    private long id;
    private String name;
    private List<CastMember> actors;
    private List<CastMember> director;
    private LocalDate year;
    private String country;
    private Genre genre;
    private Review review;

    public Movie(String name, List<CastMember> actors, List<CastMember> director, LocalDate year, String country, Genre genre) {
        this.name = name;
        this.actors = actors;
        this.director = director;
        this.year = year;
        this.country = country;
        this.genre = genre;
    }

    public Movie(long id, String name, List<CastMember> actors, List<CastMember> director, LocalDate year, String country,
                 Genre genre, Review review) {
        this.id = id;
        this.name = name;
        this.actors = actors;
        this.director = director;
        this.year = year;
        this.country = country;
        this.genre = genre;
        this.review = review;
    }

    public Movie(long id, String name, LocalDate year, String country) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CastMember> getActors() {
        return actors;
    }

    public void setActors(List<CastMember> actors) {
        this.actors = actors;
    }

    public List<CastMember> getDirector() {
        return director;
    }

    public void setDirector(List<CastMember> director) {
        this.director = director;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
