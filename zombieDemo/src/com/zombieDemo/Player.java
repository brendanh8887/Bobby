package com.zombieDemo;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bho on 7/11/17.
 */

public class Player {

    Rectangle bounds;

    double vx, vy, accel;

    int maxSpeed;

    private boolean alive;

    public Player() {

        alive = true;

        bounds = new Rectangle(100, 100, 10, 10);

        vx = 0;

        vy = 0;

        maxSpeed = 10;

        accel = 0.5;

    }

    public void draw(Graphics g) {

        if (alive) {

            g.setColor(Color.MAGENTA);

            g.fillRect(bounds.x, bounds.y, 10, 10);

        }

    }

    public void move(ArrayList<String> dirs) {

        for (int i = 0; i < dirs.size(); i++) {

            if(dirs.get(i).equals("UP"))

                vy -= accel;

            if(dirs.get(i).equals("LEFT"))

                vx -= accel;

            if(dirs.get(i).equals("DOWN"))

                vy += accel;

            if(dirs.get(i).equals("RIGHT"))

                vx += accel;

        }

        if(vx > maxSpeed)

            vx = maxSpeed;

        if(vx < -maxSpeed)

            vx = -maxSpeed;

        if(vy > maxSpeed)

            vy = maxSpeed;

        if(vy < -maxSpeed)

            vy = -maxSpeed;

        bounds.x += (int) vx;

        vx *= 0.99;

        bounds.y += (int) vy;

        vy *= 0.99;

    }

    public Rectangle getBounds() {

        return bounds;

    }

    public void hit() {

        alive = false;

    }

    public boolean isAlive() {

        return alive;

    }

}
