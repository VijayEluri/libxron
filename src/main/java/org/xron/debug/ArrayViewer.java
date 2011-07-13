/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xron.debug;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author ben
 */
public class ArrayViewer {

    public static void showBool(boolean[][] bool) {
        System.out.println(bool.length + "x" + bool[0].length);
        ImageViewer.show(renderBool(bool));
    }

    public static BufferedImage renderBool(boolean[][] bool) {
        return renderBool(bool, Color.BLACK, Color.WHITE);
    }

    public static BufferedImage renderBool(boolean[][] bool, Color _true, Color _false) {
        BufferedImage img = new BufferedImage(bool.length, bool[0].length, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = img.getGraphics();
        for (int x = 0; x < bool.length; x++) {
            boolean[] col = bool[x];
            for (int y = 0; y < col.length; y++) {
                if (bool[x][y]) {
//                    g.setColor(_true);
                    img.setRGB(x, y, _true.getRGB());
                } else {
//                    g.setColor(_false);
                    img.setRGB(x, y, _false.getRGB());
                }
//                g.fillRect(x, y, 1, 1);
//                img.setRGB(x, y, Color.BLACK.getRGB());
            }
        }
        return img;
    }
}
