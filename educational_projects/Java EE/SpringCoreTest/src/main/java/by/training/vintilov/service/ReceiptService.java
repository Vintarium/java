package by.training.vintilov.service;

import by.training.vintilov.dao.ReceiptDao;
import by.training.vintilov.entity.Receipt;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@Component
public class ReceiptService extends ConnectDb implements ReceiptDao {
    private static Logger log = Logger.getLogger(ReceiptService.class.getName());


    @Override
    public void addWithData(int customerId, int totalPrice) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO receipt(customerId, totalPrice) VALUES (?,?)")) {
                preparedStatement.setInt(1, customerId);
                preparedStatement.setInt(2, totalPrice);
                preparedStatement.executeUpdate();
            }
            log.info("An entry in the receipt table has been made");
        } catch (SQLException e) {
            log.info("Data is not put to table");
        }

    }


    @Override
    public void updateTotalSum(int customerId, int totalPrice) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE receipt SET totalPrice = ? where customerId = ?")) {
                preparedStatement.setInt(1, totalPrice);
                preparedStatement.setInt(2, customerId);
                preparedStatement.executeUpdate();
            }
            log.info("The total amount of the recipe has been changed");
        } catch (SQLException e) {
            log.info("Table not updated");
        }
    }

    @Override
    public Receipt getLastReceiptFromTable() {
        Receipt receipt = new Receipt();
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT TOP 1 * FROM receipt ORDER BY id DESC")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    receipt.setId(resultSet.getInt("id"));
                    receipt.setCustomerId(resultSet.getInt("customerId"));
                    receipt.setTotalPrice(resultSet.getInt("totalPrice"));
                }
            }
            log.info("The last recipe from the table was retrieved");
        } catch (SQLException e) {
            log.info("Data not received");
        }
        return receipt;
    }


}
