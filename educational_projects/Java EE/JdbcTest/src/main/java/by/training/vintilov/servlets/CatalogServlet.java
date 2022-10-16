package by.training.vintilov.servlets;

import by.training.vintilov.dao.CustomerDao;
import by.training.vintilov.dao.ProductDao;
import by.training.vintilov.dao.ReceiptDao;
import by.training.vintilov.dao.ReceiptProductDao;
import by.training.vintilov.entity.Customer;
import by.training.vintilov.entity.Product;
import by.training.vintilov.service.CustomerService;
import by.training.vintilov.service.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/catalogServlet")
public class CatalogServlet extends HttpServlet {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );

    private final ReceiptProductDao receiptProductDao = context.getBean(
            "receiptProductService", ReceiptProductDao.class);
    private final ReceiptDao receiptDao = context.getBean("receiptService", ReceiptDao.class);
    private final CustomerDao customerDao = context.getBean("customerService", CustomerDao.class);
    private final Customer customer = customerDao.getLastCustomerFromTable();
    private final ProductDao productDao = context.getBean("productService",ProductDao.class);
    private static Logger log = Logger.getLogger(CustomerService.class.getName());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("form").equals("add")) {
            addProduct(req, resp);
        } else if (req.getParameter("form").equals("enter")) {
            getThePurchaseReceipt(req, resp);
            req.getRequestDispatcher("/WEB-INF/jsp/order.jsp").forward(req, resp);
        }
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) {
        receiptProductDao.add(receiptDao.getLastReceiptFromTable().getId(),
                Integer.parseInt(req.getParameter("product")));
        try {
            req.getRequestDispatcher("/WEB-INF/jsp/catalog.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info("Data is not put to table");
        }

    }

    private void getThePurchaseReceipt(HttpServletRequest req, HttpServletResponse resp) {
       /* StringBuilder allProductsCustomer = new StringBuilder();
        int totalPrice = 0;
        List<Integer> productsId = receiptProductDao.getAllProductIdsFromRecipeProductsTableByRecipeId(
                receiptDao.getLastReceiptFromTable().getId());

        for (int id : productsId) {
            Product product = new ProductService().getProductById(id);
            allProductsCustomer.append(product.getName()).append(" ");
            totalPrice = totalPrice + product.getPrice();

        }*/
        Map<String, Integer> ProductNameAndProductQuantity = new HashMap();
        List<Product> customerProducts = new ArrayList<>();
        int totalPrice = 0;
        List<Integer> productsId = receiptProductDao.getAllProductIdsFromRecipeProductsTableByRecipeId(
                receiptDao.getLastReceiptFromTable().getId());

        for (int id : productsId) {
            Product product = new ProductService().getProductById(id);
            customerProducts.add(productDao.getProductById(id));
            totalPrice = totalPrice + product.getPrice();
        }

        for (Product product : customerProducts) {
            ProductNameAndProductQuantity.put(product.getName(), Collections.frequency(customerProducts, product));
        }
        receiptDao.updateTotalSum(customer.getId(), totalPrice);
        req.getSession().setAttribute("id", customerDao.getLastCustomerFromTable().getId());
      //  req.getSession().setAttribute("allProducts", allProductsCustomer.toString());
        req.getSession().setAttribute("allProducts", ProductNameAndProductQuantity);
        req.getSession().setAttribute("totalPrice", totalPrice);

    }
}
