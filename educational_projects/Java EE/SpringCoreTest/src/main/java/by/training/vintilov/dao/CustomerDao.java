package by.training.vintilov.dao;

import by.training.vintilov.entity.Customer;

public interface CustomerDao {
    void addCustomerWithDataInArguments(String name);

    Customer getLastCustomerFromTable();

}
