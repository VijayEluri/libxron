// Author: Ben Page [ug73bxp] 
package org.xron.search;

import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class BestFirstAgenda implements Agenda {

    private TreeSet<AgendaElement> agenda;
    private final AgendaElement goal;

    public BestFirstAgenda(AgendaElement goal) {
        agenda = new TreeSet<AgendaElement>();
        this.goal = goal;
    }

    /**
     * Best first agenda makes sure each element added to the array is added
     * @param toAdd
     */
    public void add(AgendaElement... toAdd) {
        // Add array elems to list
        for (AgendaElement x : toAdd) {
            agenda.add(x);
        }

//        Collections.sort(agenda);
    }

    public void addAll(List<AgendaElement> toAdd) {
        agenda.addAll(toAdd);
    }

    public AgendaElement peek() {
        return agenda.first();
    }

    public AgendaElement pop() {
        return agenda.pollFirst();
    }

    public int size() {
        return agenda.size();
    }

    public boolean isEmpty() {
        return agenda.isEmpty();
    }
}