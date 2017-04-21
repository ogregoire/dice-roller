/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ogregoire.roller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author a153691
 */
public class LargeDiceRollerTest {
  
  public LargeDiceRollerTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of roll method, of class LargeDiceRoller.
   */
  @Test
  public void testRoll() {
    Random r = new Random();
    LargeDiceRoller roller = new LargeDiceRoller(2, 6);
    Map<Integer,AtomicInteger> counts = new TreeMap<>();
    for(int i = 0; i < 100000; i++) {
      int roll = roller.roll(r).sum();
      counts.computeIfAbsent(roll, x -> new AtomicInteger()).incrementAndGet();
    }
    counts.entrySet().forEach(e -> {
      System.out.printf("%3d: %5d%n", e.getKey(), e.getValue().get());
          });
  }

  /**
   * Test of toString method, of class LargeDiceRoller.
   */
  @Test
  public void testToString() {
  }
  
}
