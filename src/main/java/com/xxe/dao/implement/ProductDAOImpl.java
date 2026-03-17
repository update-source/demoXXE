package com.xxe.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xxe.dao.ProductDAO;
import com.xxe.entity.Product;
import com.xxe.entity.Store;
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
        try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
          try (ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
              int productId = resultSet.getInt(1);
              String productName = resultSet.getString(2);
              double productPrice = resultSet.getDouble(3);
              String productDescription = resultSet.getString(4);
              int productStars = resultSet.getInt(5);
              String productImgUrl = resultSet.getString(6);
              int storeId = resultSet.getInt(7);

              list.add(new Product(productId, productName, productPrice, productDescription, productStars, productImgUrl, storeId));
            }
          }
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
      /* Test getAllProducts method */
      ProductDAO dao = new ProductDAOImpl();
      // List<Product> list = dao.getAllProducts();
      // System.out.println(list);
      /* Test getProductById */
      // Product product = dao.getProductById(1);
      // System.out.println(product);
      /* Test addProduct method Then check if the new product exised in db by call getAllProducts metho */
      // Product product = new Product("Chuột Gaming Pro", 890000.00, "Chuột không dây độ nhạy 16000 DPI", 4, "https://picsum.photos/200/300?sig=2", 1);
      // dao.addProduct(product);
      // System.out.println(dao.getAllProducts());
      /* Test searchByName method */
      // String keyword = "pro";
      // List<Product> products = dao.searchByName(keyword);
      // System.out.println(products);
    }
    
    @Override
    public Product getProductById(int productId) {
      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "SELECT product_id, name, price, description, stars, image_url, store_id FROM xxe.products WHERE product_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
          pstmt.setInt(1, productId);
          try (ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
              Product product = new Product();
              product.setProductId(resultSet.getInt(1));
              product.setName(resultSet.getString(2));
              product.setPrice(resultSet.getDouble(3));
              product.setDescription(resultSet.getString(4));
              product.setStars(resultSet.getInt(5));
              product.setImageUrl(resultSet.getString(6));
              product.setStoreId(resultSet.getInt(7));
              return product;
            }
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          db.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return null;
    }

    @Override
    public void addProduct(Product product) {
      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "INSERT INTO xxe.products (name, price, description, stars, image_url, store_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){          
          pstmt.setString(1, product.getName());
          pstmt.setDouble(2, product.getPrice());
          pstmt.setString(3, product.getDescription());
          pstmt.setInt(4, product.getStars());
          pstmt.setString(5, product.getImageUrl());
          pstmt.setInt(6, product.getStoreId());

          pstmt.executeUpdate();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          db.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
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

      List<Product> list = new ArrayList<>();

      DBConnection db = new DBConnection();
      try {
        db.connect();
        Connection conn = db.getConnection();
        String sqlQuery = "SELECT product_id, name, price, description, stars, image_url, store_id FROM xxe.products WHERE name LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
          pstmt.setString(1, "%" + keyword + "%");
          try (ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
              Product product = new Product();
              product.setProductId(resultSet.getInt(1));
              product.setName(resultSet.getString(2));
              product.setPrice(resultSet.getDouble(3));
              product.setDescription(resultSet.getString(4));
              product.setStars(resultSet.getInt(5));
              product.setImageUrl(resultSet.getString(6));
              product.setStoreId(resultSet.getInt(7));

              list.add(product);
            }
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          db.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return list;
    }

    @Override
    public List<Product> getProductsByStoreId(int storeId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
