package by.training.vintilov.dao.daoImpl;

import by.training.vintilov.dao.ProductDao;
import by.training.vintilov.model.Product;
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
public class ProductService extends ConnectDatabase implements ProductDao {
    private final Logger log = Logger.getLogger(ProductService.class.getName());


    @Override
    public Product getProductById(int productId) {
        Product product = new Product();
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM product WHERE id = ?")) {
                preparedStatement.setInt(1, productId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getInt("price"));
                }
            }
        } catch (SQLException e) {
            log.info("Data not received");
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getInt("price"));
                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            log.info("Data not received");
        }
        return productList;
    }
}
