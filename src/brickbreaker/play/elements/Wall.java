package brickbreaker.play.elements;

import brickbreaker.Drawable;

import java.awt.*;

public class Wall extends Rectangle implements Drawable
{
    protected Color color = Color.GREEN;

    public Wall(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }

    public Wall(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height);
        this.color = color;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
