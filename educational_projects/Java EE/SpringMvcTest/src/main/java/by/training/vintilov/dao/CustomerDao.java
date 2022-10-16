package by.training.vintilov.dao;

import by.training.vintilov.model.Customer;

public interface CustomerDao {
    void addCustomerWithDataInArguments(String name);
    Customer getLastCustomerFromTable();
}
