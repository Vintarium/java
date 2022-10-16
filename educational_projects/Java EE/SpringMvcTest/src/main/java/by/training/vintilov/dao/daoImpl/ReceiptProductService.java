package by.training.vintilov.dao.daoImpl;

import by.training.vintilov.dao.ReceiptProductDao;
import by.training.vintilov.service.ConnectDatabase;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class ReceiptProductService extends ConnectDatabase implements ReceiptProductDao {
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
        } catch (SQLException e) {
            log.info("Data not received");
        }
        return productIdList;
    }

}
