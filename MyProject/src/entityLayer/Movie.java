package entityLayer;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by DMITRIUS on 20.12.2016.
 */
public class Movie implements Entity {

    private long id;
    private String name;
    private Set<CastMember> director;
    private Set<CastMember> actors;
    private LocalDate year;
    private String country;
    private Set<Genre> genre;
    private Set<Review> reviews;

    public Movie(String name, Set<CastMember> director, Set<CastMember> actors, LocalDate year, String country, Set<Genre> genre) {
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.country = country;
        this.genre = genre;
    }

    public Movie(long id, String name, Set<CastMember> director, Set<CastMember> actors, LocalDate year, String country,
                 Set<Genre> genre, Set<Review> reviews) {
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

    public Movie(long id, String name, Set<CastMember> director, Set<CastMember> actors, LocalDate year, String country, Set<Review> reviews) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.country = country;
        this.reviews = reviews;
    }

    public Movie(String name, LocalDate year, String country, Set<Genre> genre) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.genre = genre;
    }

    public Movie(String name, LocalDate year, String country) {
        this.name = name;
        this.year = year;
        this.country = country;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CastMember> getActors() {
        return actors;
    }

    public void setActors(Set<CastMember> actors) {
        this.actors = actors;
    }

    public Set<CastMember> getDirector() {
        return director;
    }

    public void setDirector(Set<CastMember> director) {
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

    public Set<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Set<Genre> genre) {
        this.genre = genre;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        return name != null ? name.equals(movie.name) : movie.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return
                name + '\'' +
                director +
                actors +
                year +
                country + '\'' +
                reviews ;
    }
}
