package brickbreaker.menus;

import brickbreaker.Screen;
import brickbreaker.menus.options.*;

public class PlayStopMenu extends Menu
{
    public PlayStopMenu(Screen screen)
    {
        super(screen, "Paused", new Option[]{
                new ResumeOption(screen),
                new AbandonGameOption(screen),
        });
    }
}
