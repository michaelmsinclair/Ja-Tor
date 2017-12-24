/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.List;
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
public class SeaCreatureTest {

    private final Sea sea;
    private final Random random;

    public SeaCreatureTest() {
        Random aRandom;
        aRandom = new Random();
        aRandom.setSeed(42);
        this.random = aRandom;
        Sea aSea = new Sea(10, 10, aRandom);
        this.sea = aSea;
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
     * Test of getPosition method, of class SeaCreature.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        SeaPosition newPos = new SeaPosition(0, 0, this.sea);
        System.out.println("SeaPosition: " + newPos);
        SeaCreature instance = this.sea.addCreature(newPos, "Fish", 3, 0, 99);
        System.out.println(instance);
        SeaPosition expResult = newPos;
        SeaPosition result = instance.getPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPosition method, of class SeaCreature.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        SeaPosition originalPosition = new SeaPosition(0, 1, this.sea);
        SeaPosition newPosition = new SeaPosition(0, 2, this.sea);
        SeaCreature instance = this.sea.addCreature(originalPosition, "Fish", 3, 0, 99);
        instance.setPosition(newPosition);
        assertEquals(newPosition.toString(), instance.getPosition().toString());
    }

    /**
     * Test of getCreatureID method, of class SeaCreature.
     */
    @Test
    public void testGetCreatureID() {
        System.out.println("getCreatureID");
        SeaPosition position = new SeaPosition(9, 9, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, 99);
        int expResult = 48;
        instance.setCreatureID(expResult);
        int result = instance.getCreatureID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCreatureID method, of class SeaCreature.
     */
    @Test
    public void testSetCreatureID() {
        System.out.println("setCreatureID");
        int creatureID = 42;
        SeaPosition originalPosition = new SeaPosition(0, 3, this.sea);
        SeaCreature instance = this.sea.addCreature(originalPosition, "Fish", 3, 0, 99);
        instance.setCreatureID(creatureID);
        assertEquals(creatureID, instance.getCreatureID());
    }

    /**
     * Test of setNextID method, of class SeaCreature.
     */
    @Test
    public void testSetNextID() {
        System.out.println("setNextID");
        int nextID = 23;
        SeaPosition position = new SeaPosition(1, 1, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, 99);
        instance.setNextID(nextID);
        assertEquals(23, instance.getNextID());
    }

    /**
     * Test of getNextID method, of class SeaCreature.
     */
    @Test
    public void testGetNextID() {
        System.out.println("getNextID");
        SeaPosition position = new SeaPosition(2, 5, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, 99);
        int expResult = 32;
        instance.setNextID(32);
        int result = instance.getNextID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class SeaCreature.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        SeaPosition position = new SeaPosition(2, 6, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, 99);
        int expResult = 0xff00;
        int result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAlive method, of class SeaCreature.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        SeaPosition position = new SeaPosition(2, 7, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, 99);
        boolean expResult = true;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class SeaCreature.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        SeaPosition position = new SeaPosition(3, 1, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, 99);
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAge method, of class SeaCreature.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 37;
        SeaPosition position = new SeaPosition(3, 2, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, 99);
        instance.setAge(37);
        assertEquals(age, instance.getAge());
    }

    /**
     * Test of getTotalAge method, of class SeaCreature.
     */
    @Test
    public void testGetTotalAge() {
        System.out.println("getTotalAge");
        SeaPosition position = new SeaPosition(3, 3, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, 99);
        // birth age = 0
        int expResult = 0;
        int result = instance.getTotalAge();
        assertEquals(expResult, result);
        // set to a new age
        expResult = 31;
        instance.setTotalAge(expResult);
        result = instance.getTotalAge();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTotalAge method, of class SeaCreature.
     */
    @Test
    public void testSetTotalAge() {
        System.out.println("setTotalAge");
        int totalAge = 41;
        SeaPosition position = new SeaPosition(3, 4, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, 99);
        instance.setTotalAge(totalAge);
        assertEquals(totalAge, instance.getTotalAge());

    }

    /**
     * Test of getStarve method, of class SeaCreature.
     */
    @Test
    public void testGetStarve() {
        System.out.println("getStarve");
        int expResult = 73;
        SeaPosition position = new SeaPosition(4, 3, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, expResult);
        instance.setStarve(expResult);
        int result = instance.getStarve();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStarve method, of class SeaCreature.
     */
    @Test
    public void testSetStarve() {
        System.out.println("setStarve");
        int starve = 23;
        SeaPosition position = new SeaPosition(4, 3, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 3, 0, starve);
        instance.setStarve(starve);
        assertEquals(starve, instance.getStarve());
    }

    /**
     * Test of toString method, of class SeaCreature.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SeaPosition position = new SeaPosition(7, 7, this.sea);
        SeaCreature instance = this.sea.addCreature(position, "Fish", 42, 7, 51);
        instance.setCreatureID(4242);
        String expResult = "0000004242 Parent: 0000000007 (7,7) Alive: true Age: 0 Spawn in: 42 Starve in: 51";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
