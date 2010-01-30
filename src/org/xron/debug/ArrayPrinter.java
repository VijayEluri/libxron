/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.xron.debug;

import java.io.PrintStream;

/**
 *
 * @author ben
 */
public class ArrayPrinter {
    
    static PrintStream out = System.out;

    public static void printFloat(float[] arr){
        out.println(arr.length + " elements:");
        for (int i = 0; i < arr.length; i++) {
            out.println("\t"+i+": "+arr[i]);
        }
    }

    public static void printFloats(float... arr){
        out.println(arr.length + " elements:");
        for (int i = 0; i < arr.length; i++) {
            out.println("\t"+i+": "+arr[i]);
        }
    }

    public static void printObject(Object[] arr){
        out.println(arr.length + " elements:");
        for (int i = 0; i < arr.length; i++) {
            out.println("\t"+i+": "+arr[i]);
        }
    }

    public static void printObjects(Object... arr){
        out.println(arr.length + " elements:");
        for (int i = 0; i < arr.length; i++) {
            out.println("\t"+i+": "+arr[i]);
        }
    }

    public static void useStdOut(){
        out = System.out;
    }

    public static void useStdErr(){
        out = System.err;
    }

    public static void useStream(PrintStream x){
        out = x;
    }



}
