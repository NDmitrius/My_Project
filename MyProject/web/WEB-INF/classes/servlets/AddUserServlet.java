package servlets;

import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DMITRIUS on 29.01.2017.
 */

@WebServlet (urlPatterns = "/add-user")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Add-User.jsp");
        requestDispatcher.forward(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String middleName = req.getParameter("middleName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(firstName == null || lastName == null || middleName == null || email == null || password == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/User-not-added.jsp");
            requestDispatcher.include(req, resp);
        } else {
            UserService.addUser(firstName, lastName, middleName, email, password);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/User-added.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
