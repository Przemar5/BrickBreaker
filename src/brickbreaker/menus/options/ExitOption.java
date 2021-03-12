package brickbreaker.menus.options;

import brickbreaker.Game;
import brickbreaker.Screen;

public class ExitOption extends Option
{
    public ExitOption(Screen screen)
    {
        super(screen, "Exit");
    }

    public ExitOption(Screen screen, String name)
    {
        super(screen, name);
    }

    public void select(Game game)
    {
        game.stop();
    }
}
