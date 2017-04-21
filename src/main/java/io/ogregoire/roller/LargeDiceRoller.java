/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ogregoire.roller;

import java.math.RoundingMode;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author a153691
 */
class LargeDiceRoller implements Roller {

  private final int quantity;
  private final int faces;
  private final double mean;
  private final double variance;
  private final double standardDeviation;

  LargeDiceRoller(int quantity, int faces) {
    this.quantity = quantity;
    this.faces = faces;
    this.mean = (faces + 1.0d) * quantity / 2.0d;
    this.variance = quantity * (faces * faces - 1) / 12.0;
    this.standardDeviation = Math.sqrt(this.variance);
    System.out.printf("quantity:   %.2f%n",(double)quantity);
    System.out.printf("faces:      %.2f%n",(double)faces);
    System.out.printf("mean:       %.2f%n",mean);
    System.out.printf("variance:   %.2f%n",variance);
    System.out.printf("stdDev:     %.2f%n",standardDeviation);
  }

  @Override
  public Roll roll(Random random) {
    double g = random.nextGaussian();
    int value = (int)(g * standardDeviation + mean);
    return new Roll.Unique(value);
  }

  @Override
  public String toString() {
    return quantity + "d" + faces;
  }

  public static void main(String[] args) {
    Random random = new Random();
    int quantity = 100, faces = 6; // 100d6
    double mean = (faces + 1) * quantity / 2.0d;
    double stdDev = Math.sqrt(quantity * (faces * faces - 1) / 12.0);
    
    System.out.printf("quantity:   %.2f%n", (double)quantity);
    System.out.printf("faces:      %.2f%n", (double)faces);
    System.out.printf("mean:       %.2f%n", mean);
    System.out.printf("stdDev:     %.2f%n", stdDev);
    
    Map<Integer, AtomicInteger> rolls = new TreeMap<>();
    
    for (int rollCount = 0; rollCount < 100_000_000; rollCount++) {
      int roll = (int)Math.round(random.nextGaussian() * stdDev + mean);
      rolls.computeIfAbsent(roll, x -> new AtomicInteger()).incrementAndGet();
    }
    
    rolls.entrySet().forEach(e -> {
      System.out.printf("%3d: %7d%n", e.getKey(), e.getValue().get());
    });
  }
  
  
}
