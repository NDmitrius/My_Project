package dao;

import connection.DBconnection;
import entityLayer.CastMember;
import entityLayer.Genre;
import entityLayer.Movie;
import entityLayer.Review;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private static final String GET_MOVIE_BY_YEAR = "SELECT * FROM movies WHERE year = ?";
    private static final String GET_MOVIE_BY_CASTMEMBER = "SELECT * FROM movies AS m INNER JOIN movies_members AS " +
            "mm ON m.movie_id = mm.movie_id JOIN castmembers AS c ON mm.cm_id = c.cm_id WHERE c.fname = ? AND c.lname = ?";
    private static final String GET_MOVIES_BY_GENRE = "SELECT m.name, m.year, m.country, g.genre FROM movies AS m " +
            "INNER JOIN movies_genre AS mg ON m.movie_id = mg.movie_id JOIN genre AS g ON mg.genre_id = g.genre_id WHERE g.genre = ?";
    private static final String GET_NUMBER_MOVIES = "SELECT COUNT(*) FROM movies";
    private static final String GET_MOVIES_WITH_CASTMEMBERS = "SELECT m.movie_id, m.name, m.year, m.country, g.genre, " +
            "r.rank, r.comment FROM movies AS m INNER JOIN movies_genre AS mg \n" +
            "ON m.movie_id = mg.movie_id JOIN genre AS g ON mg.genre_id = g.genre_id LEFT JOIN reviews AS r ON " +
            "r.movie_id = m.movie_id GROUP BY m.name ORDER BY m.movie_id";
    private static final String GET_CASTMEMBERS_BY_MOVIE = "SELECT c.fname, c.lname, c.mname, c.date_of_birth FROM castmembers AS c \n" +
            "INNER JOIN movies_members AS mm ON c.cm_id = mm.cm_id JOIN movies AS m ON mm.movie_id = m.movie_id \n" +
            "WHERE m.name = ? AND mm.member_type = ?";



    @Override
    public void initDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        Connection dbConnection = DBconnection.getConnection();
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_IN_MOVIES);
        pStatement.setString(1, name);
        pStatement.setInt(2, year);
        pStatement.setString(3, country);
        pStatement.executeUpdate();
        pStatement.close();
        dbConnection.close();
    }

    public Movie addMovie(Movie movie) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_IN_MOVIES, Statement.RETURN_GENERATED_KEYS);
        pStatement.setString(1, movie.getName());
        pStatement.setObject(2, movie.getYear());
        pStatement.setString(3, movie.getCountry());
        pStatement.executeUpdate();
        ResultSet result = pStatement.getGeneratedKeys();
        while (result.next()) {
            movie.setId(result.getLong("movie_id"));
        }
        pStatement.close();
        dbConnection.close();
        return movie;
    }

    public void addInTableMoviesGenre(int movie_id, int genre_id) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_IN_MOVIES_GENRE, Statement.RETURN_GENERATED_KEYS);
        pStatement.setInt(1, movie_id);
        pStatement.setInt(2, genre_id);
        pStatement.executeUpdate();
        pStatement.getGeneratedKeys();
        pStatement.close();
        dbConnection.close();
    }

    public List<Movie> getListMovies() throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        List<Movie> listMovie = new ArrayList<>();
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_ALL_MOVIES);
        while (result.next()) {
            listMovie.add(new Movie(result.getLong("movie_id"), result.getString("name"),
                    (result.getObject("year") != null) ? (result.getObject("year", LocalDate.class))
                            : null, result.getString("country")));
        }
        statement.close();
        result.close();
        dbConnection.close();
        return listMovie;
    }

    public List<Movie> getMoviesWithCastMember() throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        List<Movie> listMovie = new ArrayList<>();
        List<CastMember> listDirectors = null;
        List<CastMember> listActors = null;
        //List<Genre> listGenre = null;
        List<Review> listReviews = null;
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_MOVIES_WITH_CASTMEMBERS);
        PreparedStatement pStatementDirector = dbConnection.prepareStatement(GET_CASTMEMBERS_BY_MOVIE);
        PreparedStatement pStatementActor = dbConnection.prepareStatement(GET_CASTMEMBERS_BY_MOVIE);

        while (result.next()) {
            pStatementDirector.setString(1, result.getString("name"));
            pStatementDirector.setString(2, "режиссер");
            ResultSet resultDirector = pStatementDirector.executeQuery();
            pStatementActor.setString(1, result.getString("name"));
            pStatementActor.setString(2, "актер");
            ResultSet resultActors = pStatementActor.executeQuery();
            //listGenre = new ArrayList<>();
            listReviews = new ArrayList<>();
            listReviews.add(new Review(result.getInt("rank"), result.getString("comment")));

            listDirectors = new ArrayList<>();
            while (resultDirector.next()) {
                listDirectors.add(new CastMember(resultDirector.getString("fname"),
                        resultDirector.getString("lname"), resultDirector.getString("mname"),
                        resultDirector.getObject("date_of_birth", LocalDate.class)));
            }

            listActors = new ArrayList<>();
            while (resultActors.next()) {
                listActors.add(new CastMember(resultActors.getString("fname"),
                        resultActors.getString("lname"), resultActors.getString("mname"),
                        resultActors.getObject("date_of_birth", LocalDate.class)));
            }

            listMovie.add(new Movie(result.getLong("movie_id"), result.getString("name"),
                    listDirectors, listActors, result.getObject("year") != null ? result.getObject("year", LocalDate.class)
                    : null, result.getString("country"), listReviews));
        }
        statement.close();
        pStatementDirector.close();
        pStatementActor.close();
        result.close();
        dbConnection.close();
        return listMovie;
    }

//    public List<Movie> getMoviesWithGenre() throws SQLException {
//        Connection dbConnection = DBconnection.getConnection();
//        List<Movie> listMovieWithGenre = new ArrayList<>();
//        Statement statement = dbConnection.createStatement();
//        ResultSet result = statement.executeQuery(GET_ALL_MOVIES_GENRE);
//        while (result.next()) {
//            listMovieWithGenre.add(new Movie(result.getString("name"), (result.getObject("year") != null) ? (result.getObject("year", LocalDate.class))
//                    : null, result.getString("country")));
//        }
//    }

    public void geAllMoviesWithGenre() throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_ALL_MOVIES_GENRE);
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name") + "; Год: " + result.getDate("year")
                    + "; Страна: " + result.getString("country") + "; Жанр: " + result.getString("genre"));
        }
        statement.close();
        result.close();
        dbConnection.close();
    }

    public List<Movie> getMovieByYear(int year) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        List<Movie> listMovie = new ArrayList<>();
        PreparedStatement pStatement = dbConnection.prepareStatement(GET_MOVIE_BY_YEAR);
        pStatement.setInt(1, year);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            listMovie.add(new Movie(result.getLong("movie_id"), result.getString("name"),
                    (result.getObject("year") != null) ? (result.getObject("year", LocalDate.class))
                            : null, result.getString("country")));
        }
        pStatement.close();
        result.close();
        dbConnection.close();
        return listMovie;
    }

    public List<Movie> getMoviesByCastMember(String fname, String lname) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        List<Movie> listMovieByCastMember = new ArrayList<>();
        PreparedStatement pStatement = dbConnection.prepareStatement(GET_MOVIE_BY_CASTMEMBER);
        pStatement.setString(1, fname);
        pStatement.setString(2, lname);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            listMovieByCastMember.add(new Movie(result.getLong("movie_id"), result.getString("name"),
                    (result.getObject("year") != null) ? (result.getObject("year", LocalDate.class))
                            : null, result.getString("country")));
        }
        pStatement.close();
        result.close();
        dbConnection.close();
        return listMovieByCastMember;
    }

    public void getMovieByGenre(String genre) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        PreparedStatement pStatement = dbConnection.prepareStatement(GET_MOVIES_BY_GENRE);
        pStatement.setString(1, genre);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            System.out.println("Фильм: " + result.getString("name"));
        }
        pStatement.close();
        result.close();
        dbConnection.close();
    }

    public int getNumberMovies() throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(GET_NUMBER_MOVIES);
        int number = 0;
        while (result.next()) {
            number = result.getInt(1);
        }
        statement.close();
        result.close();
        dbConnection.close();
        return number;
    }
}
