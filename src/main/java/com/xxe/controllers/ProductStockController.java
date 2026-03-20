package com.xxe.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.xxe.dao.implement.StockDAOImpl;
import com.xxe.services.implement.StockServiceImpl;
import com.xxe.utils.XMLUtils;
import com.xxe.utils.XmlParseProfile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
  "Check stock" feature that parses XML input 
  and returns any unexpected values in the response.
*/
@WebServlet("/product/stock")
public class ProductStockController extends HttpServlet {

  /** 
   * Get the quantity from StoreId and ProductId
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String contentType = request.getContentType();
    if (contentType == null || !(contentType.contains("application/xml") || contentType.contains("text/xml"))) {
      response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Content-Type must be application/xml or text/xml.");
      return;
    }
    //file:///C:/Windows/System32/drivers/etc/hosts
    try (BufferedReader reader = request.getReader()) {
      XmlParseProfile profile = XmlParseProfile.DEFAULT;
      Document doc = XMLUtils.parseXml(reader, profile);
      int productId = XMLUtils.toInteger(XMLUtils.getContentsByTagName(doc, "productId"));
      int storeId = XMLUtils.toInteger(XMLUtils.getContentsByTagName(doc, "storeId"));
      int quantity = new StockServiceImpl().getStockQuantity(productId, storeId);

      response.setContentType("text/plain");

      PrintWriter out = response.getWriter();
      out.print(quantity);
      out.flush();
    } catch (NumberFormatException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID or store ID: "  + e.getMessage());
    } catch (SAXException | IllegalArgumentException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error.");
    }
  }
  /** 
   * Overide the quantity from StoreId and ProductId
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String contentType = request.getContentType();
    if (contentType == null || !(contentType.contains("application/xml") || contentType.contains("text/xml"))) {
      response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Content-Type must be application/xml or text/xml.");
      return;
    }

    try (BufferedReader reader = request.getReader()) {
      XmlParseProfile profile = XmlParseProfile.OOB_GENERAL;
      Document doc = XMLUtils.parseXml(reader, profile);
      int productId = XMLUtils.toInteger(XMLUtils.getContentsByTagName(doc, "productId"));
      int storeId = XMLUtils.toInteger(XMLUtils.getContentsByTagName(doc, "storeId"));
      int quantity = XMLUtils.toInteger(XMLUtils.getContentsByTagName(doc, "quantity"));

      new StockDAOImpl().setStockQuantity(productId, storeId, quantity);

      response.setContentType("text/plain");

      PrintWriter out = response.getWriter();
      out.print("Success");
      out.flush();
    } catch (NumberFormatException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error");
    } catch (SAXException | IllegalArgumentException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error");
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error");
    }
  }
  
  /** 
   * Delete the stocck from StoreId and ProductId
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String contentType = request.getContentType();
    if (contentType == null || !(contentType.contains("application/xml") || contentType.contains("text/xml"))) {
      response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Content-Type must be application/xml or text/xml.");
      return;
    }

    try (BufferedReader reader = request.getReader()) {
      XmlParseProfile profile = XmlParseProfile.OOB_PARAMETER_ONLY;
      Document doc = XMLUtils.parseXml(reader, profile);
      int productId = XMLUtils.toInteger(XMLUtils.getContentsByTagName(doc, "productId"));
      int storeId = XMLUtils.toInteger(XMLUtils.getContentsByTagName(doc, "storeId"));

      new StockDAOImpl().deleteStock(productId, storeId);

      response.setContentType("text/plain");

      PrintWriter out = response.getWriter();
      out.print("Success");
      out.flush();
    } catch (NumberFormatException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error");
    } catch (SAXException | IllegalArgumentException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error");
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error");
    }
  }
}