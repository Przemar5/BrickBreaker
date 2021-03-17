package brickbreaker.play;

import brickbreaker.Game;
import brickbreaker.Screen;
import brickbreaker.Settings;
import brickbreaker.play.elements.Ball;
import brickbreaker.play.elements.BrickBoard;
import brickbreaker.play.elements.Paddle;
import brickbreaker.play.elements.Wall;

import java.awt.*;
import java.util.HashMap;

public class PlayFactory
{
    public static Play createFromSettings(Game game, Settings settings)
    {
        Play play = new Play(game);
        Screen screen = game.getScreen();

        Paddle paddle = PlayFactory.createPaddleFromScreenObjAndSettings(screen, settings);
        Ball ball = PlayFactory.createBallFromScreenObjAndSettings(screen, settings);
        Wall[] walls = PlayFactory.createWallsFromScreenObjAndSettings(screen, settings);
        BrickBoard bb = PlayFactory.createBrickBoardFromScreenObjAndSettings(screen, settings);

        play.setPaddle(paddle);
        play.setBall(ball);
        play.setWalls(walls);
        play.setBrickBoard(bb);
        return play;
    }

    private static Paddle createPaddleFromScreenObjAndSettings(
            Screen screen, Settings settings)
    {
        Paddle paddle = new Paddle(
                (int) ((screen.getWidth() - settings.paddle.width) / 2),
                screen.getHeight() - 40,
                settings.paddle.width, 20,
                settings.paddle.color,
                settings.paddle.speedLimit,
                settings.paddle.accX);
        paddle.setLeftBound(settings.wallWidth);
        paddle.setRightBound(screen.getWidth() - settings.wallWidth);
        return paddle;
    }

    private static Ball createBallFromScreenObjAndSettings(
            Screen screen, Settings settings)
    {
        return new Ball(
                (int) (screen.getWidth() / 2),
                (int) (screen.getHeight() / 2),
                settings.ball.radius,
                settings.ball.velX,
                settings.ball.velY,
                settings.ball.color);
    }

    private static Wall[] createWallsFromScreenObjAndSettings(
            Screen screen, Settings settings)
    {
        return new Wall[]{
                new Wall(0, 0, settings.wallWidth, screen.getHeight()),
                new Wall(0, 0, screen.getWidth(), settings.wallWidth),
                new Wall(screen.getWidth() - settings.wallWidth,
                        0, settings.wallWidth, screen.getHeight()),
        };
    }

    private static BrickBoard createBrickBoardFromScreenObjAndSettings(
            Screen screen, Settings settings)
    {
        HashMap<Integer, Color> colors = settings.bricks.getBasicLivesColorMap();
        return new BrickBoard(
                new int[][]{{1, 2, 3}, {2, 0, 0}, {1, 2, 1}, {3, 3, 3}},
                screen.getWidth() - 4*settings.wallWidth,
                screen.getHeight()/3,
                2*settings.wallWidth,
                colors);
    }
}
