package by.training.vintilov.model;

import java.util.Objects;

public class ReceiptProduct {
    private int receiptId;
    private int productId;

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptProduct that = (ReceiptProduct) o;
        return receiptId == that.receiptId &&
                productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, productId);
    }

    @Override
    public String toString() {
        return "ReceiptProduct{" +
                "receiptId=" + receiptId +
                ", productId=" + productId +
                '}';
    }
}
