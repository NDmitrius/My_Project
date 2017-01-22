package entityLayer;

/**
 * Created by DMITRIUS on 20.12.2016.
 */
public class Review implements Entity {

    private long id;
    private Movie movie;
    private User user;
    private int rating;
    private String textOfComment;

    public Review(Movie movie, User user, int rating, String textOfComment) {
        this.movie = movie;
        this.user = user;
        this.rating = rating;
        this.textOfComment = textOfComment;
    }

    public Review(long id, Movie movie, User user, int rating, String textOfComment) {
        this.id = id;
        this.movie = movie;
        this.user = user;
        this.rating = rating;
        this.textOfComment = textOfComment;
    }

    public Review(long id, int rating, String textOfComment) {
        this.id = id;
        this.rating = rating;
        this.textOfComment = textOfComment;
    }

    public Review(int rating, String textOfComment) {
        this.rating = rating;
        this.textOfComment = textOfComment;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTextOfComment() {
        return textOfComment;
    }

    public void setTextOfComment(String textOfComment) {
        this.textOfComment = textOfComment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}