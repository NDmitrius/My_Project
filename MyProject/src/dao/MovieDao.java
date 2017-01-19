package dao;

import entityLayer.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by DMITRIUS on 17.01.2017.
 */
public class MovieDao extends GenericDao<Movie> {

    private static final String NAME_TABLE = "movies";


    @Override
    public Movie getById(long id) {
        Movie result = null;
        ResultSet resultSet = getResultById(NAME_TABLE, id);
        try {
            if (resultSet != null && resultSet.next()) {
                result = new Movie(resultSet.getLong("movie_id"), resultSet.getString("name"),
                        (resultSet.getObject("year") != null) ? (resultSet.getObject("year", LocalDate.class)) : null,
                        resultSet.getString("country"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
