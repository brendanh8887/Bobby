package com.zombieDemo.zombies;

import com.zombieDemo.Player;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bho on 7/11/17.
 */

public class Zombie {

    int speed;

    Rectangle bounds;

    public Zombie(Rectangle bounds) {

        this.bounds = bounds;

        speed = 2;

    }


    public void draw(Graphics g) {

        g.setColor(Color.GREEN);

        g.fillRect(bounds.x, bounds.y, 10, 10);

    }

    public void move(Player player) {

        Rectangle pBounds = player.getBounds();

        if(player.isAlive()) {

            if (bounds.x < pBounds.x)

                bounds.x += speed;

            if (bounds.x > pBounds.x)

                bounds.x -= speed;

            if (bounds.y < pBounds.y)

                bounds.y += speed;

            if (bounds.y > pBounds.y)

                bounds.y -= speed;

        }

        act(player);

    }

    private void act(Player player) {

        if(contains(player.getBounds()))

            player.hit();

    }

    public boolean contains(Rectangle rect) {

        return bounds.contains(rect);

    }

}
