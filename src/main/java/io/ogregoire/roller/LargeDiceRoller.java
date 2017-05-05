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
class LargeDiceRoller implements Roller {

  final int quantity;
  final int faces;
  private final double mean;
  private final double standardDeviation;

  LargeDiceRoller(int quantity, int faces) {
    this.quantity = quantity;
    this.faces = faces;
    this.mean = (faces + 1) * quantity / 2.0d;
    this.standardDeviation = Math.sqrt(quantity * (faces * faces - 1) / 12.0d);
  }

  @Override
  public Roll roll(Random random) {
    double g = random.nextGaussian();
    int value = (int)Math.round(g * standardDeviation + mean);
    return new Roll.Aggregate(value);
  }

  @Override
  public String toString() {
    return quantity + "d" + faces;
  }
}
