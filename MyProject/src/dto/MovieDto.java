package dto;

import entityLayer.CastMember;
import entityLayer.Genre;
import entityLayer.Review;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by DMITRIUS on 26.01.2017.
 */
public class MovieDto {

    private String name;
    private Set<CastMember> director;
    private Set<CastMember> actors;
    private LocalDate year;
    private String country;
    private Set<Genre> genre;
    private Set<Review> reviews;

    public MovieDto() {
    }

    public MovieDto(String name, Set<CastMember> director, Set<CastMember> actors, LocalDate year, String country,
                    Set<Genre> genre, Set<Review> reviews) {
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.country = country;
        this.genre = genre;
        this.reviews = reviews;
    }

    public MovieDto(String name, Set<CastMember> director, Set<CastMember> actors, LocalDate year, String country,
                    Set<Review> reviews) {
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.country = country;
        this.reviews = reviews;
    }

    public MovieDto(String name, LocalDate year, String country) {

    }

    public MovieDto(String name, Set<CastMember> director, Set<CastMember> actors, LocalDate year, String country) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CastMember> getDirector() {
        return director;
    }

    public void setDirector(Set<CastMember> director) {
        this.director = director;
    }

    public Set<CastMember> getActors() {
        return actors;
    }

    public void setActors(Set<CastMember> actors) {
        this.actors = actors;
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

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", actors=" + actors +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", genre=" + genre +
                ", reviews=" + reviews +
                '}';
    }
}
