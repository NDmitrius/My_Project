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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        return textOfComment != null ? textOfComment.equals(review.textOfComment) : review.textOfComment == null;
    }

    @Override
    public int hashCode() {
        return textOfComment != null ? textOfComment.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", movie=" + movie +
                ", user=" + user +
                ", rating=" + rating +
                ", textOfComment='" + textOfComment + '\'' +
                '}';
    }
}