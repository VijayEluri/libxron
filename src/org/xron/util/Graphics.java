/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.xron.util;

import java.awt.Color;

/**
 *
 * @author ben
 */
public class Graphics {


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
