package by.training.vintilov.homework17.ErrorServlets;

import javax.servlet.RequestDispatcher;
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ErrorPages/ErrorLogin.jsp");
        dispatcher.forward(request,response);


    }
}
