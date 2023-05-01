package command;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BtnUnDo extends JButton implements ActionListener, InvokerInterface {
    private static BtnUnDo singleton = new BtnUnDo();


    private ArrayList<DrawCmdInterface> drawLinesCmd;

    private CmdInterface cmd;

    public static BtnUnDo getButton() {
        return singleton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setCmdCollection(ArrayList<DrawCmdInterface> linesCmd) {

        drawLinesCmd = linesCmd;
    }

    public String getLabel() {
        return this.getText();
    }

    private BtnUnDo() {
        super("UnDo");
    }

}


