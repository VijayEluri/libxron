/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xron.util;

import java.awt.Color;

/**
 *
 * @author Ben Page
 */
public class Misc {

    /**
     * Wrapper around Java's Thread.sleep(), ignores the exception thrown.
     *
     * @param      millis   the length of time to sleep in milliseconds.
     * @see        java.lang.Thread#sleep(long)
     */
    public static void sleep2(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException x) {
            System.err.println("WARNING: Ignored InterupptedException in libxron:sleep2");
        }
    }

    /**
     * 
     * @param c color to alpharize
     * @param alpha 0--1 percentage of alpha
     * @return
     */
    public static Color alpharize(Color c, float alpha) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), (int) (alpha * 255));
    }
}
