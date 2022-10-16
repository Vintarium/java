package by.training.vintilov.dao;

import by.training.vintilov.model.Receipt;

public interface ReceiptDao {
    void addWithData(int customerId, int totalPrice);

    void updateTotalSum(int customerId, int totalSum);

    Receipt getLastReceiptFromTable();


}
