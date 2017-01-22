package dao;

import connection.DBconnection;
import entityLayer.Review;

import java.sql.*;

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

    private Connection dbConnection;

    @Override
    public void initDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbConnection = DBconnection.getConnection();
    }

    public void addReview(int user_id, int movie_id, int rank, String comment) throws SQLException {
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_REVIEW);
        pStatement.setInt(1, user_id);
        pStatement.setInt(2, movie_id);
        pStatement.setInt(3, rank);
        pStatement.setString(4, comment);
        pStatement.executeUpdate();
        pStatement.close();
    }

    public void getAllReviews() throws SQLException {
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_ALL_REVIEWS);
        while (result.next()) {
            System.out.println(result.getLong("review_id") + ". id фильма: " + result.getInt("movie_id")
                    + ", id Пользователя: " + result.getInt("user_id") + ", Оценка: " + result.getInt("rank")
                    + ", Комментарий: " + result.getString("comment"));
        }
        statement.close();
        result.close();
    }

    public void getAllRanks() throws SQLException {
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_ALL_RANKS);
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name") +  " - Оценка: " + result.getInt("rank")
                    + "; Комментарий: " + result.getString("comment"));
        }
        statement.close();
        result.close();
    }

    public void getReviewByMovie(String name) throws SQLException {
        PreparedStatement pStatement = dbConnection.prepareStatement(GET_REVIEW_BY_MOVIE);
        pStatement.setString(1, name);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name") +  " - Оценка: " + result.getInt("rank")
                    + "; Комментарий: " + result.getString("comment"));
        }
        pStatement.close();
        result.close();
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

    @Override
    public void closeConnection() {
        try {
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
