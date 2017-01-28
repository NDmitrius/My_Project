package service;

import dao.MovieDao;
import dto.MovieDto;
import entityLayer.CastMember;
import entityLayer.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMITRIUS on 26.01.2017.
 */
public class MovieService {

    private static MovieService INSTANCE;
    private MovieService() {}

    public static MovieService getInst() {
        if(INSTANCE == null) {
            synchronized (MovieService.class) {
                if(INSTANCE == null) {
                    INSTANCE = new MovieService();
                }
            }
        }
        return INSTANCE;
    }

    public List<MovieDto> allMovies() {
        List<MovieDto> movieDtoList = new ArrayList<>();
        MovieDao movieDao = new MovieDao();
        movieDao.initDB();
        for (Movie movie : movieDao.getListMovies()) {
            movieDtoList.add(new MovieDto(movie.getName(), movie.getYear(), movie.getCountry()));
        }
        return movieDtoList;
    }

    public MovieDto findMovie(String name) {
        MovieDto movieDto = null;
        MovieDao movieDao = new MovieDao();
        movieDao.initDB();
        if(name != null) {
            Movie movie = movieDao.getMovieByName(name);
            movieDto = new MovieDto(movie.getName(), movie.getDirector(), movie.getActors(), movie.getYear(),
                    movie.getCountry());

            return movieDto;
        }
//        movieDto.setName(movie.getName());
//        movieDto.setDirector(movie.getDirector());
//        movieDto.setActors(movie.getActors());
//        movieDto.setYear(movie.getYear());
//        movieDto.setCountry(movie.getCountry());
//        movieDto.setReviews(movie.getReviews());

        return null;
    }
}
