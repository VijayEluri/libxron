/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.xron.math;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ben
 */
public class Vector3DTest {

    public Vector3DTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of set method, of class Vector3D.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int newX = 4;
        int newY = 6;
        int newZ = 100;
        Vector3D instance = new Vector3D();
        instance.set(newX, newY, newZ);
        assertEquals(newX, instance.x, 0);
        assertEquals(newY, instance.y, 0);
        assertEquals(newZ, instance.z, 0);
    }

    /**
     * Test of magnitude method, of class Vector3D.
     */
    @Test
    public void testMagnitude1() {
        System.out.println("magnitude:1");
        Vector3D instance = new Vector3D(1,0,0);
        double expResult = 1.0;
        double result = instance.magnitude();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of magnitude method, of class Vector3D.
     */
    @Test
    public void testMagnitude2() {
        System.out.println("magnitude:2");
        Vector3D instance = new Vector3D(4,0,3);
        double expResult = 5.0;
        double result = instance.magnitude();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of rotate method, of class Vector3D.
     */
    @Test
    public void testRotate() {
        System.out.println("rotate");
        Vector3D up = null;
        int rads = 0;
        Vector3D instance = new Vector3D();
        instance.rotate(up, rads);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of magnitude method, of class Vector3D.
     */
    @Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector3D instance = new Vector3D(2,5,7);
        instance.normalize();
        double expResult = 1.0;
        double result = instance.magnitude();
        assertEquals(expResult, result, 0.00001);
    }
    
}