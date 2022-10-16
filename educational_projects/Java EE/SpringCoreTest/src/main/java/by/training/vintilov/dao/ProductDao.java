package by.training.vintilov.dao;

import by.training.vintilov.entity.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(int productId);

    List<Product> getAllProducts();
}
