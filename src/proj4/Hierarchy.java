package proj4;

import proj4.DFSActions;

import java.util.LinkedList;
import java.util.Queue;


/**
 *  http://tutorials.jenkov.com/java-collections/queue.html
 *
 */
public class Hierarchy implements DFSActions {

    Queue<String> hier = new LinkedList<String>();


    @Override
    public void cycleDetected() {
        hier.add("*");
    }

    @Override
    public void processVertex(String vertex) {
        hier.add(vertex);
    }

    @Override
    public void ascendVertex(String vertex) {
        hier.add("(");
    }

    @Override
    public void descendVertex(String vertex) {
        hier.add(")");
    }

    @Override
    public String toString() {

        return "";
    }
}
