package by.training.vintilov.homework16.Servlets;

import by.training.vintilov.homework16.classes.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;


public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession();
        Order order = (Order) request.getSession().getAttribute("order");
        String orderString = order.getOrderString();
        if (order.getOrderString().isEmpty()) {
            orderString = "You didn't buy anything";
        }

        response.getWriter().println(MessageFormat.format(
                "<html>" +
                        "<body>" +
                        "<div align=\"center\"; style= \"padding-top: 250px; font-size: 30px\">" +
                        " Dear, {0}, your order:" +
                        "<p align= \"left\"; style= \"padding-left: 500px\"> {1} </p>" +
                        "<p> Total: $ {2}" +
                        " </p></div></html>",

                request.getSession().getAttribute("name"),
                orderString, request.getSession().getAttribute("total")));
    }


}
