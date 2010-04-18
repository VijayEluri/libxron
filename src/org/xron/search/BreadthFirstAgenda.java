// Author: Ben Page [ug73bxp] 
package org.xron.search;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class BreadthFirstAgenda<K extends AgendaElement> implements Agenda<K> {

    private final ArrayList<K> agenda = new ArrayList<K>();

    public void add(K... toAdd) {
        for (K x : toAdd) {
            agenda.add(x);
        }
    }

    public void addAll(List<K> toAdd) {
        for (K x : toAdd) {
            agenda.add(x);
        }
    }

    public K peek() {
        return agenda.get(0);
    }

    public K pop() {
        K x = agenda.get(0);
        agenda.remove(x);
        return x;
    }

    public int size() {
        return agenda.size();
    }

    public boolean isEmpty() {
        return agenda.isEmpty();
    }
}
