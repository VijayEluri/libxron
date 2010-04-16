// Author: Ben Page [ug73bxp] 
package org.xron.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class Renderer {

    /**
     *
     * @param x
     * @param y
     * @param theta
     * @param r
     * @param c color
     * @param g graphics
     */
    public static void drawPoint(int x, int y, double theta, int r, Color c, Graphics g) {
        g.setColor(c);
        g.drawOval(x - r, y - r, r * 2, r * 2);

//            // Draw a cross in the circle
//            int crossWidth = 2; //RADIUS /3
//            g.drawLine(gx - crossWidth, gy + crossWidth, gx + crossWidth, gy - crossWidth);
//            g.drawLine(gx - crossWidth, gy - crossWidth, gx + crossWidth, gy + crossWidth);

        // Draw a line that shows heading from speed
//        g.drawLine(x, y, (int) (x + (vel.getX() / getSpeed()) * 3), (int) (y + (vel.getY() / getSpeed()) * 3));

        // Draw a line that shows heading
        r += r;
        g.drawLine(x, y, (int) (x + Math.cos(theta) * r), (int) (y + Math.sin(theta) * r));
    }

    public static void mark(int x, int y, Color c, Graphics g) {
        g.setColor(c);
        int r = 4;
        g.drawOval(x - r, y - r, r * 2, r * 2);

        // Draw a cross in the circle
        int crossWidth = r;
        g.drawLine(x - crossWidth, y + crossWidth, x + crossWidth, y - crossWidth);
        g.drawLine(x - crossWidth, y - crossWidth, x + crossWidth, y + crossWidth);
    }
}
