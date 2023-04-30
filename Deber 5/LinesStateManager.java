package command;

import java.util.ArrayList;

public class LinesStateManager {
    private PaintPanel pp;
    private ArrayList<CmdInterface> activeCmds = new ArrayList();
    private LinesStateMemento memento = null;

    private class LinesStateMemento {
        private ArrayList<DrawCmdInterface> cmdsSnapshot = new ArrayList();

        private LinesStateMemento() {

        }

        private void setState() {
            pp.setDrawList(this.cmdsSnapshot);
            pp.repaint();
        }
    }

    public void getMemento(ArrayList<DrawCmdInterface> activeCmds) {

        memento = new LinesStateMemento();
        memento.cmdsSnapshot.clear();
        memento.cmdsSnapshot.addAll(activeCmds);

    }

    public void setPaintPanel(PaintPanel pp) {

        this.pp = pp;
    }

    public void setMemento() {
        memento.setState();
    }

}
