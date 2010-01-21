/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xron.debug;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author ben
 */
public class ArrayViewer {

    public static void renderBool(boolean[][] bool) {
        Image img = new BufferedImage(bool.length, bool[0].length, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = img.getGraphics();
        for (int x = 0; x < bool.length; x++) {
            boolean[] bs = bool[x];
            for (int y = 0; y < bs.length; y++) {
                if(bool[x][y]){
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(x, y, 1, 1);
            }
        }

        ImageViewer.show(img);
    }
}
