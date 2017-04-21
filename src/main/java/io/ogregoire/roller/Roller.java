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
@FunctionalInterface
public interface Roller {

  static Roller dice(int quantity, int faces) {
    return new DiceRoller(quantity, faces);
  }
  
  default Roller plus(Roller roller) {
    return new PlusRoller(this, roller);
  }

  Roll roll(Random random);
}
