// Author: Ben Page [ug73bxp] 
package org.xron.search;

import java.util.List;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public interface AgendaElement extends Comparable<AgendaElement> {

    int compareTo(AgendaElement that);

    boolean matches(AgendaElement that);

    List<AgendaElement> getSuccessors();

    AgendaElement getParent();
}
