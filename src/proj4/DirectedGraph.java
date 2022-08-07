package proj4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This project takes in a text file of class names and outputs the dependencies needed for each class.
 * This file builds a graph of the classes and builds the vertices and edges needed for it to exist.
 *
 *
 */


//start of class
public class DirectedGraph<T> {


    private static final int MAX_VERTICES = 25;
    List<List<Integer>> edges = new ArrayList<>();
    HashMap<String, Integer> stringID = new HashMap<>();
    ParenthesizedList parenList = new ParenthesizedList();
    Hierarchy hierList = new Hierarchy();

    private int numVertices;

    private boolean[] marked = new boolean[MAX_VERTICES];//mark array to mark vertices
    ArrayList<String> markedList = new ArrayList<>();
    StringBuilder dfsOutput = new StringBuilder();


    /**
     * This is the directedGraph overloaded constructor which builds the edges and vertices of the graph
     * to the capacity of maxV.
     *
     */
    public DirectedGraph(File file1) throws FileNotFoundException {
        constructGraph(getByLine(file1));

        for(int i = 0; i < marked.length; i++) {
            marked[i] = false;

        }
    }

    public void constructGraph(ArrayList<String[]> list) {

        for(String[] nextToken: list) {
            for(int i = 0; i < nextToken.length; i++) {
                addVertex(nextToken[i]);

                if(i != 0) {
                    addEdge(nextToken[0], nextToken[i]);
                }

            }
        }
    }


    public void addVertex(String vertex) {

            if(!stringID.containsKey(vertex)) {
                stringID.put(vertex, numVertices);
                numVertices++;
                edges.add(new ArrayList<Integer>());
            }
        }

    public void addEdge(String start, String end) {

        int startIndex = stringID.get(start);
        int endIndex = stringID.get(end);

        edges.get(startIndex).add(endIndex);

    }

    public ArrayList<String[]> getByLine(File file1) throws FileNotFoundException {

        Scanner keyboard = new Scanner(file1);
        ArrayList<String[]> fileByLine = new ArrayList<>();
        StringTokenizer st;
        int lineCount = 0;
        while(keyboard.hasNext()) {
                String[] byLine = keyboard.nextLine().split(" ");

                fileByLine.add(lineCount, byLine);
                lineCount++;
                System.out.println("There are: "+ byLine.length + " tokens on line "+ lineCount+".");
        }
        return fileByLine;
    }


    public void dfs(int startIndex) {

        if(marked[startIndex] = true) {
            hierList.cycleDetected();
            parenList.cycleDetected();
            return;
        }

        marked[startIndex] = true;

        dfsOutput.append(vertexFromIndex(startIndex)).append(" ");
        markedList.add(vertexFromIndex(startIndex));

        for (ListIterator<Integer> it = edges.get(startIndex).listIterator(); it.hasNext(); ) {
            Integer nextInt = it.next();

            if(!marked[nextInt]) {
                dfs(nextInt);
            }

        }
    }

    public void printLists() {
        //System.out.println(hierList.toString());
        System.out.println(parenList.toString());
    }

    public String getDfsOutput() {
        return dfsOutput.toString();
    }


    private String vertexFromIndex(int startVertex) {
        for (String vertexName : stringID.keySet()) {
            if (stringID.get(vertexName).equals(startVertex)) {
                return vertexName;
            }
        }
        return "";
    }

    public void printUnreachableClasses() {

    }



}
