package com.vilsonjesuino;

import java.util.List;

import org.junit.Test;

import com.vilsonjesuino.dao.UserPosJavaDao;
import com.vilsonjesuino.model.UserPosJava;

public class TestPosJava {

  @Test
  public void salvar() {

    UserPosJava userPosJava = new UserPosJava();
    userPosJava.setId(2L);
    userPosJava.setNome("Pedro");
    userPosJava.setEmail("pedro@gmail.com");

    UserPosJavaDao userPosJavaDao = new UserPosJavaDao();
    userPosJavaDao.salvar(userPosJava);
  }

  @Test
  public void listar() {
    UserPosJavaDao dao = new UserPosJavaDao();

    try {
      List<UserPosJava> listar = dao.listar();

      for (UserPosJava userPosJava : listar) {
        System.out.println(userPosJava);
        System.out.println("---------------------------");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void buscar() {
    UserPosJavaDao dao = new UserPosJavaDao();

    try {

      UserPosJava userPosJava = dao.buscar(1L);
      System.out.println(userPosJava);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void atualizar() {
    UserPosJavaDao dao = new UserPosJavaDao();

    try {

      UserPosJava objetoBanco = dao.buscar(1L);
      System.out.println(objetoBanco);
      System.out.println("------------------------");

      objetoBanco.setNome("Pedro Andrade");
      dao.atualizar(objetoBanco);

      System.out.println(objetoBanco);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
