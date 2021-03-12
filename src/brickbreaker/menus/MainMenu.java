package brickbreaker.menus;

import brickbreaker.Screen;
import brickbreaker.menus.options.Option;
import brickbreaker.menus.options.PlayOption;
import brickbreaker.menus.options.ExitOption;

import java.awt.event.KeyEvent;

public class MainMenu extends Menu
{
    public MainMenu(Screen screen)
    {
        super(screen, "Brick Breaker", new Option[]{
                new PlayOption(screen),
                new ExitOption(screen),
        });
    }
}
