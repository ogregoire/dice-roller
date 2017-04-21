/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ogregoire.roller;

import java.util.Random;

/**
 *
 * @author a153691
 */
class DiceRoller implements Roller {

  private final int quantity;
  private final int faces;

  DiceRoller(int quantity, int faces) {
    this.quantity = quantity;
    this.faces = faces;
  }

  @Override
  public Roll roll(Random random) {
    if (random == null) {
      throw new NullPointerException();
    }
    int[] rolls = new int[quantity];
    for (int i = 0; i < quantity; i++) {
      rolls[i] = random.nextInt(faces) + 1;
    }
    return new Roll.Multiple(rolls);
  }

}
