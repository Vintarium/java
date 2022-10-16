package by.training.vintilov.controllers;

import by.training.vintilov.dao.CustomerDao;
import by.training.vintilov.dao.ProductDao;
import by.training.vintilov.dao.ReceiptDao;
import by.training.vintilov.dao.ReceiptProductDao;
import by.training.vintilov.dao.daoImpl.ProductService;
import by.training.vintilov.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/online-shop")
public class ShopController {

    private final static Logger log = Logger.getLogger(ShopController.class.getName());
    private final CustomerDao customerDao;
    private final ReceiptDao receiptDao;
    private final ReceiptProductDao receiptProductDao;
    private final ProductDao productDao;

    @Autowired
    public ShopController(
            CustomerDao customerDao,
            ReceiptDao receiptDao,
            ReceiptProductDao receiptProductDao,
            ProductDao productDao) {
        this.customerDao = customerDao;
        this.receiptDao = receiptDao;
        this.receiptProductDao = receiptProductDao;
        this.productDao = productDao;
    }

    @GetMapping
    public String getIndexPage() {
        return "shop/index";
    }

    @PostMapping("/new")
    public String addCustomer(@RequestParam("name") String name, Model model) {
        customerDao.addCustomerWithDataInArguments(name);
        receiptDao.addWithData(customerDao.getLastCustomerFromTable().getId(), 0);
        model.addAttribute("name", name);
        log.info("Method addCustomer worked");
        return "shop/catalog";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("form") String form, @RequestParam("product") String product, Model model) {
        if (form.equals("add")) {
            addProduct(Integer.parseInt(product));
            return "shop/catalog";
        } else if (form.equals("enter")) {
            getThePurchaseReceipt(model);
        }
        return "shop/order";
    }

    private void addProduct(int productId) {
        receiptProductDao.add(receiptDao.getLastReceiptFromTable().getId(), productId);
        log.info("Method addProduct worked");
    }

    private void getThePurchaseReceipt(Model model) {
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

        receiptDao.updateTotalSum(customerDao.getLastCustomerFromTable().getId(), totalPrice);

        model.addAttribute("allProductsCustomer", ProductNameAndProductQuantity);
        model.addAttribute("id", customerDao.getLastCustomerFromTable().getId());
        model.addAttribute("name", customerDao.getLastCustomerFromTable().getName());
        model.addAttribute("totalPrice", totalPrice);
        log.info("Method getThePurchaseReceipt worked");
    }
    @PostMapping("/error")
    public String error() {
        return "shop/error";
    }
}
