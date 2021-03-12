package brickbreaker.play.elements;

import brickbreaker.Drawable;

import java.awt.*;

public class Brick extends Rectangle implements Drawable
{
    protected Color color = Color.GREEN;
    protected int lives = 1;

    public Brick(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }

    public Brick(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void onHit()
    {
        if (lives > 0)
            lives--;
    }

    public boolean isBroken()
    {
        return lives <= 0;
    }

    public void setLives(int lives)
    {
        this.lives = lives;
    }

    public int getLives()
    {
        return lives;
    }
}
