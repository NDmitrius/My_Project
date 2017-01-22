package dao;

import connection.DBconnection;
import entityLayer.Movie;

import java.sql.*;
import java.time.LocalDate;

/**
 * Created by DMITRIUS on 17.01.2017.
 */
public class MovieDao extends GenericDao<Movie> {

    private static final String NAME_TABLE = "movies";
    private static final String ADD_IN_MOVIES = "INSERT INTO movies (name, year, country) VALUES (?, ?, ?)";
    private static final String ADD_IN_MOVIES_GENRE = "INSERT INTO movies_genre (movie_id, genre_id) VALUES (?, ?)";
    private static final String GET_ALL_MOVIES = "SELECT * FROM movies";
    private static final String GET_ALL_MOVIES_GENRE = "SELECT m.name, m.year, m.country, g.genre FROM movies AS m " +
            "INNER JOIN movies_genre AS mg ON m.movie_id = mg.movie_id JOIN genre AS g ON mg.genre_id = g.genre_id GROUP BY m.name";
    private static final String GET_MOVIE_BY_YEAR = "SELECT name, country FROM movies WHERE year = ?";
    private static final String GET_MOVIE_BY_CASTMEMBER = "SELECT m.name, m.year, m.country FROM movies AS m INNER JOIN movies_members AS " +
            "mm ON m.movie_id = mm.movie_id JOIN castmembers AS c ON mm.cm_id = c.cm_id WHERE c.fname = ? AND c.lname = ?";
    private static final String GET_MOVIES_BY_GENRE = "SELECT m.name, m.year, m.country, g.genre FROM movies AS m " +
            "INNER JOIN movies_genre AS mg ON m.movie_id = mg.movie_id JOIN genre AS g ON mg.genre_id = g.genre_id WHERE g.genre = ?";
    private static final String GET_NUMBER_MOVIES = "SELECT COUNT(*) FROM movies";

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

    public void addInTableMovies(String name, int year, String country) throws SQLException {
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_IN_MOVIES);
        pStatement.setString(1, name);
        pStatement.setInt(2, year);
        pStatement.setString(3, country);
        pStatement.executeUpdate();
        pStatement.close();
    }

    public void addInTableMoviesGenre(int movie_id, int genre_id) throws SQLException {
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_IN_MOVIES_GENRE);
        pStatement.setInt(1, movie_id);
        pStatement.setInt(2, genre_id);
        pStatement.executeUpdate();
        pStatement.close();
    }

    public void getAllMovies() throws SQLException {
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_ALL_MOVIES);
        while (result.next()) {
            System.out.println(result.getLong("movie_id") + ". " + "Фильм: " + result.getString("name")
                    + "; Год: " + result.getDate("year") + "; Страна: " + result.getString("country"));
        }
        statement.close();
        result.close();
    }

    public void geAllMoviesWithGenre() throws SQLException {
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_ALL_MOVIES_GENRE);
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name") + "; Год: " + result.getDate("year")
                    + "; Страна: " + result.getString("country") + "; Жанр: " + result.getString("genre"));
        }
        statement.close();
        result.close();
    }

    public void getMovieByYear(int year) throws SQLException {
        PreparedStatement pStatement = dbConnection.prepareStatement(GET_MOVIE_BY_YEAR);
        pStatement.setInt(1, year);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name")
                    + "; Страна: " + result.getString("country"));
        }
        pStatement.close();
        result.close();
    }

    public void getMovieByCastmember(String fname, String lname) throws SQLException {
        PreparedStatement pStatement = dbConnection.prepareStatement(GET_MOVIE_BY_CASTMEMBER);
        pStatement.setString(1, fname);
        pStatement.setString(2, lname);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name"));
        }
        pStatement.close();
        result.close();
    }

    public void getMovieByGenre(String genre) throws SQLException {
        PreparedStatement pStatement = dbConnection.prepareStatement(GET_MOVIES_BY_GENRE);
        pStatement.setString(1, genre);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name"));
        }
        pStatement.close();
        result.close();
    }

    public void getNumberMovies() throws SQLException {
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_NUMBER_MOVIES);
        while (result.next()) {
            int number = result.getInt(1);
            System.out.println("Total number of movies in the table: " + number);
        }
        statement.close();
        result.close();
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
