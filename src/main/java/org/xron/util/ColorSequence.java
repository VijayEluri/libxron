package org.xron.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import org.xron.game.GameFrame;
import org.xron.game.GamePanel;
import org.xron.game.Model;
import org.xron.game.Renderer;

/**
 *
 * @author Ben Page 
 */
public class ColorSequence {

    InfinitelyEvenSequence seq;
    final float saturation;
    final float value;

    public ColorSequence(float saturation, float value) {
        seq = new InfinitelyEvenSequence();
        this.saturation = saturation;
        this.value = value;
    }

    public ColorSequence() {
        this(0.5f,0.95f);
    }

    public Color getColor() {
        double currHue = seq.next();
        return org.xron.util.Graphics.HSVtoRGB((float) currHue, saturation, value);
    }

    /**
     * Test for ColorSequence.  Draws a grid of 'randomly' coloured
     * @param args
     */
    public static void main(String[] args) {
        final ColorSequence seq = new ColorSequence();

        GameFrame gf = new GameFrame(new GamePanel(new Model() {

            LinkedList<Point> points = new LinkedList<Point>();
            LinkedList<Color> colors = new LinkedList<Color>();
            int xstep = 12;

            @Override
            public void draw(Graphics g) {
                for (int i = 0; i < points.size(); i++) {
                    Point p = points.get(i);
                    final int cols = 53;
                    int row = (int) i / cols;
                    Renderer.filledMark((i % cols * xstep) + 6, (12 * row) + 6, colors.get(i), g);
                }
            }

            @Override
            public void update() {
                points.add(new Point((int) (Math.random() * 640), (int) (Math.random() * 480)));
                colors.add(seq.getColor());
            }
        }));
    }
}
