/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ogregoire.roller;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author a153691
 */
public abstract class Roll {

  Roll() {
  }

  protected abstract IntStream raw();

  public int sum() {
    return raw().sum();
  }

  public Roll min() {
    return new Unique(raw().min().getAsInt());
  }

  public Roll max() {
    return new Unique(raw().max().getAsInt());
  }

  public Roll lowest(int n) {
    if (n < 1) {
      throw new IllegalArgumentException();
    } else if (n == 1) {
      return min();
    } else {
      return new Multiple(raw().sorted().limit(n));
    }
  }

  public Roll highest(int n) {
    if (n < 1) {
      throw new IllegalArgumentException();
    } else if (n == 1) {
      return min();
    } else {
      return new Multiple(raw().map(i -> ~i).sorted().map(i -> ~i).limit(n));
    }
  }

  static class Multiple extends Roll {

    private final int[] values;

    Multiple(int[] values) {
      this.values = values;
    }

    Multiple(IntStream raw) {
      values = raw.toArray();
    }

    @Override
    protected IntStream raw() {
      return Arrays.stream(values);
    }

  }

  static class Unique extends Roll {

    private final int value;

    Unique(int value) {
      this.value = value;
    }

    @Override
    protected IntStream raw() {
      return IntStream.of(value);
    }

    @Override
    public Roll min() {
      return this;
    }

    @Override
    public Roll max() {
      return this;
    }

  }
}
