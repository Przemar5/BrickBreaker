package brickbreaker.menus;

import brickbreaker.Screen;
import brickbreaker.menus.options.AbandonGameOption;
import brickbreaker.menus.options.Option;
import brickbreaker.menus.options.PlayOption;

public class GameFinishMenu extends Menu
{
    public GameFinishMenu(Screen screen, String title)
    {
        super(screen, title, new Option[]{
                new PlayOption(screen, "Play again"),
                new AbandonGameOption(screen),
        });
    }
}
