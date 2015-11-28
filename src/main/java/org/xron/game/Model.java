/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.xron.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

/**
 * @author ben
 */
public abstract class Model extends MouseAdapter {

  abstract public void draw(Graphics g);

  abstract public void update();

  /**
   * @return requested size of the window
   */
  //TODO: make this abstract
  public Dimension getViewportSize() {
    return new Dimension(640, 480);
  }

}
