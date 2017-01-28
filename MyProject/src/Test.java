import service.MovieService;

/**
 * Created by DMITRIUS on 26.01.2017.
 */
public class Test {

    public static void main(String[] args) {

        MovieService movieService = MovieService.getInst();

        System.out.println(movieService.findMovie("Хоббит: Битва пяти воинств"));
//        System.out.println();
//        System.out.println(movieService.allMovies());


    }
}
