package org.xron.game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GameFrame extends JFrame {


  public GameFrame(GamePanel panel) {
    super("GameFrame Template (c) Ben Page");
    initialize(panel);
  }

  private void initialize(GamePanel panel) {
    add(panel);

    addKeyListener(panel);

//        // Attempt at FSEM
//        GraphicsDevice gd =
//                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//        System.out.println("FULLSCREEN? : " + gd.isFullScreenSupported() );
//        setUndecorated(true);
//        gd.setFullScreenWindow(this);
//        DisplayMode dm = gd.getDisplayMode();
////        System.out.println("CHANGE?" + gd.isDisplayChangeSupported());
//        //DisplayMode newDM = new DisplayMode(Settings.HEIGHT, Settings.WIDTH, 1, 60);
//        //gd.setDisplayMode(newDM);
////	System.out.println("After display mode.......................");


    addWindowListener(new WindowAdapter() {

      @Override
      public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        System.exit(0);
        // Window is closing, do something!
      }
    });


    pack();

    setVisible(true);
//        setResizable(false);
  }

//    @Override
//    protected void finalize() throws Throwable {
////        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
//    }
//
//    @Override
//    public void dispose() {
////        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
//        super.dispose();
//    }
}