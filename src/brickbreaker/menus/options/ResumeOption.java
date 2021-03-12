package brickbreaker.menus.options;

import brickbreaker.Game;
import brickbreaker.Screen;

public class ResumeOption extends Option
{
    public ResumeOption(Screen screen)
    {
        super(screen, "Resume", true);
    }

    public ResumeOption(Screen screen, String name)
    {
        super(screen, name, true);
    }

    public void select(Game game)
    {
        game.startPlaying();
    }
}
