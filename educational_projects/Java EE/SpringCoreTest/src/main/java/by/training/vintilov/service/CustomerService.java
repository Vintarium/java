package by.training.vintilov.service;

import by.training.vintilov.dao.CustomerDao;
import by.training.vintilov.entity.Customer;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@Component
public class CustomerService extends ConnectDb implements CustomerDao {
    private final static Logger  log = Logger.getLogger(CustomerService.class.getName());

    @Override
    public void addCustomerWithDataInArguments(String name) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO customer (name) values(?)")) {
                preparedStatement.setString(1, name);
                preparedStatement.execute();
                log.info("customer has been added");
            }
        } catch (SQLException e) {
            log.info("Data is not put to table");
        }
    }


    @Override
    public Customer getLastCustomerFromTable() {
        Customer customer = new Customer();
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT TOP 1 * FROM customer ORDER BY ID DESC")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    customer.setId(resultSet.getInt(1));
                    customer.setName(resultSet.getString(2));
                }
            }
            log.info("the last customer in the table was received");
        } catch (SQLException e) {
            log.info("Data not received");

        }
        return customer;
    }


}
