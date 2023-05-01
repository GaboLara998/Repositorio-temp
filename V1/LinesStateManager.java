package command;

import java.util.ArrayList;

public class LinesStateManager {
    private PaintPanel pp;
    private LinesStateMemento memento = null;
    private class LinesStateMemento {
        private ArrayList<CmdInterface> cmdsSnapshot = new ArrayList();

        private LinesStateMemento() {

        }
        private void setState(){

        }
    }

    public void getMemento(ArrayList<CmdInterface> activeCmds) {

         memento =  new LinesStateMemento();

    }

    public void setPaintPanel(PaintPanel pp) {

        this.pp = pp;
    }

    public void setMemento() {
        memento.setState();
    }

}
