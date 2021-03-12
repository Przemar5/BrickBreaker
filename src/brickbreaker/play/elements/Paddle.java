package brickbreaker.play.elements;

import brickbreaker.Playable;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle implements Playable
{
    protected Color color = Color.GREEN;
    protected int velX = 0;
    protected int speedLimit = 12;
    protected int leftBound;
    protected int rightBound;

    public Paddle(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }

    public Paddle(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height);
        this.color = color;
    }

    public void accelerateLeft()
    {
        if (velX > -speedLimit)
            velX--;
    }

    public void accelerateRight()
    {
        if (velX < speedLimit)
            velX++;
    }

    public void stop()
    {
        velX = 0;
    }

    @Override
    public void update()
    {
        if (x < leftBound) {
            velX = 0;
            x = leftBound;
        }
        else if (x + width > rightBound) {
            velX = 0;
            x = rightBound - width;
        }
        x += velX;
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setSpeedLimit(int limit)
    {
        speedLimit = limit;
    }

    public void setLeftBound(int bound)
    {
        leftBound = bound;
    }

    public void setRightBound(int bound)
    {
        rightBound = bound;
    }
}
