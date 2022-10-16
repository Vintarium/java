package by.training.vintilov.homework17.Classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;


public final class Assortment {
    private static ArrayList<Product> products;

    private Assortment() {
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static String getAllProducts() {
        formAssortment();
        String assortmentString = "";
        int i = 0;

        for(Iterator iterator = products.iterator(); iterator.hasNext(); i++) {
            Product product = (Product)iterator.next();
            assortmentString = assortmentString.concat("<option value = " + i + ">" + product.toString() + "</option><br>");
        }

        return assortmentString;
    }

    private static void formAssortment() {
        products = new ArrayList();
        products.add(new Product("Book", BigDecimal.valueOf(120L)));
        products.add(new Product("PlayStation5", BigDecimal.valueOf(700L)));
        products.add(new Product("IPod", BigDecimal.valueOf(300L)));
        products.add(new Product("Brain", BigDecimal.valueOf(1000L)));
        products.add(new Product("Picture", BigDecimal.valueOf(100L)));
        products.add(new Product("Guitar", BigDecimal.valueOf(500L)));
        products.add(new Product("Chocolate bar", BigDecimal.valueOf(25)));
        products.add(new Product("Cola", BigDecimal.valueOf(20L)));
        products.add(new Product("Gun", BigDecimal.valueOf(200L)));
        products.add(new Product("Music album", BigDecimal.valueOf(70L)));
        products.add(new Product("Ticket", BigDecimal.valueOf(100L)));
    }
}
