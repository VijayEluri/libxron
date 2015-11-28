package org.xron.util;

import java.util.Iterator;

/**
 * This is an infinite iterator
 *
 * @author Ben Page
 */
public class InfinitelyEvenSequence implements Iterator<Double> {

  final double GOLDEN_RATIO_CONJUGATE = 0.618033988749895;

  double currVal;

  public InfinitelyEvenSequence() {
    this(0);
  }

  public InfinitelyEvenSequence(double currVal) {
    this.currVal = currVal;
  }

  /**
   * This sequence is infinite
   *
   * @returns always true
   */
  public boolean hasNext() {
    return true;
  }

  public Double next() {
    double nextVal = currVal;
    currVal += GOLDEN_RATIO_CONJUGATE;
    currVal %= 1;
    return nextVal;
  }

  /**
   * Removing is a nonsense operator for this sequence.
   */
  public void remove() {
    throw new UnsupportedOperationException("Operation not supported.");
  }


}
