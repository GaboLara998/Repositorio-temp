package command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BtnRed extends JButton implements ActionListener, InvokerInterface {
    private static BtnRed singleton = new BtnRed();


    private ArrayList<DrawCmdInterface> drawLinesCmd;

    private DrawCmdInterface cmd;

    public static BtnRed getButton() {
        return singleton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cmd = CommandPattern.getNewRedCmd();
        drawLinesCmd.add(cmd);
        cmd.execute();
    }

    public void setCmdCollection(ArrayList<DrawCmdInterface> linesCmd) {
        drawLinesCmd = linesCmd;
    }

    public String getLabel() {
        return this.getText();
    }


    private BtnRed() {
        super("Red");

    }

}
