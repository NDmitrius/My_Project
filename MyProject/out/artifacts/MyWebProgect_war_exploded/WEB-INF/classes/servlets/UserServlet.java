package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


/**
 * Created by DMITRIUS on 27.01.2017.
 */


    @WebServlet(urlPatterns = "/user")
    public class UserServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<html><head>");
            printWriter.println("<title>Registration Page</title></head><body>");
            printWriter.println("<h2>Please Create an Account");
            printWriter.println("<form method = \"post\" action = \"" + req.getContextPath() + "/user\" >");
            printWriter.println("<table border = \" 0\"><tr><td valign = \"top\">");

            printWriter.println("First name:</td> <td valign = \"top\">");
            printWriter.println("<input type = \"text\" name = \"first_name\" size = \"20\">");
            printWriter.println("</td></tr><tr><td valign = \"top\">");

            printWriter.println("Last name:</td> <td valign = \"top\">");
            printWriter.println("<input type = \"text\" name = \"last_name\" size = \"20\">");
            printWriter.println("</td></tr><tr><td valign = \"top\">");

            printWriter.println("Email:</td> <td valign = \"top\">");
            printWriter.println("<input type = \"text\" name = \"email\" size = \"20\">");
            printWriter.println("</td></tr><tr><td valign = \"top\">");

            printWriter.println("<input type=\"submit\" value=\"Submit Info\"></td></tr>");
            printWriter.println("</table></form>");
            printWriter.println("</body></html>");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Enumeration paramNames = req.getParameterNames();
            String parName;
            boolean emptyEnum = false;
            if(!paramNames.hasMoreElements()) {
                emptyEnum = true;
            }
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<html><head>");
            printWriter.println("<title>Registrated Person</title></head><body>");
            if(emptyEnum) {
                printWriter.println("<h2>Sorry, there is no registrated persons </h2>");
            }else {
                printWriter.println("<h2>Here are registrated persons</h2>");
            }
            while (paramNames.hasMoreElements()) {
                parName = (String) paramNames.nextElement();
                printWriter.println("<strong>" + parName + "</strong> : " + req.getParameter(parName));
                printWriter.println("<br />");
            }
            printWriter.println("</body></html>");
    }
}

