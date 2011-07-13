// Author: Ben Page [ug73bxp] 
package org.xron.math;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class MinMax {

    double min;
    double max;
    private boolean fresh;

    public MinMax() {
        min = Double.MAX_VALUE;
        max = Double.MIN_VALUE;
        fresh = true;
    }

    public MinMax(double num) {
        this.min = num;
        this.max = num;
        fresh = false;
    }

    public MinMax(MinMax mm) {
        this.min = mm.getMin();
        this.max = mm.getMax();
        fresh = false;
    }

    public void add(double num) {
        if (fresh) {
            this.min = num;
            this.max = num;
            fresh = false;
        } else {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
    }

    public double getMax() {
        if(fresh) throw new IllegalStateException("Can't get when fresh");
        return max;
    }

    public double getMin() {
        if(fresh) throw new IllegalStateException("Can't get when fresh");
        return min;
    }

    public double getRange() {
        if(fresh) throw new IllegalStateException("Can't get when fresh");
        return max - min;
    }

    @Override
    public String toString() {
        if (isFresh()) {
            return "MinMax: [fresh]";
        } else {
            return "Min: " + min + "\tMax: " + max;
        }
    }

    /**
     * Returns true when no elements have been added to the MinMax
     * @return
     */
    public boolean isFresh() {
        return fresh;
    }

    public void reset(){
        min = Double.MAX_VALUE;
        max = Double.MIN_VALUE;
        fresh = true;
    }
}
