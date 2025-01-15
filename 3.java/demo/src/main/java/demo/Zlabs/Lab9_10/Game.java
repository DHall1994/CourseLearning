package demo.Zlabs.Lab9_10;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Game extends Canvas {

    private ArrayList<Shape> shapes; // List of shapes

    public Game() {
        JFrame frame = new JFrame("Bouncing Shapes Game");
        this.setSize(400, 400);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);

        // Initialize the shapes ArrayList
        shapes = new ArrayList<>();

        // Add shapes to the ArrayList
        shapes.add(new Shape(50, 50, 50, 50, 2, 3, SHAPE_TYPE.RoundRectangle, Color.RED));
        shapes.add(new Shape(100, 100, 60, 60, 3, 2, SHAPE_TYPE.Oval, Color.BLUE));
        shapes.add(new Shape(150, 150, 70, 70, 4, 4, SHAPE_TYPE.Arc, Color.GREEN));

        // Set the world dimensions using the static method in Shape
        Shape.setWorld(300, 300);

        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        };

        t.schedule(tt, 0, 50); // Schedule the timer to call draw() every 50ms

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                t.cancel();
                tt.cancel();
                frame.dispose();
            }
        });
    }

    public void draw() {
        for (Shape s : shapes) { // Move each shape
            s.move();
        }
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(0, 0, Shape.worldW, Shape.worldH); // Draw the world's rectangle
        for (Shape s : shapes) {
            g.setColor(s.getColour());
            switch (s.getShapeType()) {
                case Rectangle -> g.drawRect(s.x, s.y, s.w, s.h);
                case ThreeDRectangle -> g.fill3DRect(s.x, s.y, s.w, s.h, true);
                case RoundRectangle -> g.drawRoundRect(s.x, s.y, s.w, s.h, 20, 20);
                case Oval -> g.drawOval(s.x, s.y, s.w, s.h);
                case Arc -> g.drawArc(s.x, s.y, s.w, s.h, 0, 180);
            }
        }
    }

    public static void main(String[] args) {
        new Game(); // Start the game

        // Part 2: String Operations
        String name = "Jonathan";
        System.out.println("Third character: " + name.charAt(2));
        System.out.println("Lowercase: " + name.toLowerCase());
        System.out.println("Uppercase: " + name.toUpperCase());

        System.out.println("Characters tab-separated:");
        for (char c : name.toCharArray()) {
            System.out.print(c + "\t");
        }
        System.out.println();

        System.out.println("Starts with 'Jon': " + name.startsWith("Jon"));
        System.out.println("Ends with 'than': " + name.endsWith("than"));
        System.out.println("Index of 'a': " + name.indexOf('a'));
        System.out.println("Index of 'z': " + name.indexOf('z'));

        String fullName = name + " Doe";
        System.out.println("Full name: " + fullName);

        // Part 3: StringBuilder Operations
        StringBuilder sb = new StringBuilder("Bruce Springsteen ");
        sb.append("is the artist ever");
        System.out.println(sb.toString());

        sb.insert(sb.indexOf("artist"), "greatest ");
        System.out.println(sb.toString());

        sb.replace(sb.indexOf("artist"), sb.indexOf("artist") + "artist".length(), "rock singer");
        System.out.println(sb.toString());
    }
}