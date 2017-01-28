package dao;

import connection.DBconnection;
import entityLayer.CastMember;
import entityLayer.Genre;
import entityLayer.Movie;
import entityLayer.Review;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private static final String GET_MOVIES_BY_YEAR = "SELECT m.movie_id, m.name, m.year, m.country, g.genre, c.cm_id, " +
            "c.fname, c.lname, c.mname, c.date_of_birth, mm.member_type, u.fname, u.lname, r.review_id, r.rank, r.comment FROM movies AS m " +
            "INNER JOIN movies_genre AS mg ON m.movie_id = mg.movie_id " +
            "JOIN genre AS g ON mg.genre_id = g.genre_id " +
            "JOIN movies_members AS mm ON m.movie_id = mm.movie_id " +
            "JOIN castmembers AS c ON mm.cm_id = c.cm_id " +
            "LEFT JOIN reviews AS r ON r.movie_id = m.movie_id LEFT JOIN users AS u ON u.user_id = r.user_id WHERE m.year = ?";
    private static final String GET_MOVIE_BY_CASTMEMBER = "SELECT * FROM movies AS m INNER JOIN movies_members AS " +
            "mm ON m.movie_id = mm.movie_id JOIN castmembers AS c ON mm.cm_id = c.cm_id WHERE c.fname = ? AND c.lname = ?";
    private static final String GET_MOVIES_BY_GENRE = "SELECT m.movie_id, m.name, m.year, m.country, g.genre FROM movies AS m " +
            "INNER JOIN movies_genre AS mg ON m.movie_id = mg.movie_id JOIN genre AS g ON mg.genre_id = g.genre_id WHERE g.genre = ?";
    private static final String GET_NUMBER_MOVIES = "SELECT COUNT(*) FROM movies";
    private static final String GET_ALL_MOVIES_WITH_CASTMEMBERS = "SELECT m.movie_id, m.name, m.year, m.country, g.genre, c.cm_id, " +
            "c.fname, c.lname, c.mname, c.date_of_birth, mm.member_type, u.fname, u.lname, r.review_id, r.rank, r.comment FROM movies AS m " +
            "INNER JOIN movies_genre AS mg ON m.movie_id = mg.movie_id " +
            "JOIN genre AS g ON mg.genre_id = g.genre_id " +
            "JOIN movies_members AS mm ON m.movie_id = mm.movie_id \n" +
            "JOIN castmembers AS c ON mm.cm_id = c.cm_id " +
            "LEFT JOIN reviews AS r ON r.movie_id = m.movie_id LEFT JOIN users AS u ON u.user_id = r.user_id " +
            "ORDER BY m.movie_id";
    private static final String GET_MOVIE_FROM_ALL_BY_NAME = "SELECT m.movie_id, m.name, m.year, m.country, g.genre, c.cm_id, " +
            "c.fname, c.lname, c.mname, c.date_of_birth, mm.member_type, u.fname, u.lname, r.review_id, r.rank, r.comment FROM movies AS m " +
            "INNER JOIN movies_genre AS mg ON m.movie_id = mg.movie_id " +
            "JOIN genre AS g ON mg.genre_id = g.genre_id " +
            "JOIN movies_members AS mm ON m.movie_id = mm.movie_id \n" +
            "JOIN castmembers AS c ON mm.cm_id = c.cm_id " +
            "LEFT JOIN reviews AS r ON r.movie_id = m.movie_id LEFT JOIN users AS u ON u.user_id = r.user_id WHERE m.name = ?" +
            " ";



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

    public Movie addMovie(Movie movie) {
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addInTableMoviesGenre(int movie_id, int genre_id) throws SQLException {
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                PreparedStatement pStatement = dbConnection.prepareStatement(ADD_IN_MOVIES_GENRE, Statement.RETURN_GENERATED_KEYS);
                pStatement.setInt(1, movie_id);
                pStatement.setInt(2, genre_id);
                pStatement.executeUpdate();
                pStatement.getGeneratedKeys();
                pStatement.close();
                dbConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> getListMovies() {
        List<Movie> listMovie = new ArrayList<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Movie getMovieByName(String name) {
        Movie movie = null;
        Set<CastMember> listDirectors = new HashSet<>();
        Set<CastMember> listActors = new HashSet<>();
        Set<Genre> listGenre = new HashSet<>();
        Set<Review> listReviews = new HashSet<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                PreparedStatement pStatement = dbConnection.prepareStatement(GET_MOVIE_FROM_ALL_BY_NAME);
                pStatement.setString(1, name);
                ResultSet result = pStatement.executeQuery();
                while (result.next()) {
                    listReviews.add(new Review(result.getInt("rank"), result.getString("comment")));

                    if (result.getString("member_type").equals("режиссер")) {
                        listDirectors.add(new CastMember(result.getString("fname"),
                                result.getString("c.lname"), result.getString("c.mname"),
                                result.getObject("c.date_of_birth", LocalDate.class),
                                result.getString("member_type")));
                    } else {
                        listActors.add(new CastMember(result.getString("c.fname"),
                                result.getString("c.lname"), result.getString("c.mname"),
                                result.getObject("c.date_of_birth", LocalDate.class),
                                result.getString("member_type")));
                    }
                    //listGenre.add();

                    movie = new Movie(result.getLong("movie_id"), result.getString("name"),
                            listDirectors, listActors, result.getObject("year") != null ? result.getObject("year", LocalDate.class)
                            : null, result.getString("country"), listReviews);
                }
                pStatement.close();
                result.close();
                dbConnection.close();
                return movie;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Movie> getAllMoviesWithCastMember() {
        Movie movie = null;
        Set<Movie> listMovie = new HashSet<>();
        Set<CastMember> listDirectors;//new HashSet<>();
        Set<CastMember> listActors; // = new HashSet<>();
        Set<Genre> listGenre = new HashSet<>();
        Set<Review> listReviews; // = new HashSet<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if (dbConnection != null) {
                Statement statement = dbConnection.createStatement();
                ResultSet result = statement.executeQuery(GET_ALL_MOVIES_WITH_CASTMEMBERS);
                while (result.next()) {
                    listReviews = new HashSet<>();
                    listDirectors = new HashSet<>();
                    listActors = new HashSet<>();

                    listReviews.add(new Review(result.getInt("rank"), result.getString("comment")));

                    if (result.getString("member_type").equals("режиссер")) {
                        listDirectors.add(new CastMember(result.getString("fname"),
                                result.getString("c.lname"), result.getString("c.mname"),
                                result.getObject("c.date_of_birth", LocalDate.class),
                                result.getString("member_type")));
                    } else {
                        listActors.add(new CastMember(result.getString("c.fname"),
                                result.getString("c.lname"), result.getString("c.mname"),
                                result.getObject("c.date_of_birth", LocalDate.class),
                                result.getString("member_type")));
                    }
                    //movie.setId(0);
                    if (movie.getId() != result.getLong("movie_id")) {
                        movie = new Movie(result.getLong("movie_id"), result.getString("name"),
                                listDirectors, listActors, result.getObject("year") != null ? result.getObject("year", LocalDate.class)
                                : null, result.getString("country"), listReviews);
                    }
                    listMovie.add(movie);
                }
                statement.close();
                result.close();
                dbConnection.close();
                return listMovie;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movie> geAllMoviesWithGenre() {
        List<Movie> listMovie = new ArrayList<>();
        Set<Genre> listGenre;
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                Statement statement = dbConnection.createStatement();
                ResultSet result = statement.executeQuery(GET_ALL_MOVIES_GENRE);
                while (result.next()) {
                    listGenre = new HashSet<>();
                    listMovie.add(new Movie(result.getLong("movie_id"), result.getString("name"),
                            (result.getObject("year") != null) ? (result.getObject("year", LocalDate.class))
                                    : null, result.getString("country")));
                }
                statement.close();
                result.close();
                dbConnection.close();
                return listMovie;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Movie> getMoviesByYear(int year) {
        //Movie movie = null;
        Set<Movie> listMovie = new HashSet<>();
        Set<CastMember> listDirectors = new HashSet<>();
        Set<CastMember> listActors = new HashSet<>();
        Set<Genre> listGenre = new HashSet<>();
        Set<Review> listReviews = new HashSet<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                PreparedStatement pStatement = dbConnection.prepareStatement(GET_MOVIES_BY_YEAR);
                pStatement.setInt(1, year);
                ResultSet result = pStatement.executeQuery();
                while (result.next()) {
                    //listDirectors = new HashSet<>();
                    //listActors = new HashSet<>();
                    //listReviews = new HashSet<>();
                    listReviews.add(new Review(result.getInt("rank"), result.getString("comment")));

                    if (result.getLong("movie_id") == result.getLong("movie_id") && result.getString("member_type").equals("режиссер")) {
                        listDirectors.add(new CastMember(result.getString("fname"),
                                result.getString("c.lname"), result.getString("c.mname"),
                                result.getObject("c.date_of_birth", LocalDate.class),
                                result.getString("member_type")));
                    } else {
                        listActors.add(new CastMember(result.getString("c.fname"),
                                result.getString("c.lname"), result.getString("c.mname"),
                                result.getObject("c.date_of_birth", LocalDate.class),
                                result.getString("member_type")));
                    }
                    //listGenre.add();

                    listMovie.add(new Movie(result.getLong("movie_id"), result.getString("name"),
                            listDirectors, listActors, result.getObject("year") != null ? result.getObject("year", LocalDate.class)
                            : null, result.getString("country"), listReviews));
                }
                pStatement.close();
                result.close();
                dbConnection.close();
                return listMovie;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movie> getMovieByYear(int year) {
        List<Movie> listMovie = new ArrayList<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movie> getMoviesByCastMember(String fname, String lname) {
        List<Movie> listMovieByCastMember = new ArrayList<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movie> getMovieByGenre(String genre) {
        List<Movie> listMovie = new ArrayList<>();
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                PreparedStatement pStatement = dbConnection.prepareStatement(GET_MOVIES_BY_GENRE);
                pStatement.setString(1, genre);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getNumberMovies() {
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
