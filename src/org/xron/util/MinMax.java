// Author: Ben Page [ug73bxp] 
package org.xron.util;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class MinMax {

    double min;
    double max;

    public MinMax() {
        min = Double.MAX_VALUE;
        max = Double.MIN_VALUE;
    }

    public MinMax(double num) {
        this.min = num;
        this.max = num;
    }

    public void add(double num){
        max = Math.max(max, num);
        min = Math.min(min, num);
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    @Override
    public String toString() {
        return "Min: "+min+"\tMax: "+max;
    }


}
