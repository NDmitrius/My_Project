package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DBconnection;
import entityLayer.Movie;
import entityLayer.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by DMITRIUS on 18.01.2017.
 */
public class MovieJdbcTest {

    //private static final String ADD_USER_QUERY = "";

    private MovieDao movieDao = new MovieDao();
    private UserDao userDao = new UserDao();

    private Connection connection;

    @Before
    public void initDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DBconnection.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void testMovieCount() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM movies");
        resultSet.next();
        Assert.assertEquals(10, resultSet.getInt(1));
    }

    @Test
    public void testGetUserById() throws SQLException {

        User user1 = userDao.getById(1L);
        Assert.assertEquals(1L, user1.getId());
        Assert.assertEquals("Дмитрий", user1.getFirstName());

    }

    @Test
    public void testGetMovieWithYears() throws SQLException {
        Movie movie = movieDao.getById(1L);
        Assert.assertEquals(1L, movie.getId());
    }

    @Test
    public void testMovieByYears() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name, year, country FROM movies WHERE year = '2003'");
        resultSet.next();
        Assert.assertEquals("Властелин колец: Возвращение короля", resultSet.getString("name"));
    }

    @Test
    public void testActorsByMovie() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT c.fname, c.lname, c.date_of_birth, mm.member_type FROM castmembers AS c \n" +
                "INNER JOIN movies_members AS mm ON c.cm_id = mm.cm_id JOIN movies AS m ON mm.movie_id = m.movie_id \n" +
                "WHERE m.name = 'Хоббит: Нежданное путешествие'");
        Assert.assertTrue(resultSet.next());
        Assert.assertEquals("Питер", resultSet.getString("fname"));
        Assert.assertEquals("Джексон", resultSet.getString("lname"));
    }

    @Test
    public void testReviwByMovie() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT r.rank, r.comment FROM reviews AS r INNER JOIN movies " +
                "AS m ON r.movie_id = m.movie_id WHERE m.name = 'Властелин колец: Братство кольца'");
        Assert.assertTrue(resultSet.next());
        Assert.assertEquals(10, resultSet.getInt("rank"));
    }

    @Test
    public void testMovieByCastmember() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT m.name FROM movies AS m INNER JOIN movies_members AS " +
                "mm ON m.movie_id = mm.movie_id JOIN castmembers AS c ON mm.cm_id = c.cm_id WHERE c.fname = 'Джонни' AND c.lname = 'Депп'");
        Assert.assertTrue(resultSet.next());
        Assert.assertEquals("Пираты Карибского моря: Проклятие Черной жемчужины", resultSet.getString("name"));
    }

    @Test
    public void testReviewByUser() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT u.fname, u.lname, r.comment FROM users AS u INNER JOIN " +
                "reviews AS r ON u.user_id = r.user_id WHERE u.fname = 'Дмитрий' AND u.lname = 'Нестерчук'");
        Assert.assertTrue(resultSet.next());
        Assert.assertEquals("Дмитрий", resultSet.getString("fname"));
        Assert.assertEquals("Нестерчук", resultSet.getString("lname"));
    }

    @After
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
