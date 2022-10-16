package by.training.vintilov.homework17.Classes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import by.training.vintilov.homework17.Classes.Product;

public class Order {
    private HashMap<Product, Integer> userOrder = new HashMap();

    public Order() {
    }

    public final HashMap<Product, Integer> getOrder() {
        return this.userOrder;
    }

    public final void setOrder(HashMap<Product, Integer> order) {
        this.userOrder = order;
    }

    public final void addProduct(Product product) {
        if (this.userOrder.containsKey(product)) {
            this.userOrder.replace(product, this.userOrder.get(product), (Integer)this.userOrder.get(product) + 1);
        } else {
            this.userOrder.put(product, 1);
        }

    }

    public final String getOrderString() {
        String orderPrint = "";
        int i = 1;
        Product key;
        Integer value;
        if (!this.userOrder.isEmpty()) {
            for(Iterator var3 = this.userOrder.entrySet().iterator(); var3.hasNext(); orderPrint = orderPrint.concat(i + ") " + key.toString() + ", quantity - " + value + "<br>")) {
                Map.Entry<Product, Integer> entry = (Map.Entry)var3.next();
                key = (Product)entry.getKey();
                value = (Integer)entry.getValue();
            }
        }

        return orderPrint;
    }

    public final BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        Product key;
        Integer value;
        for(Iterator var2 = this.userOrder.entrySet().iterator();
            var2.hasNext();
            total = total.add(key.getProductPrice().multiply(BigDecimal.valueOf((long)value)))) {
            Map.Entry<Product, Integer> entry = (Map.Entry)var2.next();
            key = (Product)entry.getKey();
            value = (Integer)entry.getValue();
        }

        return total;
    }
}
