package dao;

import entityLayer.Review;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DMITRIUS on 17.01.2017.
 */
public class ReviewDao extends GenericDao<Review> {

    private static final String NAME_TABLE = "reviews";

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
