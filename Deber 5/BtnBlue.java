package command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BtnBlue extends JButton implements ActionListener, InvokerInterface {
    private static BtnBlue singleton = new BtnBlue();

    private ArrayList<DrawCmdInterface> drawLinesCmd;

    private DrawCmdInterface cmd;

    public static BtnBlue getButton() {
        return singleton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cmd = CommandPattern.getNewBlueCmd();

        cmd.execute();
    }

    public void setCmdCollection(ArrayList<DrawCmdInterface> linesCmd) {
        drawLinesCmd = linesCmd;
    }

    public String getLabel() {
        return this.getText();
    }


    private BtnBlue() {
        super("Blue");
        CommandPattern.setInvokers(this);
    }

}
