package by.training.vintilov.service;

import by.training.vintilov.dao.ReceiptProductDao;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class ReceiptProductService extends ConnectDb implements ReceiptProductDao {
    private static Logger log = Logger.getLogger(ProductService.class.getName());

    @Override
    public void add(int receiptId, int productId) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO receiptProduct(receiptId,productId) values(?,?)")) {
                preparedStatement.setInt(1, receiptId);
                preparedStatement.setInt(2, productId);
                preparedStatement.executeUpdate();
            }
            log.info("Row has been added to the receipt_product table");
        } catch (SQLException e) {
            log.info("Data is not put to table");
        }
    }

    @Override
    public List<Integer> getAllProductIdsFromRecipeProductsTableByRecipeId(int receiptId) {
        List<Integer> productIdList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT productId FROM receiptProduct WHERE receiptId = ?")) {
                preparedStatement.setInt(1, receiptId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    while (resultSet.next()) {
                        productIdList.add(resultSet.getInt("productId"));
                    }
                }
            }
            log.info("All products from the recipe_product table by receipt_id have been retrieved");
        } catch (SQLException e) {
            log.info("Data not received");
        }
        return productIdList;
    }

}
