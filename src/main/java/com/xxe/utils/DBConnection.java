package com.xxe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

// JDBC: Java Database Connectivity
public class DBConnection {
  
  private Connection connection;
  private String username = "root";
  private String password;
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

  public void connect() throws SQLException, SQLTimeoutException {
    connection = DriverManager.getConnection(getConnectionString(username, password));
    System.out.println("Connection made.");
  }

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

  public Connection getConnection() {
    return connection;
  }

  public void close() throws SQLException {
    connection.close();
  }
}

