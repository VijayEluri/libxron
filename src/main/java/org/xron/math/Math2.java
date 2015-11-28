// Author: Ben Page [ug73bxp] 
package org.xron.math;

/**
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class Math2 {

  /**
   * Simple gaussian function
   *
   * @param x input
   * @returns the value of 0-centred gaussian at that point
   */
  public static double gaussian(double x) {
    return java.lang.Math.exp(-x * x);
  }
}
