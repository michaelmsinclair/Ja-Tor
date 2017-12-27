/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sinclair.jator.model.Sea;
import org.sinclair.jator.model.SeaCreature;
import org.sinclair.jator.model.SeaPosition;
import org.sinclair.jator.view.SeaView;

/**
 *
 * @author michael
 */
public class Jator {

    static Random random;
    static Sea sea;
    static int x;
    static int y;
    static int fishSpawn;
    static int fishStarve;
    static int sharkSpawn;
    static int sharkStarve;

  private static void Jator() {
        Jator.random = new Random();
        Jator.x = 10;
        Jator.y = 10;
        Jator.fishSpawn = 5;
        Jator.fishStarve = 99;
        Jator.sharkSpawn = 99;
        Jator.sharkStarve = 99;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jator();
        generateSea();
        boolean simulating = true;
        SeaView seaView = new SeaView(Jator.sea);
        int ticks = 0;
        while (simulating) {
            seaView.display();
            Jator.sea.takeTurns();
            System.out.println(String.format("%5d Simulating %s", ticks, Jator.sea));
            ticks++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static void generateSea() {
        int allCells;
        allCells = Jator.x * Jator.y;
        int sharks;
        sharks = allCells / 10;
//        sharks = 0;
        int fishes;
        fishes = allCells / 4;
//        fishes = 1;

        Jator.sea = new Sea(Jator.x, Jator.y, Jator.random);

        boolean noCreature;
        SeaPosition position;
        SeaCreature creature;
        int posX;
        int posY;

        for (int s = 0; s < sharks; s++) {
            noCreature = true;
            while (noCreature) {
                posX = random.nextInt(Jator.x);
                posY = random.nextInt(Jator.y);
                position = new SeaPosition(posX, posY, Jator.sea);
                creature = Jator.sea.addCreature(position, "Shark", Jator.sharkSpawn, 0, Jator.sharkStarve);
                if (creature != null) {
                    noCreature = false;
                }
            }
        }

        for (int f = 0; f < fishes; f++) {
            noCreature = true;
            while (noCreature) {
                posX = random.nextInt(x);
                posY = random.nextInt(y);
                position = new SeaPosition(posX, posY, Jator.sea);
                creature = Jator.sea.addCreature(position, "Fish", Jator.fishSpawn, 0, Jator.fishStarve);
                if (creature != null) {
                    noCreature = false;
                }
            }
        }
    }
}
