package com.vilsonjesuino;

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
  
}
