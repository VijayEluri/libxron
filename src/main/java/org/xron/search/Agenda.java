// Author: Ben Page [ug73bxp] 
package org.xron.search;

import java.util.List;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public interface Agenda<K extends AgendaElement> {

    public void add(K... toAdd);

    public void addAll(List<K> toAdd);

    public K peek();

    public K pop();

    public int size();

    public boolean isEmpty();
}
