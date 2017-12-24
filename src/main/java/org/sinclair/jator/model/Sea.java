/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author michael
 */
public class Sea {

    private List<SeaCreature> creatures = new ArrayList<>();
    private int maxX;
    private int maxY;
    private SeaCreature sea[][];
    private int sharks;
    private int fishes;
    private Random random;

    public Sea(int x, int y, Random random) {
        this.maxX = x;
        this.maxY = y;
        this.random = random;
        this.sea = new SeaCreature[x][y];
    }

    public int getMaxX() {
        return this.maxX;
    }

    public int getMaxY() {
        return this.maxY;
    }

    public SeaCreature getCell(SeaPosition position) {
        return this.sea[position.getX()][position.getY()];
    }

    public void emptyCell(SeaPosition position) {
        this.sea[position.getX()][position.getY()] = null;
    }

    public boolean isCellEmpty(SeaPosition position) {
        /*
        If cell is null, or creature is not alive the cell is empty.
         */
        boolean result;
        result = true;
        int x = position.getX();
        int y = position.getY();
        if (this.sea[x][y] != null) {
            result = !this.sea[x][y].isAlive();
        }
        return result;
    }

    /**
     *
     * @param x
     * @param y
     * @param newCreature
     * @param t
     * @param spawn
     * @param parent
     * @param starve
     * @return
     */
    public SeaCreature addCreature(SeaPosition position, String newCreature, int spawn, int parent, int starve) {
        SeaCreature creature;
        creature = null;

        if ("Shark".equals(newCreature)) {
            creature = new Shark(this, position, spawn, starve, this.random, parent);
        } else if ("Fish".equals(newCreature)) {
            creature = new Fish(this, position, spawn, starve, this.random, parent);
        }

        if (creature != null && this.setCell(position, creature)) {
            this.creatures.add(creature);
        } else {
            creature = null;
        }
        return creature;
    }

    public boolean setCell(SeaPosition position, SeaCreature c) {
        /*
        Put creature c in cell (x,y) of the sea, if the cell is empty
        Return True if possible and false if not.
         */
        boolean result = false;

        if (this.isCellEmpty(position)) {
            this.sea[position.getX()][position.getY()] = c;
            result = true;
        }
        return result;
    }
}
