package brickbreaker.menus.options;

import brickbreaker.Game;
import brickbreaker.Screen;

public class AbandonGameOption extends Option
{
    public AbandonGameOption(Screen screen)
    {
        super(screen, "Main menu");
    }

    public AbandonGameOption(Screen screen, String name)
    {
        super(screen, name);
    }

    public void select(Game game)
    {
        game.exitToMainMenu();
    }
}
