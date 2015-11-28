// Author: Ben Page [ug73bxp] 
package org.xron.search;

import java.util.List;

/**
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public interface AgendaElement extends Comparable<AgendaElement> {

  int compareTo(AgendaElement that);

  /**
   * True if the two agenda elements have the same result.
   * (regardless of path)
   *
   * @param that
   * @return
   */
  boolean matches(AgendaElement that);

  List<AgendaElement> getSuccessors();

  AgendaElement getParent();
}
