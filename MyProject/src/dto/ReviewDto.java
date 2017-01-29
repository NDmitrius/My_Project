package dto;

/**
 * Created by DMITRIUS on 26.01.2017.
 */
public class ReviewDto {

    private int rating;
    private String textOfComment;

    public ReviewDto() {
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTextOfComment() {
        return textOfComment;
    }

    public void setTextOfComment(String textOfComment) {
        this.textOfComment = textOfComment;
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
                "rating=" + rating +
                ", textOfComment='" + textOfComment + '\'' +
                '}';
    }
}
