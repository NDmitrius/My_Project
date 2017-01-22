package entityLayer;

import dao.CastMemberDao;
import dao.MovieDao;
import dao.ReviewDao;
import dao.UserDao;

import java.sql.*;

/**
 * Created by DMITRIUS on 19.01.2017.
 */
public class TestConnection {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        MovieDao movieDao = new MovieDao();
        movieDao.initDB();
        try {
//            movieDao.addInTableMovies("Сокровище нации", 2004, "США");
//            movieDao.addInTableMoviesGenre(11, 21);
//            movieDao.addInTableMoviesGenre(11, 6);
//            movieDao.addInTableMoviesGenre(11, 3);
//            movieDao.addInTableMovies("Сокровище нации 2", 2007, "США");
//            movieDao.addInTableMoviesGenre(12, 21);
//            movieDao.addInTableMoviesGenre(12, 6);
//            movieDao.addInTableMoviesGenre(12, 3);
            movieDao.getAllMovies();
            System.out.println();
            movieDao.getNumberMovies();
            System.out.println();
            movieDao.geAllMoviesWithGenre();
            System.out.println();
            movieDao.getMovieByYear(2007);
            System.out.println();
            movieDao.getMovieByCastmember("Орландо", "Блум");
            System.out.println();
            movieDao.getMovieByGenre("боевик");
//            Movie movie = movieDao.getById(2L);
//            System.out.println(movie.getId() + " " + movie.getName());
            movieDao.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();

        CastMemberDao castMemberDao = new CastMemberDao();
        castMemberDao.initDB();
        try {
            castMemberDao.getAllCastMembers();
            System.out.println();
//            castMemberDao.getAllCastmembersWithMovies();
            castMemberDao.getCatMemberByMovie("Хоббит: Битва пяти воинств");
            System.out.println();
            castMemberDao.getCastmembersByName("Мартин");
            System.out.println();
            castMemberDao.getCastmembersByName("Фриман");
            System.out.println();
            castMemberDao.getCastmembersByType("режиссер");
            castMemberDao.getCastmembersByType("актер");
            movieDao.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();

        UserDao userDao = new UserDao();
        userDao.initDB();
        try {
            userDao.getAllUsers();
            System.out.println();
            userDao.getAllUsersWithReview();
            System.out.println();
            userDao.getUserByName("Дмитрий", "Нестерчук");
            System.out.println();
            userDao.getUserByNameWithReview("Дмитрий", "Нестерчук");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();

        ReviewDao reviewDao = new ReviewDao();
        reviewDao.initDB();
        try {
            reviewDao.getAllReviews();
            System.out.println();
            reviewDao.getAllRanks();
            System.out.println();
            reviewDao.getReviewByMovie("Хоббит: Нежданное путешествие");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
