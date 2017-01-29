package servlets;

import service.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by DMITRIUS on 30.01.2017.
 */

@WebServlet(urlPatterns = "/add-movie")
public class AddMovie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Add-Movie.jsp");
        requestDispatcher.forward(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String movieName = req.getParameter("movieName");
        LocalDate year = LocalDate.parse(req.getParameter("year"));
        String country = req.getParameter("country");

        MovieService.addMovie(movieName, year, country);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Movie-Added.jsp");
        requestDispatcher.forward(req, resp);
    }
}
