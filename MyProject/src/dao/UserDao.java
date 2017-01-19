package dao;

import entityLayer.Movie;
import entityLayer.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by DMITRIUS on 17.01.2017.
 */
public class UserDao extends GenericDao<User> {

    private static final String NAME_TABLE = "users";

    @Override
    public User getById(long id) {
        User result = null;
        ResultSet resultSet = getResultById(NAME_TABLE, id);
        try {
            if (resultSet != null && resultSet.next()) {
                result = new User(resultSet.getLong("user_id"), resultSet.getString("fname"),
                    resultSet.getString("lname"), resultSet.getString("mname"),
                    resultSet.getString("email"), resultSet.getNString("password"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
