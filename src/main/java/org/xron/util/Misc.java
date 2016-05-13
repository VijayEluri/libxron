/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xron.util;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Ben Page
 */
public class Misc {

  /**
   * Wrapper around Java's Thread.sleep(), ignores the exception thrown.
   *
   * @param millis the length of time to sleep in milliseconds.
   * @see java.lang.Thread#sleep(long)
   */
  public static void sleep2(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException x) {
      System.err.println("WARNING: Ignored InterruptedException in libxron:sleep2");
    }
  }

  /**
   * apply map to the _value_ of an entry in a map, instead of the entry
   *
   * return map of key to the new value
   */
  private <K, V, O> Map<K, O> mapTheValues(Map<K, V> map, Function<V, O> funct) {
    return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> funct.apply(e.getValue())));
  }

}
