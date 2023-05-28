package com.vilsonjesuino;

import org.junit.Test;

import com.vilsonjesuino.util.SingleConnection;

public class TestConnection {

  @Test
  public void init() {
    SingleConnection.getConnection();
  }
}
