package entityLayer;

import dao.ReviewDao;
import dao.UserDao;

/**
 * Created by DMITRIUS on 22.01.2017.
 */
public class TestDao {
    public static void main(String[] args) {

//        MovieDao movieDao = new MovieDao();
//        movieDao.initDB();
//
//        for (Movie movie : movieDao.getMoviesByCastMember("Орландо", "Блум")) {
//            System.out.println(movie.getName() + " - " + movie.getYear() + " " + movie.getCountry());
//        }
//
//        for (Movie movie : movieDao.getMovieByGenre("фэнтези")) {
//            System.out.println(movie.getName() + " - " + movie.getYear() + " " + movie.getCountry());
//        }
//
//        for (Movie movie : movieDao.getListMovies()) {
//            System.out.println(movie.getName() + " - " + movie.getYear() + " " + movie.getCountry());
//        }
//
//        for (Movie movie : movieDao.getMovieByYear(2011)) {
//            System.out.println(movie.getName() + " - " + movie.getYear() + " " + movie.getCountry());
//        }
//
//        System.out.println("Всего фильмов в таблице: " + movieDao.getNumberMovies());
//
//        Movie movie =  movieDao.getMovieByName("Властелин колец: братство кольца");
//        System.out.println(movie.getId() + ". " + movie.getName() + " " + movie.getYear() + " " + movie.getCountry());
//        for (CastMember director : movie.getDirector()) {
//            System.out.println("Режиссер: " + director.getFirstName() + " " + director.getLastName());
//            }
//        for (CastMember actor : movie.getActors()) {
//            System.out.println("Актер: " + actor.getFirstName() + " " + actor.getLastName());
//        }
//        for (Review review : movie.getReviews()) {
//            System.out.println("Оценка: " + review.getRating() + " Отзыв: " + review.getTextOfComment());
//        }
//
//        System.out.println();
//
//        for (Movie movie1 : movieDao.getMoviesByYear(2003)) {
//            System.out.println(movie1.getId() + ". " + movie1.getName() + " " + movie1.getYear() + " " + movie1.getCountry());
//            for (CastMember director : movie1.getDirector()) {
//                System.out.println("Режиссер: " + director.getFirstName() + " " + director.getLastName());
//            }
//            for (CastMember actor : movie1.getActors()) {
//                System.out.println("Актер: " + actor.getFirstName() + " " + actor.getLastName());
//            }
//            for (Review review : movie1.getReviews()) {
//                System.out.println("Оценка: " + review.getRating() + " Отзыв: " + review.getTextOfComment());
//            }
//        }

//        CastMemberDao castMemberDao = new CastMemberDao();
//        castMemberDao.initDB();

//        for (CastMember castMember : castMemberDao.getAllCastMembers()) {
//            System.out.println(castMember.getFirstName() + " " + castMember.getLastName() + " " + castMember.getDateOfBirth());
//        }

//        for (CastMember castMember : castMemberDao.getCatMembersByMovie("Хоббит: Битва пяти воинств")) {
//            System.out.println(castMember.getFirstName() + " " + castMember.getLastName() + " " + castMember.getDateOfBirth());
//        }


//        UserDao userDao = new UserDao();
//        userDao.initDB();
//
//        for (User user : userDao.getUsers()) {
//            System.out.println(user.getFirstName() + " " + user.getLastName());
//        }
//
//        for (User user : userDao.getAllUsersHaveReview()) {
//            System.out.println(user.getFirstName() + " " + user.getLastName());
//        }
//
//        User user = userDao.getUserByName("Амаль", "Кабулов");
//        System.out.println(user.getFirstName() + " " + user.getLastName());


        ReviewDao reviewDao = new ReviewDao();
        reviewDao.initDB();

        for (Review review : reviewDao.getAllReviews()) {
            System.out.println(review.getRating() + " " + review.getTextOfComment());
        }


    }
}
