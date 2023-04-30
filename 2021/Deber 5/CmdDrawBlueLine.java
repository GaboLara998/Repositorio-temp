package command;

import java.awt.*;
import java.util.ArrayList;

public class CmdDrawBlueLine implements DrawCmdInterface {
    private int instX, instY, instDx, instDy;
    private  PaintPanel pp;
    private Draw receiver;
    private ArrayList<DrawCmdInterface> drawLinesCmd;

    public CmdDrawBlueLine(Draw receiver, PaintPanel pp, ArrayList<DrawCmdInterface> drawLinesCmd) {
        this.receiver = receiver;
        this.pp = pp;
        this.drawLinesCmd = drawLinesCmd;
    }

    @Override
    public void execute() {

        receiver.justClicked(true);
        Graphics graphics=pp.getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.drawLine(instX,instY,instDx,instDy);
        pp.repaint();
    }

     @Override
    public void unDo() {

         Graphics graphics=pp.getGraphics();
         if(!drawLinesCmd.isEmpty()){
             DrawCmdInterface lastCMD=drawLinesCmd.get(drawLinesCmd.size()-1);
             graphics.setColor(pp.getBackground());
             graphics.drawLine(lastCMD.getX(), lastCMD.getY(), lastCMD.getX() + lastCMD.getDx(), lastCMD.getY() + lastCMD.getDy());
             drawLinesCmd.remove(lastCMD);

         }
        pp.repaint();
    }

    public int getX() {
        return this.instX;
    }

    public int getY() {
        return this.instY;
    }


    public int getDx() {
        return this.instDx;
    }

    public int getDy() {
        return this.instDy;
    }

    public Color getColor() {
        return Color.BLUE;
    }

}
