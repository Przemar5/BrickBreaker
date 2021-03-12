package brickbreaker.menus.options;

import brickbreaker.Drawable;
import brickbreaker.Game;
import brickbreaker.Screen;

import java.awt.*;

public class Option implements Drawable
{
    private Screen screen;
    private String name;
    private int x;
    private int y;
    private boolean focus = false;

    public Option(Screen screen, String name, boolean focus)
    {
        this.screen = screen;
        this.name = name;
        this.focus = focus;
    }

    public Option(Screen screen, String name)
    {
        this.screen = screen;
        this.name = name;
    }

    @Override
    public void draw(Graphics2D g) {
        Window w = screen.getFullScreenWindow();

        if (focus) {
            g.setColor(w.getForeground());
            g.fillRect(x, y-36, 360, 54);
            g.setColor(w.getBackground());
            g.drawString(name, x+12, y);
        }
        else {
            g.setColor(w.getForeground());
            g.drawString(name, x, y);
        }
    }

    public void focusIn()
    {
        focus = true;
    }

    public void focusOut()
    {
        focus = false;
    }

    public void select(Game game)
    {
        //
    }

    public void select()
    {
        //
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}
