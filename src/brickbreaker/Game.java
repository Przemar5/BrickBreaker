package brickbreaker;

import brickbreaker.menus.GameFinishMenu;
import brickbreaker.menus.Menu;
import brickbreaker.menus.MainMenu;
import brickbreaker.menus.PlayStopMenu;
import brickbreaker.play.Play;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Core implements KeyListener, Drawable
{
    private static Game game;
    private String msg = "";
    private Playable controllable;
    private boolean playing = false;
    private Menu menu;
    private Play play;

    public void init()
    {
        super.init();
        Window w = screen.getFullScreenWindow();
        w.setFocusTraversalKeysEnabled(false);
        w.addKeyListener(this);
//        msg = "Press escape to exit";
        menu = new MainMenu(screen);
        play = new Play(this);
    }
    
    public void exitToMenu(Menu m)
    {
        menu = m;
        playing = false;
    }

    public void exitToMainMenu()
    {
        exitToMenu(new MainMenu(screen));
    }

    public void exitToPlayMenu()
    {
        exitToMenu(new PlayStopMenu(screen));
    }

    public void exitToWinMenu()
    {
        exitToMenu(new GameFinishMenu(screen, "You have won!"));
    }

    public void exitToFailMenu()
    {
        exitToMenu(new GameFinishMenu(screen, "You have losed!"));
    }

    public void startPlaying()
    {
        playing = true;
    }

    public void stopPlaying()
    {
        playing = true;
    }

    public void startNewGame()
    {
        play = new Play(this);
        playing = true;
        play.init();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        e.consume();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        if (!playing) {
            menu.keyPressed(e, this);
        }
        else {
            play.keyPressed(e, this);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        msg = "Released: " + KeyEvent.getKeyText(keyCode);
        e.consume();
    }

    public synchronized void draw(Graphics2D g)
    {
        if (!playing) {
            menu.draw(g);
        }
        else {
            play.update();
            play.draw(g);
        }
    }

    public Play getPlay()
    {
        return play;
    }
}
