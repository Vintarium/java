package by.training.vintilov.homework16.Servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class NameServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        resp.getWriter().println(
                "<html>" +
                        "<body>" +
                        "<div align=\"center\"; style= \"padding-top: 200px; font-size: 30px\">" +
                        " Welcome to online shop</div>" +
                        "<div align= \"center\";style= \"padding-top: 100px\">" +
                        "<form  action= \"#\" method = \"POST\">" +
                        "<input name= \"name\"; type= \"text\"; placeholder= \"Enter your name\">" +
                        "<p style= \"margin-bottom: 15px\">" +
                        "<input type=\"checkbox\"; name=\"checkbox\" checked>I agree with the terms of service</p>" +
                        "<input type = \"submit\" value = \"Enter\" ></p></form></div>" +
                        "<body>" +
                        "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("name", req.getParameter("name"));
        req.getSession().setAttribute("checkbox", req.getParameter("checkbox"));
        resp.sendRedirect("/online-shop/catalog");
    }
}
