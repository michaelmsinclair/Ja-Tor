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
public class SharkTest {

    private final Sea sea;
    private final Random random;
    private final int spawnAge;
    private final int parent;
    private final int starveAge;
    private final int fishSpawnAge;
    private final int fishStarveAge;

    public SharkTest() {
        Random aRandom;
        aRandom = new Random();
        aRandom.setSeed(42);
        this.random = aRandom;
        Sea aSea = new Sea(10, 10, aRandom);
        this.sea = aSea;
        this.spawnAge = 5;
        this.parent = 29;
        this.starveAge = 3;
        this.fishSpawnAge = 2;
        this.fishStarveAge = 99;
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
     * Test of eat method, of class Shark.
     */
    @Test
    public void testEat() {
        System.out.println("eat");

        System.out.println("Before eating");
        SeaPosition position = new SeaPosition(5, 5, this.sea);
        Fish aFish = new Fish(this.sea, position, this.fishSpawnAge, this.fishStarveAge, this.random, this.parent);
        System.out.println(aFish);
        position = new SeaPosition(5, 6, this.sea);
        this.sea.setCell(aFish.getPosition(), aFish);

        Shark aShark = new Shark(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent);
        System.out.println(aShark);
        this.sea.setCell(aShark.getPosition(), aShark);
        List<SeaCreature> occupied = aShark.pos.getAdjacentCreatures();

        boolean expResult = true;
        System.out.println(occupied);
        boolean result = aShark.eat(occupied);
        System.out.println("After eating");
        System.out.println(aFish);
        System.out.println(aShark);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of turn method, of class Shark.
     */
    @Test
    public void testTurn() {
        System.out.println("turn");
        Shark instance = null;
        instance.turn();
         TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Shark.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SeaPosition position = new SeaPosition(7, 7, this.sea);
        SeaCreature instance;
        instance = new Shark(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent);
        instance.setCreatureID(2525);
        System.out.println(instance);
        String expResult = "Shark 0000002525 Parent: 0000000029 (7,7) Alive: true Age: 0 Spawn in: 5 Starve in: 3";
        System.out.println(expResult);
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
