package proj4;

import proj4.DirectedGraph;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 */


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        JFileChooser fileSelector = new JFileChooser();
        File file1 = null;
        int returnValue = fileSelector.showOpenDialog(null);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
            file1 = fileSelector.getSelectedFile();
        } else {
            throw new FileNotFoundException();
        }

        DirectedGraph graph1 = new DirectedGraph(file1);
        graph1.dfs(0);
        graph1.getDfsOutput();
        graph1.printUnreachableClasses();
        graph1.printLists();







    }
}
