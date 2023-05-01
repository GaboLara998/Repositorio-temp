package command;

import java.awt.*;
import java.util.ArrayList;

public class CmdTakeSnapShot implements CmdInterface {
    private int instX, instY, instDx, instDy;
    private LinesStateManager originator;
    private Draw receiver;

    private ArrayList<DrawCmdInterface> drawLinesCmd;

    public CmdTakeSnapShot(LinesStateManager originator, ArrayList<DrawCmdInterface> drawLinesCmd) {

    }

    @Override
    public void execute() {

        originator.getMemento(drawLinesCmd);
    }

}
