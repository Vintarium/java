package by.training.vintilov.dao;

import java.util.List;

public interface ReceiptProductDao {

    void add(int receiptId, int productId);

    List<Integer> getAllProductIdsFromRecipeProductsTableByRecipeId(int receiptId);


}
