package brickbreaker.play;

import brickbreaker.Game;
import brickbreaker.Playable;
import brickbreaker.Screen;
import brickbreaker.play.elements.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Play implements Playable
{
    private Game game;
    private Paddle paddle;
    private Ball ball;
    private Wall[] walls;
    private int wallWidth = 20;
    private BrickBoard brickBoard;

    private boolean running = false;

    public Play(Game game)
    {
        this.game = game;
    }

    public void init()
    {
        Screen screen = game.getScreen();

        running = true;
        paddle = new Paddle((int) (screen.getWidth() / 2) - 60,
                screen.getHeight() - 40, 120, 20);
        paddle.setLeftBound(wallWidth);
        paddle.setRightBound(screen.getWidth() - wallWidth);
        ball = new Ball((int) (screen.getWidth() / 2),
                (int) (screen.getHeight() / 2), 40, -2, -3);
        walls = new Wall[]{
                new Wall(0, 0, wallWidth, screen.getHeight()),
                new Wall(0, 0, screen.getWidth(), wallWidth),
                new Wall(screen.getWidth() - wallWidth,
                        0, wallWidth, screen.getHeight()),
        };
        brickBoard = new BrickBoard(7, 16, screen.getWidth()-4*wallWidth,
                screen.getHeight()/3, 2*wallWidth);
    }

    @Override
    public void update()
    {
        paddle.update();
        updateBall();
        checkGameResult();
    }

    private void updateBall()
    {
        ball.bounceIfCollision(paddle);
        for (Wall w: walls) {
            ball.bounceIfCollision(w);
        }
        brickBoard.handleCollision(ball);
        ball.update();
    }

    private void checkGameResult()
    {
        Screen s = game.getScreen();
        if (ball.y + ball.height >= s.getHeight()) {
            game.exitToFailMenu();
        }
        else if (brickBoard.isEmpty()) {
            game.exitToWinMenu();
        }
    }

    @Override
    public void draw(Graphics2D g)
    {
        clearScreen(g);
        paddle.draw(g);
        ball.draw(g);

        for (Wall w: walls) {
            w.draw(g);
        }
        brickBoard.draw(g);
    }

    public void clearScreen(Graphics2D g)
    {
        Screen s = game.getScreen();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, s.getWidth(), s.getHeight());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e, Game game)
    {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ESCAPE) {
            game.exitToPlayMenu();
        }
        else if (keyCode == KeyEvent.VK_LEFT) {
            paddle.accelerateLeft();
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            paddle.accelerateRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
