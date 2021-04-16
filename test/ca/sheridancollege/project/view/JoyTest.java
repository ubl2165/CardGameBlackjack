/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.view;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Ji Li
 */
public class JoyTest {
    
    public JoyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class Joy.
     */
    @Ignore
    @Test
    public void testValues() {
        System.out.println("values");
        Joy[] expResult = null;
        Joy[] result = Joy.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Joy.
     */
    @Ignore
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "";
        Joy expResult = null;
        Joy result = Joy.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of beHappy method, of class Joy.
     */
    @Test
    public void testBeHappy() {
        System.out.println("beHappy");
        String expResult[] = {Joy.beHappy(), Joy.beHappy(), Joy.beHappy()};
        String result[] = {Joy.beHappy(), Joy.beHappy(), Joy.beHappy()};
        
        Assert.assertArrayEquals(expResult, result);
        
        boolean expResult1 = false;
        


// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
