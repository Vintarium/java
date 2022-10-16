package by.training.vintilov.model;

import java.util.Objects;

public class Receipt {
    private int id;
    private int customerId;
    private int totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return id == receipt.id &&
                customerId == receipt.customerId &&
                totalPrice == receipt.totalPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, totalPrice);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
