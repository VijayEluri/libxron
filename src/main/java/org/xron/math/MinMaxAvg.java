// Author: Ben Page [ug73bxp] 
package org.xron.math;

/**
 * Keeps track of the min/max/average for every thing that is passed to it.
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class MinMaxAvg extends MinMax {

  double sum;
  int numElems;

  @Override
  public void add(double num) {
    super.add(num);
    sum += num;
    numElems++;
  }

  public double getAvg() {
    return sum / numElems;
  }

  public double getSum() {
    return sum;
  }

  @Override
  public String toString() {
    return super.toString() + "\tSum: " + getSum() + "\tAvg: " + getAvg();
  }


}
