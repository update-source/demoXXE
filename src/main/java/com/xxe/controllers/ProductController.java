package com.xxe.controllers;

import java.io.IOException;
import java.util.List;

import com.xxe.dao.ProductDAO;
import com.xxe.dao.implement.ProductDAOImpl;
import com.xxe.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      ProductDAO dao = new ProductDAOImpl();
      List<Product> products = dao.getAllProducts();

      response.setContentType("text/plain;charset=UTF-8");
      response.getWriter().print(products);
    } catch (RuntimeException e) {
      e.printStackTrace();
      Throwable rootCause = e;
      while (rootCause.getCause() != null) {
        rootCause = rootCause.getCause();
      }
      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
          "Database error: " + rootCause.getClass().getSimpleName() + ": " + rootCause.getMessage());
    }

  }
}
