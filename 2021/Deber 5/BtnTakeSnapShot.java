package command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BtnTakeSnapShot extends JButton implements ActionListener, InvokerInterface {
    private static BtnTakeSnapShot singleton = new BtnTakeSnapShot();


    private ArrayList<DrawCmdInterface> drawLinesCmd;

    private CmdInterface cmd;

    public static BtnTakeSnapShot getButton() {
        return singleton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cmd.execute();
    }

    public void setCommand(CmdInterface cmd) {
        this.cmd = cmd;
    }

    public void setCmdCollection(ArrayList<DrawCmdInterface> linesCmd) {
        drawLinesCmd = linesCmd;
    }

    public String getLabel() {
        return this.getText();
    }


    private BtnTakeSnapShot() {
        super("Take Snapshot");
    }

}
