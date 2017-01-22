package entityLayer;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by DMITRIUS on 20.12.2016.
 */
public class Movie implements Entity {

    private long id;
    private String name;
    private List<CastMember> director;
    private List<CastMember> actors;
    private LocalDate year;
    private String country;
    private List<Genre> genre;
    private List<Review> reviews;

    public Movie(String name, List<CastMember> director, List<CastMember> actors, LocalDate year, String country, List<Genre> genre) {
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.country = country;
        this.genre = genre;
    }

    public Movie(long id, String name, List<CastMember> director, List<CastMember> actors, LocalDate year, String country,
                 List<Genre> genre, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.country = country;
        this.genre = genre;
        this.reviews = reviews;
    }

    public Movie(long id, String name, LocalDate year, String country) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.country = country;
    }

    public Movie(long id, String name, List<CastMember> director, List<CastMember> actors, LocalDate year, String country, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.country = country;
        this.reviews = reviews;
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

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
