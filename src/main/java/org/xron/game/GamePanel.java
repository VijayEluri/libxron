package org.xron.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener, Runnable {

  final public static int UP_KEY = 0, DOWN_KEY = 1, LEFT_KEY = 2, RIGHT_KEY = 3;
  /**
   * time that one frame should occur = 1 000 000 000/FPS (ms in a second/FPS).
   * Keep above around 18 for best compatibility with Windows.
   */
  private static final long period = 1000000000 / 10;
  /**
   * Number of iterations without any sleep till the anim loop will yeild
   */
  private static final int NO_DELAYS_TIL_YIELD = 10;
  /**
   * Number of dropped frames since start of game
   */
  long dropped = 0;
  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc=" FPS COUNTER CODE ">
  // used for gathering statistics
  int framesSoFar = 0;
  long timeAtLastPeriod = 0;
  int FPSperiod = 30;
  double max = 1;
  private boolean[] keyStates = new boolean[4];
  private boolean paused = false;
  private long frameNo = 0;
  private int panelWidth;
  private int panelHeight;
  // <editor-fold defaultstate="collapsed" desc=" Thread Driven Animation Fields ">
  private boolean running = false;   // is the game running?
  // global variables for off-screen double buffer rendering
  private Graphics dbg;
  private Image dbImage = null;
  private int MAX_FRAME_SKIPS = 5;
  private Thread animator;//
  /**
   * Has this panel recieved its tank yet?
   */
  private boolean hasTank = false;
  private boolean endGameDrawn = false;
  //private int period;       // period between drawing in _ms_
  // i.e. the time requested for one frame iteration
  private Model m;
// </editor-fold>

  public GamePanel(Model theModel) {
    super();
    this.m = theModel;
    // Set up the game world here

    Dimension viewportSize = theModel.getViewportSize();
    panelWidth = viewportSize.width;
    panelHeight = viewportSize.height;
    this.setPreferredSize(viewportSize);

//        if (timerDriven) {
//            System.err.println("TIMER DRIVEN IS BAD!");
////            int timerPeriod = 5; // in ms (1000 / framerate)
////            timer = new Timer(timerPeriod, this);
////            System.out.println("Timer Driven Period of " + timerPeriod);
////            timer.start();
//        } else {
    //DoubleBuffer thing
    System.out.println("Thread driven!");
    animator = new Thread(this);
//        }


    addMouseListener(theModel);
    addMouseMotionListener(theModel);
    requestFocus();
  }

  void reportFPS() {
    framesSoFar++;
    if (framesSoFar == FPSperiod) {
      long timeNow = System.nanoTime();
      long timeForPeriod = timeNow - timeAtLastPeriod;
      long ONE_SECOND = 1000000000L;
      double x = ONE_SECOND / (double) timeForPeriod;

      //System.out.println(x * FPSperiod + " fps-ish");

      framesSoFar = 0;
      timeAtLastPeriod = timeNow;
    }
  }

  @Override
  public void addNotify() {
    super.addNotify();
    if (animator != null) {
      animator.start();
    } //else if (!timerDriven) {
//            throw new IllegalStateException("Thread Driven TankPanel without a thread!");
//        }
  }

  @Override
  public void paintComponent(Graphics g) {
//        if (timerDriven) {
//            super.paintComponent(g);
//
//            Graphics2D g2 = (Graphics2D) g;
//
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//
//
//            g2.setColor(Color.RED);
//
//            g2.draw(new Ellipse2D.Double(mouse.getX() - 5, mouse.getY() - 5, 10, 10));
//
//            reportFPS();
//        } else {
    paintScreen();
//        }
    //reportFPS();
  }

  /**
   * use active rendering to put the buffered image on-screen
   */
  private void paintScreen() {
    Graphics g;
    try {
      g = this.getGraphics();
      if ((g != null) && (dbImage != null)) {
        g.drawImage(dbImage, 0, 0, null);
      }
      Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
      g.dispose();
    } catch (Exception e) {
      System.err.println("Graphics error: " + e);
    }
//        reportFPS();
  }

  public void run() {
    long startTime, endTime, timeTaken, timeToSleep;
    long overSleepTime = 0L;
    int noDelays = 0;
    long excess = 0L;

    startTime = System.nanoTime();
    running = true;

    while (running) {
      update();
      render();
      paintScreen();
      endTime = System.nanoTime();
      timeTaken = endTime - startTime;
//            System.out.println("Time Taken:    " + timeTaken);
//            System.out.println("Period:        "+period);
//            System.out.println("Oversleep:     "+overSleepTime);
      timeToSleep = (period - timeTaken) - overSleepTime;
//            System.out.println("Time to Sleep: "+timeToSleep);
//            System.out.println("Larr:          "+ timeTaken+overSleepTime);
//            System.out.println();
      if (timeToSleep > 0) { // some time left in this cycle

        try {
          Thread.sleep(timeToSleep / 1000000L); // nano -> ms

        } catch (InterruptedException ex) {
          System.err.println("Sleep Interupted!");
        }
        overSleepTime =
          (System.nanoTime() - endTime) - timeToSleep;
      } else { // sleepTime <= 0; frame took longer than the period

        // Time to sleep is negative so excess becomes positive
        excess -= timeToSleep; // store excess time value
        overSleepTime = 0L;

        if (++noDelays >= NO_DELAYS_TIL_YIELD) {
          Thread.yield(); // give another thread a chance to run

          noDelays = 0;
        }

      }
      startTime = System.nanoTime();

            /* If frame animation is taking too long, update the game state
            without rendering it, to get the updates/sec nearer to
            the required FPS. */
      int skips = 0;
      while ((excess > period) && (skips < MAX_FRAME_SKIPS)) {
        excess -= period;
        update(); // update state but don't render
//                System.err.println("DROPPED " + dropped);
        ++dropped;
        ++skips;

      }

      if (skips > 0) {
        System.err.println("Dropped " + skips + "/" + MAX_FRAME_SKIPS);
      }
    }
    //System.exit(0);
  } // end of run()

  private void render() {
    if (dbImage == null) { // create the buffer
      dbImage = createImage(panelWidth, panelHeight);
      if (dbImage /* still */ == null) {
        // createImage failed!
        System.err.println("dbImage is null");
        return;
      }
    }

    dbg = dbImage.getGraphics();
    Graphics2D dbg2 = (Graphics2D) dbg;


    // Draw to dbg or dbg2, this is the buffer


    dbg.clearRect(0, 0, panelWidth, panelHeight);
    //FIXME: Did removing the magic +500 on each value above change anything?
//            dbg2.drawString("WELCOME TO FRAME "+frameNo, 70, 70);
    m.draw(dbg);
  }

  /**
   * Update the game state
   */
  private void update() {
    //TODO: INSERT LOGIC
    frameNo++;
    m.update();
  }

  // <editor-fold defaultstate="collapsed" desc="Events">
  public void keyTyped(KeyEvent e) {
    System.out.println("TYPED: " + e.getKeyChar());
  }

  public void keyPressed(KeyEvent e) {

    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT:
        keyStates[LEFT_KEY] = true;
        break;
      case KeyEvent.VK_RIGHT:
        keyStates[RIGHT_KEY] = true;
        break;
      case KeyEvent.VK_UP:
        keyStates[UP_KEY] = true;
        break;
      case KeyEvent.VK_DOWN:
        keyStates[DOWN_KEY] = true;
        break;
      default:
        System.out.println("PRESSED: " + e.getKeyText(e.getKeyCode()));
    }
  }

  public void keyReleased(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT:
        keyStates[LEFT_KEY] = false;
        break;
      case KeyEvent.VK_RIGHT:
        keyStates[RIGHT_KEY] = false;
        break;
      case KeyEvent.VK_UP:
        keyStates[UP_KEY] = false;
        break;
      case KeyEvent.VK_DOWN:
        keyStates[DOWN_KEY] = false;
        break;
      case KeyEvent.VK_ESCAPE:
        paused = !paused;
        break;
      default:
        System.out.println("RELEASED: " + e.getKeyText(e.getKeyCode()));
    }
  }
}
