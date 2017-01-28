package dao;

import connection.DBconnection;
import entityLayer.Movie;
import entityLayer.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by DMITRIUS on 17.01.2017.
 */
public class UserDao extends GenericDao<User> {

    private static final String NAME_TABLE = "users";
    private static final String ADD_USER = "INSERT INTO users (fname, lname, mname, email, password) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ALL_USERS = "SELECT * FROM users";
    private static final String GET_ALL_USERS_WITH_REVIEW = "SELECT u.user_id, u.fname, u.lname, u.mname, u.email, r.comment FROM users AS u " +
            "INNER JOIN reviews AS r ON u.user_id = r.user_id";
    private static final String GET_USER_BY_NAME = "SELECT user_id, fname, lname, mname, email, password FROM users " +
            "WHERE fname = ? AND lname = ?";
    private static final String GET_USER_BY_NAME_WITH_REVIEW = "SELECT u.fname, u.lname, u.mname, r.comment FROM users AS u " +
            "INNER JOIN reviews AS r ON u.user_id = r.user_id WHERE u.fname = ? AND u.lname = ?";

    @Override
    public void initDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String fname, String lname, String mname, String email, String password) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_USER);
        pStatement.setString(1, fname);
        pStatement.setString(2, lname);
        pStatement.setString(3, mname);
        pStatement.setString(4, email);
        pStatement.setString(5, password);
        pStatement.executeUpdate();
        pStatement.close();
        dbConnection.close();
    }

    public User addUsers (User user) {
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                PreparedStatement pStatement = dbConnection.prepareStatement(ADD_USER, Statement.RETURN_GENERATED_KEYS);
                pStatement.setString(1, user.getFirstName());
                pStatement.setString(2, user.getLastName());
                pStatement.setString(3, user.getMiddleName());
                pStatement.setString(4, user.getEmail());
                pStatement.setString(5, user.getPassword());
                pStatement.executeUpdate();
                ResultSet result = pStatement.getGeneratedKeys();
                while (result.next()) {
                    user.setId(result.getLong("user_id"));
                }
                pStatement.close();
                dbConnection.close();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                Statement statement = dbConnection.createStatement();
                ResultSet result = statement.executeQuery(GET_ALL_USERS);
                while (result.next()) {
                    userList.add(new User(result.getLong("user_id"), result.getString("fname"),
                            result.getString("lname"), result.getString("mname"),
                            result.getString("email"), result.getString("password")));
                }
                statement.close();
                result.close();
                dbConnection.close();
                return userList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<User> getAllUsersHaveReview() {
        Set<User> userList = new HashSet<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                Statement statement = dbConnection.createStatement();
                ResultSet result = statement.executeQuery(GET_ALL_USERS_WITH_REVIEW);
                while (result.next()) {
                    if(result.getString("comment") != null) {
                        userList.add(new User(result.getLong("user_id"), result.getString("fname"),
                                result.getString("lname"), result.getString("mname"),
                                result.getString("email")));
                    }
                }
                statement.close();
                result.close();
                dbConnection.close();
                return userList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByName(String fname, String lname) {
        User user = null;
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                PreparedStatement pStatement = dbConnection.prepareStatement(GET_USER_BY_NAME);
                pStatement.setString(1, fname);
                pStatement.setString(2, lname);
                ResultSet result = pStatement.executeQuery();
                while (result.next()) {
                    user = new User(result.getLong("user_id"), result.getString("fname"),
                            result.getString("lname"), result.getString("mname"),
                            result.getString("email"), result.getString("password"));
                }
                pStatement.close();
                result.close();
                dbConnection.close();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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
