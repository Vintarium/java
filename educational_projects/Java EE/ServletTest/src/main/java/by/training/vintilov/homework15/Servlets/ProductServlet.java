package by.training.vintilov.homework15.Servlets;

import by.training.vintilov.homework15.classes.Assortment;
import by.training.vintilov.homework15.classes.Order;
import by.training.vintilov.homework15.classes.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;


public class ProductServlet extends HttpServlet {
    private Order order = new Order();
    public static final String SECOND_PAGE =
            "<html>" +
                    "<body>" +
                    "<div align=\"center\"; style= \"padding-top: 200px; font-size: 35px\">" +
                    " Hello, {0} !</div>" +
                    "<div align=\"center\";style=\"padding-top: 100px\">" +
                    "Make your order please<p align= \"left\"; style= \"padding-left: 600px\"> {1} </p>" +
                    "<form id = \"add\" action = \"#\" method = \"POST\" > " +
                    "<select name=\"product\">" + Assortment.getAllProducts() +
                    "</select><input type = \"hidden\" name = \"Form\" value = \"add\">" +
                    "</form><form id = \"enter\" action = \"#\" method = \"POST\">" +
                    " <input type = \"hidden\" name = \"Form\" value = \"enter\">" +
                    "</form<h2><input form = \"add\" type=\"submit\" value = \"ADD product\">" +
                    "<a href = \"order\"> <input form = \"enter\" type=\"submit\" value = \"Enter\"</a><h2></div>" +
                    "<body>" +
                    "</html>";

    public ProductServlet() {
    }

    public final void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession();
        response.getWriter().println(MessageFormat.format(SECOND_PAGE, request.getSession().getAttribute("name"),
                this.order.getOrderString()));
    }

    public final void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession();
        if (request.getParameter("Form").equals("add")) {
            this.saveProducts(request, response);
        } else if (request.getParameter("Form").equals("enter")) {
            request.getSession().setAttribute("order", this.order);
            request.getSession().setAttribute("total", this.order.getTotal());
            response.sendRedirect("/online-shop/order");
        }

    }

    public final Order getOrder() {
        return this.order;
    }

    private void saveProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession();
        Product product = (Product) Assortment.getProducts().get(Integer.parseInt(request.getParameter("product")));
        this.order.addProduct(product);
        this.doGet(request, response);
    }
}
