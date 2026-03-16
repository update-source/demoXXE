package com.xxe.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xxe.dao.ProductDAO;
import com.xxe.entity.Product;
import com.xxe.utils.DBConnection;

public class ProductDAOImpl implements ProductDAO{

    @Override
    public List<Product> getAllProducts() {

      List<Product> list = new ArrayList<>();

      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "SELECT * FROM products";
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        ResultSet resultSet = pstmt.executeQuery();
        try {
          while (resultSet.next()) {
            int productId = resultSet.getInt(1);
            String productName = resultSet.getString(2);
            int productPrice = resultSet.getInt(3);
            String productDescription = resultSet.getString(4);
            int productStars = resultSet.getInt(5);
            String productImgUrl = resultSet.getString(6);
            int storeId = resultSet.getInt(7);

            list.add(new Product(productDescription, productImgUrl, productName, productPrice, productId, productStars, storeId));
          }       
        } catch (SQLDataException e) {
          System.err.println(e.getMessage());
        }
      } catch (SQLException e) {
        System.err.println(e.getMessage());
      } finally {
        try {
          db.close();
        } catch (SQLException e) {
          System.err.println(e.getMessage());
        }
      }
      return list;
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
