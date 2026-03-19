package com.xxe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

// JDBC: Java Database Connectivity
public class DBConnection {
  
  private Connection connection;
  private String username = "xxe";
  private String password = "@ChangeThIsP@ssW4rd";
  private String dbms = "mysql";
  private String host = "localhost";
  private String port = "3306";

  public DBConnection() {

  }

  public DBConnection(String password) {
    this.password = password;
  }

  public DBConnection(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public DBConnection(String username, String password, String dbms, String host, String port) {
    this.username = username;
    this.password = password;
    this.dbms = dbms;
    this.host = host;
    this.port = port;
  }

  /** 
   * @throws SQLException
   * @throws SQLTimeoutException
   */
  public void connect() throws SQLException, SQLTimeoutException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new SQLException("MySQL JDBC Driver not found in runtime classpath", e);
    }
    connection = DriverManager.getConnection(getConnectionString(username, password));
    System.out.println("Connection made.");
  }

  /** 
   * @param username
   * @param password
   * @return String
   */
  private String getConnectionString(String username, String password) {
    StringBuilder strBuiler = new StringBuilder();
    strBuiler.append("jdbc:");
    strBuiler.append(dbms);
    strBuiler.append("://");
    strBuiler.append(host);
    strBuiler.append(":");
    strBuiler.append(port);
    strBuiler.append("/?");
    strBuiler.append("user=");
    strBuiler.append(username);
    strBuiler.append("&password=");
    strBuiler.append(password);
    strBuiler.append("&serverTimezone=UTC");
    return strBuiler.toString();
  }

  /** 
   * @return Connection
   */
  public Connection getConnection() {
    return connection;
  }

  /** 
   * @throws SQLException
   */
  public void close() throws SQLException {
    if (connection != null) {
      connection.close();
    }
  }

  /** 
   * @param args
   */
  //Implement main for debug
  public static void main(String[] args) {
    DBConnection db = new DBConnection();
    try {
      db.connect();
      Connection con = db.getConnection();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    } finally {
      try {
        db.close();
      } catch (SQLException e) {
        System.err.println(e.getMessage());
      }
    }
  }
}

