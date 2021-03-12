package brickbreaker.play.elements;

import brickbreaker.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BrickBoard implements Drawable
{
    ArrayList<Brick> bricks;

    public BrickBoard(int rows, int cols, int width, int height, int offset)
    {
        bricks = new ArrayList<Brick>(rows * cols);
        int brickWidth = (width / cols) - 12;
        int brickHeight = (height / rows) - 12;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = offset + 6 + (j * (brickWidth + 12));
                int y = offset + 6 + (i * (brickHeight + 12));
                bricks.add(new Brick(x, y, brickWidth, brickHeight));
            }
        }
    }

    public void handleCollision(Ball ball)
    {
        Iterator it = bricks.listIterator();

        while (it.hasNext()) {
            Brick brick = (Brick) it.next();

            if (ball.hasCollided(brick)) {
                ball.bounceIfCollision(brick);
                brick.onHit();
                if (brick.isBroken()) {
                    it.remove();
                }
            }
        }
    }

    public boolean isEmpty()
    {
        return bricks.isEmpty();
    }

    @Override
    public void draw(Graphics2D g)
    {
        Iterator it = bricks.listIterator();

        while (it.hasNext()) {
            Brick b = (Brick) it.next();
            b.draw(g);
        }
    }
}
