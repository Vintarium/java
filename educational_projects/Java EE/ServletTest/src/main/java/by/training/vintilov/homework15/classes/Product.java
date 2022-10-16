package by.training.vintilov.homework15.classes;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String productName;
    private BigDecimal productPrice;

    public Product(String productName, BigDecimal productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }

    public final BigDecimal getProductPrice() {
        return this.productPrice;
    }

    public final void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public final String toString() {
        return this.productName + "( " + this.productPrice + " $ )";
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Product product = (Product)o;
            return this.productName.equals(product.productName) && this.productPrice.equals(product.productPrice);
        } else {
            return false;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.productName, this.productPrice});
    }
}
