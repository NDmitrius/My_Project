package service;

import dao.CastMemberDao;
import dao.MovieDao;
import dto.CastMemberDto;
import dto.MovieDto;
import entityLayer.CastMember;
import entityLayer.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void addMovie(String name, LocalDate year, String country) {
        MovieDao movieDao = new MovieDao();
        movieDao.initDB();
        movieDao.addMovie(new Movie(name, year, country));
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
        MovieDto movieDto = new MovieDto();
        MovieDao movieDao = new MovieDao();
        movieDao.initDB();
        Movie movie = movieDao.getMovieByName(name);
        movieDto.setName(movie.getName());
        System.out.println(movieDto.getName());
        if (movie.getName() != null) {
            movieDto.setName(movie.getName());
            System.out.println(movieDto.getName());
        }
        if(movie.getDirector() != null) {
            movieDto.setDirector(movie.getDirector());
            System.out.println(movieDto.getDirector());
        }
        if(movie.getActors() != null) {
            movieDto.setActors(movie.getActors());
            System.out.println(movieDto.getActors());
        }
        movieDto.setYear(movie.getYear());
        if(movie.getGenre() != null) {
            movieDto.setCountry(movie.getCountry());
            System.out.println(movieDto.getCountry());
        }
        if(movie.getReviews() != null) {
            movieDto.setReviews(movie.getReviews());
            System.out.println(movieDto.getReviews());
        }
        return movieDto;
    }





//    public MovieDto findMovie(String name) {
//        MovieDto movieDto = new MovieDto();
//        MovieDao movieDao = new MovieDao();
//        CastMemberDao castMemberDao = new CastMemberDao();
//        Set<CastMemberDto> directorDto = new HashSet<>();
//        Set<CastMemberDto> actorsDto = new HashSet<>();
//        //CastMember castMember = castMemberDao.getCatMembersByMovie(name);
//        movieDao.initDB();
//        Movie movie = movieDao.getMovieByName(name);
////        movieDto.setName(movie.getName());
////        System.out.println(movieDto.getName());
//        if (movie.getName() != null) {
//            movieDto.setName(movie.getName());
//            System.out.println(movieDto.getName());
//        }
////        if(movie.getDirector() != null) {
////            directorDto.add(new CastMemberDto(new CastMember(movie.getDirector())));
////            movieDto.setDirector(directorDto);
//
////            movieDto.setDirector(movie.getDirector());
////            System.out.println(movieDto.getDirector());
//
//        if(movie.getActors() != null) {
//            actorsDto.add(new CastMemberDto());
//            movieDto.setActors(actorsDto);
//
////            movieDto.setActors(movie.getActors());
////            System.out.println(movieDto.getActors());
//        }
//        movieDto.setYear(movie.getYear());
//        if(movie.getGenre() != null) {
//            movieDto.setCountry(movie.getCountry());
//            System.out.println(movieDto.getCountry());
//        }
////        if(movie.getReviews() != null) {
////            movieDto.setReviews(movie.getReviews());
////            System.out.println(movieDto.getReviews());
////        }
//        return movieDto;
//    }

}
