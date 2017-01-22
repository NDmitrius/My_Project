package entityLayer;

import dao.MovieDao;

import java.sql.SQLException;

/**
 * Created by DMITRIUS on 22.01.2017.
 */
public class TestDao {
    public static void main(String[] args) {

        MovieDao movieDao = new MovieDao();
        movieDao.initDB();
        try {
            for(Movie movie : movieDao.getListMovies()) {
                System.out.println(movie.getId() + ". " + " " + movie.getName());
            }

            System.out.println("Всего фильмов в таблице: " + movieDao.getNumberMovies());

            for (Movie movie : movieDao.getMoviesByCastMember("Джонни", "Депп")) {
                System.out.println(movie.getName() + " - " + movie.getYear() + " " + movie.getCountry());
            }

            for (Movie movieByYear : movieDao.getMovieByYear(2011)) {
                System.out.println(movieByYear.getName());
            }

            for (Movie movie : movieDao.getMoviesWithCastMember()) {
                System.out.println(movie.getId() + ". " + movie.getName() + " " + movie.getYear() + " " + movie.getCountry());
                for (CastMember director : movie.getDirector()) {
                    System.out.println("Режиссер: " + director.getFirstName() + " " + director.getLastName());
                    }
                for (CastMember actor : movie.getActors()) {
                    System.out.println("Актер: " + actor.getFirstName() + " " + actor.getLastName());
                }
                for (Review review : movie.getReviews()) {
                    System.out.println("Оценка: " + review.getRating() + " Отзыв: " + review.getTextOfComment());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
