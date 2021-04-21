/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.model;

import ca.sheridancollege.project.controller.Gambler;
import ca.sheridancollege.project.model.basecode.Player;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Ji Li
 */
public class ValidatorTest {
    
    //add a field
//    private static Validator validator;
    
    public ValidatorTest() {
        
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        
//        validator = new Validator();
    }
    
    @AfterClass
    public static void tearDownClass() {
//        validator = null;
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
        System.out.println("--------------");
    }

    /**
     * Test of isUniqueName method, of class Validator.
     */
//    @Test
    @Ignore
    public void testIsUniqueName() {
        System.out.println("isUniqueName");
        String name = "";
        ArrayList<Player> players = null;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isUniqueName(name, players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidFullName method, of class Validator.
     */
    @Ignore
//    @Test
    public void testIsValidFullName() {
        System.out.println("isValidFullName");
        String input = "";
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isValidFullName(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNotEmptyOrNull method, of class Validator.
     */
    @Test
    public void testIsNotEmptyOrNullGood() {
        System.out.println("isNotEmptyOrNullGood");
        String input = "1 ";
        System.out.println("Testing \"1 \".");
        Validator instance = new Validator();
        boolean expResult = true;
        boolean result = instance.isNotEmptyOrNull(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    /**
     * Test of isNotEmptyOrNull method, of class Validator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsNotEmptyOrNullBad() {
        System.out.println("isNotEmptyOrNullBad");
        String input = "";
        System.out.println("Testing empty string.");
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isNotEmptyOrNull(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    
    /**
     * Test of isNotEmptyOrNull method, of class Validator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsNotEmptyOrNullBad2() {
        System.out.println("isNotEmptyOrNullBad2");
        String input = null;
        System.out.println("Testing null.");
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isNotEmptyOrNull(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }    
    /**
     * Test of isValidLength method, of class Validator.
     */
//    @Test
    @Ignore
    public void testIsValidLength() {
        System.out.println("isValidLength");
        String input = "";
        int validLength = 0;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isValidLength(input, validLength);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidBetting method, of class Validator.
     */
//    @Test
    @Ignore
    public void testIsValidBetting() {
        System.out.println("isValidBetting");
        double bet = 0.0;
        Gambler gambler = null;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isValidBetting(bet, gambler);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDouble method, of class Validator.
     */
//    @Test
    @Ignore
    public void testIsValidDouble_String() {
        System.out.println("isValidDouble");
        String input = "";
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isValidDouble(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDouble method, of class Validator.
     */
//    @Test
    @Ignore
    public void testIsValidDouble_double() {
        System.out.println("isValidDouble");
        double input = 0.0;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isValidDouble(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidInteger method, of class Validator.
     */
//    @Test
    @Ignore
    public void testIsValidInteger() {
        System.out.println("isValidInteger");
        String input = "";
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isValidInteger(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInTheRange method, of class Validator.
     */
//    @Test
    @Ignore
    public void testIsInTheRange_doubleArr() {
        System.out.println("isInTheRange");
        double[] args = null;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isInTheRange(args);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInTheRange method, of class Validator.
     */
//    @Test
    @Ignore
    public void testIsInTheRange_intArr() {
        System.out.println("isInTheRange");
        int[] args = null;
        Validator instance = new Validator();
        boolean expResult = false;
        boolean result = instance.isInTheRange(args);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
