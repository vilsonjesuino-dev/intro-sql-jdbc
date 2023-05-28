package com.vilsonjesuino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

  public List<UserPosJava> listar() {
    List<UserPosJava> lista = new ArrayList<UserPosJava>();
    String sql = "SELECT * FROM userposjava";

    try {
      PreparedStatement statement = conn.prepareStatement(sql);
      ResultSet resultado = statement.executeQuery();

      while (resultado.next()) {
        UserPosJava userPosJava = new UserPosJava();
        userPosJava.setId(resultado.getLong("id"));
        userPosJava.setNome(resultado.getString("nome"));
        userPosJava.setEmail(resultado.getString("email"));
        
        lista.add(userPosJava);
      }


    } catch (Exception e) {
      e.printStackTrace();
    }

    return lista;
  }

  public UserPosJava buscar(Long id) {
    UserPosJava retorno = new UserPosJava();
    String sql = "SELECT * FROM userposjava WHERE id = " + id;

    try {
      PreparedStatement statement = conn.prepareStatement(sql);
      ResultSet resultado = statement.executeQuery();

      while (resultado.next()) {
        retorno.setId(resultado.getLong("id"));
        retorno.setNome(resultado.getString("nome"));
        retorno.setEmail(resultado.getString("email")); 
      }


    } catch (Exception e) {
      e.printStackTrace();
    }

    return retorno;
  }
}
