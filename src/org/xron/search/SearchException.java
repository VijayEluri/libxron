// Author: Ben Page [ug73bxp] 
package org.xron.search;

/**
 * Exception thrown by searches
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class SearchException extends Exception {

    public enum Type {NO_SOLUTION, ERROR};

    public final Type type;

    public SearchException(String message) {
        this(Type.ERROR, message);
    }

    public SearchException(Type type, String message) {
        super(message);
        this.type = type;
    }


}
