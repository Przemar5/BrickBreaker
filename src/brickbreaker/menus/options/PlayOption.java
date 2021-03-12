package brickbreaker.menus.options;

import brickbreaker.Game;
import brickbreaker.Screen;
import brickbreaker.play.Play;

public class PlayOption extends Option
{
    public PlayOption(Screen screen)
    {
        super(screen, "Play", true);
    }

    public PlayOption(Screen screen, String name)
    {
        super(screen, name, true);
    }

    public void select(Game game)
    {
        game.startNewGame();
    }
}
