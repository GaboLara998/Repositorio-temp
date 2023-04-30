package command;

import java.util.ArrayList;

public interface InvokerInterface {
    public String getLabel();


    public default void setCmdCollection(ArrayList<DrawCmdInterface> linesCmd) {

    }

}
