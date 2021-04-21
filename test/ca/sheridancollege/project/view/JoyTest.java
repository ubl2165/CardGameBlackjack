/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.view;

import java.util.Arrays;
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
    @Test
    
    public void testValues() {
        System.out.println("values");
        Joy[] expResult = {Joy.GRIN, Joy.SMILE, Joy.JUMP, Joy.LARGH, Joy.KISS,
                           Joy.PUNCH, Joy.CHUCKLE, Joy.BRIGHTEN};
        Joy[] result = Joy.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Joy.
     */
    @Ignore
   
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
        System.out.println("beHappy method testing: ");
        
        Joy arr[] = Joy.values();
                        
        String arrByBeHappy1[] = new String[arr.length];
        String arrByBeHappy2[] = new String[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            
            arrByBeHappy1[i] = Joy.beHappy();
            arrByBeHappy2[i] = Joy.beHappy();
            
           
        }
        
        
        
        boolean expResult = false;
        boolean result = Arrays.equals(arrByBeHappy1, arrByBeHappy2);
        
        Assert.assertEquals(expResult, result);
        
        


// TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
