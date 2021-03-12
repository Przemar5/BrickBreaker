package brickbreaker.play.elements;

import brickbreaker.Drawable;
import brickbreaker.Updatable;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball extends Ellipse2D.Float implements Drawable, Updatable
{
    protected int vx;
    protected int vy;
    protected Color color = Color.GREEN;

    public Ball(int x, int y, int d, int vx, int vy)
    {
        super(x, y, d, d);
        this.vx = vx;
        this.vy = vy;
    }

    public Ball(int x, int y, int d, int vx, int vy, Color color)
    {
        super(x, y, d, d);
        this.vx = vx;
        this.vy = vy;
        this.color = color;
    }

    public void update()
    {
        x += vx;
        y += vy;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillOval((int) x, (int) y, (int) width, (int) width);
    }

    public void bounceHorizontal()
    {
        vx = -vx;
    }

    public void bounceVertical()
    {
        vy = -vy;
    }

    public void bounceIfCollision(Rectangle r)
    {
        if (hasCollided(r)) {
            if ((x + width <= r.x + vx) || (x >= r.x + r.width + vx)) {
                bounceHorizontal();
            }
            if ((y + height <= r.y + vy) || (y >= r.y + r.height + vy)) {
                bounceVertical();
            }
        }
    }

    public boolean hasCollided(Rectangle r)
    {
        return (x + width >= r.x && y + height >= r.y &&
                x <= r.x + r.width && y <= r.y + r.height);
    }
}
