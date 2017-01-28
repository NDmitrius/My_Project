package servlets;


import dto.MovieDto;
import entityLayer.CastMember;
import entityLayer.Movie;
import service.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Created by DMITRIUS on 26.01.2017.
 */

@WebServlet(urlPatterns = "/search-movie")
public class MovieByNameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");
        String name = req.getParameter("nameMovie");
        if(name != null) {
            req.setAttribute("movie", MovieService.getInst().findMovie(name));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/MovieByNameView.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Search-Movie.jsp");
            requestDispatcher.include(req, resp);
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
//        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Search-Movie.jsp");
//        requestDispatcher.include(req, resp);
    }



}
