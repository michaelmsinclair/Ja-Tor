/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.sinclair.jator.model.Sea;
import org.sinclair.jator.model.SeaCreature;
import org.sinclair.jator.model.SeaPosition;

/**
 *
 * @author michael
 */
public class Jator extends Application {

    static Random random;
    static Sea sea;
    static int x;
    static int y;
    static int fishSpawn;
    static int fishStarve;
    static int sharkSpawn;
    static int sharkStarve;
    static boolean allCreatures;
    static int cellsize;

    private static void Jator() {
        Jator.random = new Random();
        Jator.x = 320;
        Jator.y = 180;
        Jator.x = 160;
        Jator.y = 90;
        Jator.fishSpawn = 2;
        Jator.fishStarve = 99;
        Jator.sharkSpawn = 5;
        Jator.sharkStarve = 3;
        Jator.allCreatures = false;
        Jator.cellsize = 5;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jator();
        generateSea();
        launch();
    }

    static void generateSea() {
        int allCells;
        allCells = Jator.x * Jator.y;
        int sharks;
        sharks = allCells / 10;
        int fishes;
        fishes = allCells / 4;

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

    @Override
    public void start(Stage jatorStage) {
        long X = Jator.sea.getMaxX() * Jator.cellsize;
        long Y = Jator.sea.getMaxY() * Jator.cellsize;
        jatorStage.setTitle("Ja-Tor");
        Group root;
        root = new Group();
        Scene scene;
        scene = new Scene(root, Color.BLUE);
        Canvas canvas = new Canvas(X, Y);
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();
        jatorStage.setScene(scene);

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf;
        kf = new KeyFrame(
//                Duration.seconds(0.084), // 12 FPS
                Duration.seconds(0.042), // 24 FPS
//                Duration.seconds(0.021), // 48 FPS
//                Duration.seconds(0.017), // 60 FPS
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent ae) {
                        // Clear the canvas
                        gc.clearRect(0, 0, X, Y);
                        
                        Collection<SeaCreature> collectedCreatures = Jator.sea.getCreatures();
                        Iterator<SeaCreature> iterateCreatures = collectedCreatures.iterator();
                        while (iterateCreatures.hasNext()) {
                            SeaCreature c = iterateCreatures.next();
//                            System.out.println(c);
                            if (c.isAlive()) {
                                gc.setFill(c.getColor());
                                gc.fillRect(c.getPosition().getX()*Jator.cellsize, c.getPosition().getY()*Jator.cellsize, Jator.cellsize, Jator.cellsize);
                            }
                        }
                        Jator.sea.takeTurns();
//                        System.out.println(Jator.sea);
                    }
                });

        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();

        jatorStage.show();

    }
}
