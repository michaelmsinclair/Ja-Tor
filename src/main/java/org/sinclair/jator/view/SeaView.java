/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.view;

import org.sinclair.jator.model.Sea;
import org.sinclair.jator.model.SeaCreature;

/**
 *
 * @author michael
 */
public class SeaView {

    private final Sea sea;

    /**
     *
     * @param sea
     */
    public SeaView(Sea sea) {
        this.sea = sea;
    }

    public void display() {
        int maxX = sea.getMaxX();
        int maxY = sea.getMaxY();
        SeaCreature creature;
        for (int y = 0; y < maxY; y++) {
            String seaRow = "";
            for (int x = 0; x < maxX; x++) {
                creature = this.sea.getCell(x, y);
                if (creature == null) {
                    seaRow += " ";
                } else if (!creature.isAlive()) {
                    seaRow += " ";
                } else {
                    seaRow += creature.getShape();
                }
            }
            System.out.println(String.format("%2d %s", y, seaRow));
        }
    }

}
