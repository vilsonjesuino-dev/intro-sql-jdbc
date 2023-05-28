package com.vilsonjesuino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vilsonjesuino.model.UserPosJava;
import com.vilsonjesuino.util.SingleConnection;

public class UserPosJavaDao {
  
  private Connection conn;

  public UserPosJavaDao() {
    conn = SingleConnection.getConnection();
  }

  public void salvar(UserPosJava userPosJava) {

    String sql = "INSERT INTO userposjava (id, nome, email) VALUES (?, ?, ?)";

    try {
      
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setLong(1, userPosJava.getId());
      statement.setString(2, userPosJava.getNome());
      statement.setString(3, userPosJava.getEmail());
      statement.execute();
      conn.commit();
      System.out.println("Salvo com sucesso!");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
