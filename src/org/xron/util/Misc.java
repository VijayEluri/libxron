/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.xron.util;

/**
 *
 * @author Ben Page
 */
public class Misc {

    /**
     * Wrapper around Java's Thread.sleep(), ignores the exception thrown.
     *
     * @param      millis   the length of time to sleep in milliseconds.
     * @see        java.lang.Thread#sleep(long)
     */
    public static void sleep2(long millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException x){
            System.err.println("WARNING: Ignored exception in org.xron.util.Extra.sleep");
        }
    }

}
