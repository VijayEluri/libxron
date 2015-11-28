package org.xron.util;

import java.awt.Color;

/**
 * @author ben
 */
public class Graphics {

  /**
   * @param c     color to alpharize
   * @param alpha 0--1 percentage of alpha
   * @return
   */
  public static Color alpharize(Color c, float alpha) {
    return new Color(c.getRed(), c.getGreen(), c.getBlue(), (int) (alpha * 255));
  }

  public static Color HSVtoRGB(float hue, float saturation, float value) {
    float[] rgb = new float[3];

    // Borrowed from  http://hg.openjdk.java.net/jdk7/jsn/jdk›src›share›classes›javax›swing›colorchooser›ColorModelHSV.java
    rgb[0] = value;
    rgb[1] = value;
    rgb[2] = value;

    if (saturation > 0.0f) {
      hue = (hue < 1.0f) ? hue * 6.0f : 0.0f;
      int integer = (int) hue;
      float f = hue - (float) integer;
      switch (integer) {
        case 0:
          rgb[1] *= 1.0f - saturation * (1.0f - f);
          rgb[2] *= 1.0f - saturation;
          break;
        case 1:
          rgb[0] *= 1.0f - saturation * f;
          rgb[2] *= 1.0f - saturation;
          break;
        case 2:
          rgb[0] *= 1.0f - saturation;
          rgb[2] *= 1.0f - saturation * (1.0f - f);
          break;
        case 3:
          rgb[0] *= 1.0f - saturation;
          rgb[1] *= 1.0f - saturation * f;
          break;
        case 4:
          rgb[0] *= 1.0f - saturation * (1.0f - f);
          rgb[1] *= 1.0f - saturation;
          break;
        case 5:
          rgb[1] *= 1.0f - saturation;
          rgb[2] *= 1.0f - saturation * f;
          break;
      }
    }
    // end borrowed
    return new Color(rgb[0], rgb[1], rgb[2]);
  }
}
