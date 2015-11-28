package org.xron.debug;

import java.io.PrintStream;
import java.util.List;

/**
 * @author ben
 */
public class ArrayPrinter {

  static PrintStream out = System.out;

  public static void printInt(int[] arr) {
    if (arr == null) {
      System.out.println("null");
    } else {
      out.println(arr.length + " elements:");
      for (int i = 0; i < arr.length; i++) {
        out.println("\t" + i + ": " + arr[i]);
      }
    }
  }

  public static void printInts(int... arr) {
    out.println(arr.length + " elements:");
    for (int i = 0; i < arr.length; i++) {
      out.println("\t" + i + ": " + arr[i]);
    }
  }

  public static void printFloat(float[] arr) {
    if (arr == null) {
      System.out.println("null");
    } else {
      out.println(arr.length + " elements:");
      for (int i = 0; i < arr.length; i++) {
        out.println("\t" + i + ": " + arr[i]);
      }
    }
  }

  public static void printFloats(float... arr) {
    out.println(arr.length + " elements:");
    for (int i = 0; i < arr.length; i++) {
      out.println("\t" + i + ": " + arr[i]);
    }
  }

  public static void printObject(Object[] arr) {
    if (arr == null) {
      System.out.println("null");
    } else {
      out.println(arr.length + " elements:");
      for (int i = 0; i < arr.length; i++) {
        out.println("\t" + i + ": " + arr[i]);
      }
    }
  }

  public static void printObjects(Object... arr) {
    out.println(arr.length + " elements:");
    for (int i = 0; i < arr.length; i++) {
      out.println("\t" + i + ": " + arr[i]);
    }
  }

  public static void useStdOut() {
    out = System.out;
  }

  public static void useStdErr() {
    out = System.err;
  }

  public static void useStream(PrintStream x) {
    out = x;
  }

  public static String listToString(List x) {
    StringBuilder sb = new StringBuilder('[');
    for (Object o : x) {
      sb.append(o).append(", ");
    }
    sb.delete(sb.length() - 2, sb.length());
    sb.append(']');

    return sb.toString();
  }
}
