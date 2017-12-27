/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author michael
 */
public class Sea {

    private List<SeaCreature> creatures;
    private int maxX;
    private int maxY;
    private SeaCreature cells[][];
    private int sharks;
    private int fishes;
    private Random random;

    public Sea(int x, int y, Random random) {
        this.creatures = new ArrayList<>();
        this.maxX = x;
        this.maxY = y;
        this.random = random;
        this.cells = new SeaCreature[x][y];
    }

    public int getMaxX() {
        return this.maxX;
    }

    public int getMaxY() {
        return this.maxY;
    }

    public SeaCreature getCell(SeaPosition position) {
        return this.cells[position.getX()][position.getY()];
    }

    public SeaCreature getCell(int x, int y) {
        return this.cells[x][y];
    }

    public boolean setCell(SeaPosition position, SeaCreature c) {
        /*
        Put creature c in cell (x,y) of the sea, if the cell is empty
        Return True if possible and false if not.
         */
        boolean result = false;

        if (this.isCellEmpty(position)) {
            this.cells[position.getX()][position.getY()] = c;
            result = true;
        }
        return result;
    }

    public void emptyCell(SeaPosition position) {
        this.cells[position.getX()][position.getY()] = null;
    }

    public boolean isCellEmpty(SeaPosition position) {
        /*
        If cell is null, or creature is not alive the cell is empty.
         */
        boolean result;
        result = true;
        int x = position.getX();
        int y = position.getY();
        if (this.cells[x][y] != null) {
            result = !this.cells[x][y].isAlive();
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
            this.sharks++;
        } else if ("Fish".equals(newCreature)) {
            creature = new Fish(this, position, spawn, starve, this.random, parent);
            this.fishes++;
        }

        if (creature != null && this.setCell(position, creature)) {
            this.creatures.add(creature);
        } else {
            creature = null;
        }
        return creature;
    }

    public void moveCreature(SeaCreature c, SeaPosition newPos) {
        if (this.isCellEmpty(newPos)) {
            this.setCell(newPos, c);
            this.emptyCell(c.getPosition());
            c.setPosition(newPos);
        } else if (!this.getCell(newPos).isAlive()) {
            this.setCell(newPos, c);
            this.emptyCell(c.getPosition());
            c.setPosition(newPos);
        }
    }

    public void removeCreature(SeaCreature c) {
        c.died();
        this.emptyCell(c.getPosition());
        if ("Shark".equals(c.getClass().getSimpleName())) {
            this.sharks--;
        } else if ("Fish".equals(c.getClass().getSimpleName())) {
            this.fishes--;
        }
    }

    public void cleanCreatures() {
        /*
        Remove the dead creatures from the list of creatures.
        Certify counts.
         */
        this.sharks = 0;
        this.fishes = 0;
        List<SeaCreature> aliveCreatures = new ArrayList<>();
        Collection<SeaCreature> collectedCreatures = this.creatures;
        Iterator<SeaCreature> iterateCreatures = collectedCreatures.iterator();
        while (iterateCreatures.hasNext()) {
            SeaCreature c = iterateCreatures.next();
            if (c.isAlive()) {
                aliveCreatures.add(c);
                switch (c.getClass().getSimpleName()) {
                    case "Shark":
                        this.sharks++;
                        break;
                    case "Fish":
                        this.fishes++;
                        break;
                }
            }
        }

        this.creatures = aliveCreatures;
    }

    private int getSharks() {
        return this.sharks;
    }

    private int getFishes() {
        return this.fishes;
    }

    public void takeTurns() {
        int nCreatures = this.creatures.size();
        for (int i = 0; i < nCreatures; i++) {
            SeaCreature c = creatures.get(i);
            c.turn();
        }
    }

    @Override
    public String toString() {
        sharks = this.getSharks();
        fishes = this.getFishes();
        int nCells;
        nCells = this.maxX * this.maxY;
        int empty = nCells - sharks - fishes;
        return String.format("Sharks: %d Fishes: %d Empty: %d", sharks, fishes, empty);
    }

}
