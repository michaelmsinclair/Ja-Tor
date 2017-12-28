/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michael
 */
public class SeaTest {
    
    static Random random;
    
    public SeaTest() {
        random.setSeed(42);
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
     * Test of getMaxX method, of class Sea.
     */
    @Test
    public void testGetMaxX() {
        System.out.println("getMaxX");
        Sea instance;
        instance = new Sea(7, 11, SeaTest.random);
        int expResult = 7;
        int result = instance.getMaxX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxY method, of class Sea.
     */
    @Test
    public void testGetMaxY() {
        System.out.println("getMaxY");
        Sea instance;
        instance = new Sea(7, 11, SeaTest.random);
        int expResult = 11;
        int result = instance.getMaxY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCell method, of class Sea.
     */
    @Test
    public void testGetCell() {
        System.out.println("getCell");
        Sea instance;
        instance = new Sea(7, 11, SeaTest.random);
        SeaPosition position = new SeaPosition(3,5, instance);
        SeaCreature addCreature = instance.addCreature(position, "Shark", 3, 0, 5);
        SeaCreature expResult = addCreature;
        SeaCreature result = instance.getCell(position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setCell method, of class Sea.
     */
    @Test
    public void testSetCell() {
        System.out.println("setCell");
        SeaPosition position = null;
        SeaCreature c = null;
        Sea instance = null;
        boolean expResult = false;
        boolean result = instance.setCell(position, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of emptyCell method, of class Sea.
     */
    @Test
    public void testEmptyCell() {
        System.out.println("emptyCell");
        SeaPosition position = null;
        Sea instance = null;
        instance.emptyCell(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCellEmpty method, of class Sea.
     */
    @Test
    public void testIsCellEmpty() {
        System.out.println("isCellEmpty");
        SeaPosition position = null;
        Sea instance = null;
        boolean expResult = false;
        boolean result = instance.isCellEmpty(position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCreature method, of class Sea.
     */
    @Test
    public void testAddCreature() {
        System.out.println("addCreature");
        SeaPosition position = null;
        String newCreature = "";
        int spawn = 0;
        int parent = 0;
        int starve = 0;
        Sea instance = null;
        SeaCreature expResult = null;
        SeaCreature result = instance.addCreature(position, newCreature, spawn, parent, starve);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cleanCreatures method, of class Sea.
     */
    @Test
    public void testCleanCreatures() {
        System.out.println("cleanCreatures");
        Sea instance = null;
        instance.cleanCreatures();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Sea.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Sea instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCell method, of class Sea.
     */
    @Test
    public void testGetCell_SeaPosition() {
        System.out.println("getCell");
        SeaPosition position = null;
        Sea instance = null;
        SeaCreature expResult = null;
        SeaCreature result = instance.getCell(position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCell method, of class Sea.
     */
    @Test
    public void testGetCell_int_int() {
        System.out.println("getCell");
        int x = 0;
        int y = 0;
        Sea instance = null;
        SeaCreature expResult = null;
        SeaCreature result = instance.getCell(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveCreature method, of class Sea.
     */
    @Test
    public void testMoveCreature() {
        System.out.println("moveCreature");
        SeaCreature c = null;
        SeaPosition newPos = null;
        Sea instance = null;
        instance.moveCreature(c, newPos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCreature method, of class Sea.
     */
    @Test
    public void testRemoveCreature() {
        System.out.println("removeCreature");
        SeaCreature c = null;
        Sea instance = null;
        instance.removeCreature(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeTurns method, of class Sea.
     */
    @Test
    public void testTakeTurns() {
        System.out.println("takeTurns");
        Sea instance = null;
        instance.takeTurns();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
