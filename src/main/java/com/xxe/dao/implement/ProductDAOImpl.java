package com.xxe.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xxe.dao.ProductDAO;
import com.xxe.entity.Product;
import com.xxe.utils.DBConnection;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> getAllProducts() {

      List<Product> list = new ArrayList<>();

      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "SELECT * FROM xxe.products";
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        ResultSet resultSet = pstmt.executeQuery();
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
      } catch (SQLException e) {
        throw new RuntimeException("Failed to query products from database: " + e.getMessage(), e);
      } finally {
        try {
          db.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return list;
    }

    
    public static void main(String[] args) {
      ProductDAO dao = new ProductDAOImpl();
      List<Product> list = dao.getAllProducts();
      System.out.println(list);
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
