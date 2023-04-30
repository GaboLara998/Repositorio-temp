package command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author dfellig
 */
public class CommandPattern {

    private JLabel jlab;
    private static PaintPanel pp;
    private static Draw drawCommand;
    private static CommandPattern cmdPattern = null;

    private LinesStateManager originator;
    private static ArrayList<DrawCmdInterface> drawLinesCmds = new ArrayList<>();
    private ArrayList<DrawCmdInterface> redoLinesCmd = new ArrayList<>();

    private static ArrayList<InvokerInterface> invokers = new ArrayList<>();


    public static DrawCmdInterface getNewRedCmd() {
        return new CmdDrawRedLine(drawCommand, pp, drawLinesCmds);
    }

    public static DrawCmdInterface getNewBlueCmd() {
        return new CmdDrawBlueLine(drawCommand, pp, drawLinesCmds);
    }

    public static void setInvokers(InvokerInterface invokerBtn) {

        invokers.add(invokerBtn);
    }


    CommandPattern() {

        pp = new PaintPanel();
        drawCommand = new Draw(pp);
        originator = new LinesStateManager();
        originator.setPaintPanel(pp);
        CmdInterface cmdTakeSnapShot = new CmdTakeSnapShot(originator, drawLinesCmds);
        CmdInterface cmdRenderSnapShot = new CmdRenderSnapShot(originator);

        JButton btnRed = BtnRed.getButton();
        btnRed.addActionListener((ActionListener) btnRed);
        JButton btnBlue = BtnBlue.getButton();
        btnBlue.addActionListener((ActionListener) btnBlue);
        JButton btnUnDo = BtnUnDo.getButton();
        ((BtnUnDo) btnUnDo).setCmdCollection(drawLinesCmds);
        btnUnDo.addActionListener((ActionListener) btnUnDo);
        JButton btnTakeSnapShot = BtnTakeSnapShot.getButton();

        ((BtnTakeSnapShot) btnTakeSnapShot).setCommand(cmdTakeSnapShot);
        btnTakeSnapShot.addActionListener((ActionListener) btnTakeSnapShot);

        JButton btnRenderSnapShot = BtnRenderSnapShot.getButton();
        ((BtnRenderSnapShot) btnRenderSnapShot).setCommand(cmdRenderSnapShot);
        btnRenderSnapShot.addActionListener((ActionListener) btnRenderSnapShot);


        JFrame jfrm = new JFrame("Command Pattern");

        jfrm.setLocation(300, 200);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout ppLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        pp.setLayout(ppLayout);

        for (InvokerInterface inv : invokers) {
            String label = inv.getLabel();
            switch (label) {
                case "UnDo":
                    inv.setCmdCollection(drawLinesCmds);
                    break;
                case "Red":
                    inv.setCmdCollection(drawLinesCmds);
                    break;
                case "Blue":
                    inv.setCmdCollection(drawLinesCmds);
                    break;
                case "Take Snapshot":
                    inv.setCmdCollection(drawLinesCmds);
                    break;
                case "Render Snapshot":
                    inv.setCmdCollection(drawLinesCmds);
                    break;
            }
        }

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.insets = new Insets(350, 10, 10, 50);
        jfrm.add(pp);
        pp.setDrawList(drawLinesCmds);
        pp.add(btnUnDo, gbc);
        gbc.gridx = 2;
        pp.add(btnBlue, gbc);
        gbc.gridx = 3;
        pp.add(btnRed, gbc);
        gbc.gridx = 4;
        pp.add(btnTakeSnapShot, gbc);
        gbc.gridx = 5;

        gbc.insets = new Insets(350, 10, 10, 10);

        pp.add(btnRenderSnapShot, gbc);
        jfrm.pack();
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                new CommandPattern();
            }
        });
    }
}
