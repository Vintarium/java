package by.training.vintilov.homework16.ErrorServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ErrorLoginServlet")
public class ErrorLoginServlet extends HttpServlet {


    protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession();

        response.getWriter().println(
                        "<html>" +
                        "<body>" +
                        " <div align=\"center\"; style= \"padding-top: 200px; font-size: 50px\"> " +
                        "No name was specified. Please try again </div>" +
                        "<div align= \"center\";style= \"padding-top: 100px\">" +
                        "<a  href = \"login\"> <h2> Start page </h2></a></div>" +
                        "<body>" +
                        "</html>");


    }
}
