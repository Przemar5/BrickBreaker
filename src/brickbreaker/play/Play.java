package brickbreaker.play;

import brickbreaker.Game;
import brickbreaker.Playable;
import brickbreaker.Screen;
import brickbreaker.Settings;
import brickbreaker.menus.Menu;
import brickbreaker.menus.MenuFactory;
import brickbreaker.play.elements.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

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

    public void run()
    {
        running = true;
    }

    public void setWalls(Wall[] walls)
    {
        this.walls = walls;
    }

    public void setBall(Ball ball)
    {
        this.ball = ball;
    }

    public void setPaddle(Paddle paddle)
    {
        this.paddle = paddle;
    }

    public void setBrickBoard(BrickBoard bb)
    {
        this.brickBoard = bb;
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
            onLose(game);
        }
        else if (brickBoard.isEmpty()) {
            onWin(game);
        }
    }

    private void onWin(Game game)
    {
        Menu menu = MenuFactory.createWonGameMenu(game.getScreen());
        game.goToMenu(menu);
    }

    private void onLose(Game game)
    {
        Menu menu = MenuFactory.createLostGameMenu(game.getScreen());
        game.goToMenu(menu);
    }

    private void onEscape(Game game)
    {
        Menu menu = MenuFactory.createGameStopMenu(game.getScreen());
        game.goToMenu(menu);
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
            onEscape(game);
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
