package command;

import java.awt.*;

public class CmdRenderSnapShot implements CmdInterface {

    private LinesStateManager originator;

    public CmdRenderSnapShot(LinesStateManager originator) {
        this.originator = originator;
    }

    @Override
    public void execute() {
        originator.setMemento();

    }


}
