/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.Random;

/**
 *
 * @author michael
 */
public class Shark extends SeaCreature {

    /**
     *
     * @param sea
     * @param pos
     * @param traditional
     * @param spawnAge
     * @param starveAge
     * @param random
     * @param parent
     */
    public Shark(Sea sea, SeaPosition pos, int spawnAge, int starveAge, Random random, int parent) {
        super(sea, pos, spawnAge, starveAge, random, parent);
    }

}
