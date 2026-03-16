package com.xxe.dao.implement;

import java.util.List;

import com.xxe.dao.ProductDAO;
import com.xxe.entity.Product;

public class ProductDAOImpl implements ProductDAO{

    @Override
    public List<Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getById(int productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteProduct(int productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Product> searchByName(String keyword) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Product> getByStoreId(int storeId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
