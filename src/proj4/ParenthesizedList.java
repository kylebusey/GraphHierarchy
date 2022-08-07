package proj4;

import proj4.DFSActions;

import java.util.LinkedList;
import java.util.Queue;

public class ParenthesizedList implements DFSActions {

    Queue<String> parenList = new LinkedList<String>();

    @Override
    public void cycleDetected() {
        parenList.add("*");
    }

    @Override
    public void processVertex(String vertex) {
        parenList.add(vertex);
    }

    @Override
    public void ascendVertex(String vertex) {
        parenList.add(")");
    }

    @Override
    public void descendVertex(String vertex) {
        parenList.add("(");
    }

    public String toString() {
        return "";

    }


}
