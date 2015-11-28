// Author: Ben Page [ug73bxp] 
package org.xron.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This is really a template, no need to extend it just copy paste?
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class XListener implements KeyListener, MouseListener {

  public void keyTyped(KeyEvent e) {
    System.out.println("KeyTyped:" + e.getKeyText(e.getKeyCode()));
  }

  public void keyPressed(KeyEvent e) {
    System.out.println("KeyPressed: " + KeyEvent.getKeyText(e.getKeyCode()));
  }

  public void keyReleased(KeyEvent e) {
    System.out.println("KeyReleased: " + KeyEvent.getKeyText(e.getKeyCode()));
  }

  private String mouseToString(MouseEvent e) {
    return "B" + e.getButton() + " " + e.getX() + "," + e.getY();
  }

  public void mouseClicked(MouseEvent e) {
    System.out.println("MouseClicked: " + mouseToString(e));
  }

  public void mousePressed(MouseEvent e) {
    System.out.println("MousePressed: " + mouseToString(e));
  }

  public void mouseReleased(MouseEvent e) {
    System.out.println("MouseReleased: " + mouseToString(e));
  }

  public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
  }

  public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
  }
}
