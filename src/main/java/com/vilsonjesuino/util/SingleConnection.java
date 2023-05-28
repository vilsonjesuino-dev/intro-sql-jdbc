package com.vilsonjesuino.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
  
  private static String url = "jdbc:postgresql://localhost:5432/introsqljdbc";
  private static String user = "postgres";
  private static String password = "admin";
  private static Connection conn = null;

  static {
    conectar();
  }

  public SingleConnection() {
    conectar();
  }

  private static void conectar() {
    try {
      if (conn == null) {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, user, password);
        conn.setAutoCommit(false);
        //System.out.println("Connection Sucess!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    return conn;
  }
}
