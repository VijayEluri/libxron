// Author: Ben Page [ug73bxp] 
package org.xron.search;

import java.util.ArrayList;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class Searcher<K extends AgendaElement> {

    /** if safe margin > 0 this is a safety map */
//    private ArrayList<PathNode> nodes;
    // ====== Constants ==========
    private static final boolean VERBOSE = false;
    private static final int SAFE_MARGIN = 20;
    public boolean draw_links = true;

    /**
     * Find lastPath uses A* to search for a lastPath between two points
     * @param startIndex
     * @param endIndex
     * @return
     */
    public K findPath(K start, K goal) throws SearchException {
        // Start and end of route


        // Initialize
//        Agenda openSet = new BestFirstAgenda(goal);
        Agenda<K> openSet = new BreadthFirstAgenda<K>();
        ArrayList<K> closedSet = new ArrayList<K>();

        // Start the list off
        openSet.add(start);

        // Start the search off
        while (!openSet.isEmpty()) {
            K candidate = openSet.pop();
            if (candidate.matches(goal)) {
                // We have found the goal node
//                lastPath = agendaToPath(candidate, startPoint, goalPoint);

                // remove start and goal from the roadmap
                return candidate;
            }
            if (VERBOSE) {
                System.out.println("Adding " + candidate + " to closed list");
            }
            closedSet.add(candidate);

            // Generate Successors
            if (VERBOSE) {
                System.out.println("Gen Successors");
            }
            for (AgendaElement successor : candidate.getSuccessors()) {
                if (closedSet.contains((K) successor)) { //Iffy cast?
                    // We don't need to inspect this node again
                    continue;
                } else {
                    // add it to the openSet (add will be ignored if it is already there)
                    openSet.add((K) successor);
                }
            }

        }

        throw new SearchException("No Valid Path could be found");
    }
}
