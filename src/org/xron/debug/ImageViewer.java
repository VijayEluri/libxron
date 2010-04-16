/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.xron.debug;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import org.xron.game.GameFrame;
import org.xron.game.GamePanel;
import org.xron.game.Model;

/**
 *
 * @author ben
 */
public class ImageViewer extends Model {

    private final Image image;
    private final int width;
    private final int height;

    public ImageViewer(Image x) {
        image = x;
        width = x.getWidth(null);
        height = x.getHeight(null);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void update() {
        // No update
    }

    public void show(){
        new GameFrame(new GamePanel(this));
    }

    public static void show(Image i){
        new ImageViewer(i).show();
    }

    @Override
    public Dimension getViewportSize() {
        return new Dimension(width, height);
    }





}
