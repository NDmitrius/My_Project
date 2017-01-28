package dao;

import connection.DBconnection;
import entityLayer.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMITRIUS on 17.01.2017.
 */
public class ReviewDao extends GenericDao<Review> {

    private static final String NAME_TABLE = "reviews";
    private static final String ADD_REVIEW = "INSERT INTO reviews (user_id, movie_id, rank, comment) VALUES (?, ?, ?, ?)";
    private static final String GET_ALL_REVIEWS = "SELECT * FROM reviews";
    private static final String GET_ALL_RANKS = "SELECT m.name, r.rank, r.comment FROM reviews AS r INNER JOIN movies " +
            "AS m ON r.movie_id = m.movie_id";
    private static final String GET_REVIEW_BY_MOVIE = "SELECT m.name, r.rank, r.comment FROM reviews AS r INNER JOIN movies " +
            "AS m ON r.movie_id = m.movie_id WHERE m.name = ?";

    @Override
    public void initDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addReview(int user_id, int movie_id, int rank, String comment) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_REVIEW);
        pStatement.setInt(1, user_id);
        pStatement.setInt(2, movie_id);
        pStatement.setInt(3, rank);
        pStatement.setString(4, comment);
        pStatement.executeUpdate();
        pStatement.close();
        dbConnection.close();
    }

    public Review addReviews(Review review) {
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                PreparedStatement pStatement = dbConnection.prepareStatement(ADD_REVIEW, Statement.RETURN_GENERATED_KEYS);
                pStatement.setLong(1, review.getUser().getId());
                pStatement.setLong(2, review.getMovie().getId());
                pStatement.setInt(3, review.getRating());
                pStatement.setString(4, review.getTextOfComment());
                pStatement.executeUpdate();
                ResultSet result = pStatement.getGeneratedKeys();
                while (result.next()) {
                    review.setId(result.getLong("revie_id"));
                }
                pStatement.close();
                dbConnection.close();
                return review;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Review> getAllReviews() {
        List<Review> reviewList = new ArrayList<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                Statement statement = dbConnection.createStatement();
                ResultSet result = statement.executeQuery(GET_ALL_REVIEWS);
                while (result.next()) {
                    reviewList.add(new Review(result.getLong("review_id"),
                            result.getInt("rank"), result.getString("comment")));
                }
                statement.close();
                result.close();
                dbConnection.close();
                return reviewList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getAllRanks() throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_ALL_RANKS);
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name") +  " - Оценка: " + result.getInt("rank")
                    + "; Комментарий: " + result.getString("comment"));
        }
        statement.close();
        result.close();
        dbConnection.close();
    }

    public void getReviewByMovie(String name) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        PreparedStatement pStatement = dbConnection.prepareStatement(GET_REVIEW_BY_MOVIE);
        pStatement.setString(1, name);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name") +  " - Оценка: " + result.getInt("rank")
                    + "; Комментарий: " + result.getString("comment"));
        }
        pStatement.close();
        result.close();
        dbConnection.close();
    }



    @Override
    public Review getById(long id) {
        Review result = null;
        ResultSet resultSet = getResultById(NAME_TABLE, id);
        try {
            if (resultSet != null && resultSet.next()) {
                result = new Review(resultSet.getLong("review_id"), resultSet.getInt("rank"),
                        resultSet.getString("comment"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
