package org.xron.util;

/**
 * New object starts timing (or reset) stop stops the time
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class Stopwatch {

    long startTime;
    long stopTime;

    public Stopwatch() {
        reset();
    }

    public void start() {
        reset();
    }

    public void stop() {
        stopTime = System.currentTimeMillis();
    }

    public void reset() {
        startTime = System.currentTimeMillis();
        stopTime = startTime;
    }

    public long getMillis() {
        return stopTime - startTime;
    }

    public float getSeconds() {
        return (stopTime - startTime) / 1000f;
    }
}
