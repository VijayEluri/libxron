// Author: Ben Page [ug73bxp] 
package org.xron.search;

import java.util.List;
import java.util.TreeSet;

/**
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class BestFirstAgenda<K extends AgendaElement> implements Agenda<K> {

  private final AgendaElement goal;
  private TreeSet<K> agenda;

  //TODO: The Tree set needs to be ordered according to how close
  //      to 'goal' each element in the agenda is.

  public BestFirstAgenda(AgendaElement goal) {
    agenda = new TreeSet<K>();
    this.goal = goal;
  }

  /**
   * Best first agenda makes sure each element added to the array is added
   *
   * @param toAdd
   */
  @Override
  public void add(K... toAdd) {
    // Add array elems to list
    for (K x : toAdd) {
      agenda.add(x);
    }

//        Collections.sort(agenda);
  }

  @Override
  public void addAll(List<K> toAdd) {
    agenda.addAll(toAdd);
  }

  @Override
  public K peek() {
    return agenda.first();
  }

  @Override
  public K pop() {
    return agenda.pollFirst();
  }

  @Override
  public int size() {
    return agenda.size();
  }

  @Override
  public boolean isEmpty() {
    return agenda.isEmpty();
  }
}