package command;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BtnRenderSnapShot extends JButton implements ActionListener, InvokerInterface {
    private static BtnRenderSnapShot singleton = new BtnRenderSnapShot();

    private ArrayList<DrawCmdInterface> drawLinesCmd;

    private CmdInterface cmd;

    public static BtnRenderSnapShot getButton() {
        return singleton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cmd.execute();
    }

    public void setCommand(CmdInterface cmd) {
        this.cmd = cmd;
    }


    public String getLabel() {
        return this.getText();
    }


    private BtnRenderSnapShot() {
        super("Render Snapshot");
    }
}
