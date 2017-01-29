import dto.CastMemberDto;
import dto.MovieDto;
import entityLayer.CastMember;
import service.MovieService;

/**
 * Created by DMITRIUS on 26.01.2017.
 */
public class Test {

    public static void main(String[] args) {

//        MovieService movieService = MovieService.getInst();
//
//        System.out.println(movieService.findMovie("Хоббит: Битва пяти воинств"));
//        System.out.println();
//        System.out.println(movieService.allMovies());

        MovieDto movieDto = MovieService.getInst().findMovie("Хоббит: Битва пяти воинств");
        System.out.println(movieDto.getName() + " " + movieDto.getYear() + " " + movieDto.getCountry());
        for(CastMember director : movieDto.getDirector()) {
            System.out.println(director.getFirstName() + " " + director.getLastName());
        }
        for(CastMember actor : movieDto.getActors()) {
            System.out.println(actor.getFirstName() + " " + actor.getLastName());
        }
    }
}
