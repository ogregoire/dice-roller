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

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author a153691
 */
public class DiceRollerTest {

  public DiceRollerTest() {
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
   * Test of roll method, of class DiceRoller.
   */
  @Test
  public void testRoll() {
    DiceRoller roller;
    Roll roll;

    roller = new DiceRoller(2, 6);
    roll = roller.roll(random(0, 1));
    assertThat(roll.sum(), is(3));

    roller = new DiceRoller(2, 20);
    roll = roller.roll(random(0, 1));
    assertThat(roll.sum(), is(3));

  }

  private Random random(Integer first, Integer... rest) {
    Random random = mock(Random.class);
    when(random.nextInt(anyInt())).thenReturn(first, rest);
    return random;
  }

}
