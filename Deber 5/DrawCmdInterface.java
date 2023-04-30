package command;

import java.awt.*;

public interface DrawCmdInterface extends CmdInterface {
    public int getX();

    public int getY();


    public int getDx();

    public int getDy();

    public Color getColor();

}
