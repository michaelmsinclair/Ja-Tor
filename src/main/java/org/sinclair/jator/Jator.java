/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator;

import org.sinclair.jator.model.SeaPosition;

/**
 *
 * @author michael
 */
public class Jator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SeaPosition sp0, sp1;
        sp0 = new SeaPosition(2, 3, null);
        sp1 = new SeaPosition(2, 3, null);
        System.out.println(sp0.toString());
        System.out.println(sp1.compareTo(sp0));
    }

}
