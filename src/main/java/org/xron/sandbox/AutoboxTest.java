// Author: Ben Page [ug73bxp] 
package org.xron.sandbox;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class AutoboxTest {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(2);
    print(list);
    list.remove(2);
    print(list);
    Integer i = new Integer(40);
    list.remove(i);
    print(list);
  }

  static void print(List l) {
    System.out.println("----");
    for (Object o : l) {
      System.out.println(o);
    }
  }

}
