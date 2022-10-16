package by.training.vintilov.servlets;

import by.training.vintilov.dao.CustomerDao;
import by.training.vintilov.dao.ReceiptDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.String.valueOf;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );
    private final CustomerDao customerDao = context.getBean("customerService", CustomerDao.class);
    private final ReceiptDao receiptDao = context.getBean("receiptService",ReceiptDao.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerDao.addCustomerWithDataInArguments(valueOf(req.getParameter("name")));
        receiptDao.addWithData(customerDao.getLastCustomerFromTable().getId(), 0);
        req.getSession().setAttribute("name", req.getParameter("name"));
        req.getRequestDispatcher("/WEB-INF/jsp/catalog.jsp").forward(req, resp);


    }
}
