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

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 *
 * @author a153691
 */
public class RollTest {

  public RollTest() {
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

  private static Roll r(int... values) {
    return new Roll() {
      @Override
      protected IntStream raw() {
        return Arrays.stream(values);
      }
    };
  }

  @Test
  public void testSum() {
    testSum(r(1, 2, 3), 6);
    testSum(r(2, 3, 4), 9);
    testSum(r(4), 4);
    testSum(r(19, 1), 20);
    testSum(r(9, 7, 9), 25);
    testSum(r(3, 6, 4), 13);
  }

  private void testSum(Roll roll, int expectedSum) {
    assertThat(roll.sum(), is(expectedSum));
  }

  @Test
  public void testMin() {
    testMin(r(1, 2, 3), 1);
    testMin(r(2, 3, 4), 2);
    testMin(r(4), 4);
    testMin(r(19, 1), 1);
    testMin(r(9, 7, 9), 7);
    testMin(r(3, 6, 4), 3);
  }

  private void testMin(Roll roll, int expectedMin) {
    assertThat(roll.min().sum(), is(expectedMin));
  }

}
