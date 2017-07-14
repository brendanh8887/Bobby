package com.zombieDemo;

import com.zombieDemo.zombies.Zombie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by bho on 7/11/17.
 */

public class Client extends JApplet implements KeyListener {

    private Graphics bg;

    private Image offScreen;

    private Player Bobby;

    private Zombie Newt;

    private ArrayList<String> dirs;

    private ArrayList<Zombie> zeds;

    public void init() {

        setSize(1439, 772);

        dirs = new ArrayList<>();

//        Rectangle Screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        Rectangle Screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        offScreen = createImage(Screen.width, Screen.height);

        bg = offScreen.getGraphics();

        zeds = new ArrayList<>();

        Bobby = new Player();

        Newt = new Zombie(new Rectangle(40, 40, 10, 10));

        setFocusable(true);

        addKeyListener(this);

        for(int i = 0; i < 100; i++)

            zeds.add(new Zombie(new Rectangle((int) (Math.random()*Screen.width), (int) (Math.random()*Screen.height), 10, 10)));

        Timer timer = new Timer(30, ae -> {

            Bobby.move(dirs);

            for(Zombie zed : zeds) {

                zed.move(Bobby);

            }

            repaint();

        });

        timer.start();

    }

    public void paint(Graphics g) {

        bg.clearRect(0, 0, offScreen.getWidth(this), offScreen.getHeight(this));

        Bobby.draw(bg);

        for(Zombie zed : zeds)

            zed.draw(bg);

//        Newt.draw(bg);

        g.drawImage(offScreen, 0, 0, this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyChar() == 'w')

            if(!dirs.contains("UP"))

                dirs.add("UP");

        if(e.getKeyChar() == 'a')

            if(!dirs.contains("LEFT"))

                dirs.add("LEFT");

        if(e.getKeyChar() == 's')

            if(!dirs.contains("DOWN"))

                dirs.add("DOWN");

        if(e.getKeyChar() == 'd')

            if(!dirs.contains("RIGHT"))

                dirs.add("RIGHT");

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyChar() == 'w')

            dirs.remove("UP");

        if(e.getKeyChar() == 'a')

            dirs.remove("LEFT");

        if(e.getKeyChar() == 's')

            dirs.remove("DOWN");

        if(e.getKeyChar() == 'd')

            dirs.remove("RIGHT");

    }
}
