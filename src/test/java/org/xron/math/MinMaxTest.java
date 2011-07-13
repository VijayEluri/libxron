// Author: Ben Page [ug73bxp] 
package org.xron.math;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class MinMaxTest {

    public MinMaxTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of add method, of class MinMax.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        double num = 0.0;
        MinMax instance = new MinMax();
        instance.add(num);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMax method, of class MinMax.
     */
    @Test
    public void testGetMax() {
        System.out.println("getMax");
        MinMax instance = new MinMax();
        double expResult = 0.0;
        double result = instance.getMax();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMin method, of class MinMax.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        MinMax instance = new MinMax();
        double expResult = 0.0;
        double result = instance.getMin();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRange method, of class MinMax.
     */
    @Test
    public void testGetRange() {
        System.out.println("getRange");
        MinMax instance = new MinMax();
        double expResult = 0.0;
        double result = instance.getRange();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MinMax.
     *
     * Does toString die?
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MinMax instance = new MinMax();
        instance.toString();
    }

    /**
     * Test of isFresh method, of class MinMax.
     */
    @Test
    public void testIsFresh() {
        System.out.println("isFresh");
        MinMax instance = new MinMax();
        boolean expResult = true;
        boolean result = instance.isFresh();
        assertEquals(expResult, result);
    }

}