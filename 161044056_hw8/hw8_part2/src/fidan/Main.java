package fidan;

public class Main {

    public static void main(String[] args) {

        TwoDimensionList myGraph = new TwoDimensionList(5,true);

        myGraph.insert(new Edge(0,1));
        myGraph.insert(new Edge(1,0));
        myGraph.insert(new Edge(1,4));
        myGraph.insert(new Edge(3,0));
        myGraph.insert(new Edge(4,0));
        myGraph.insert(new Edge(4,2));
        myGraph.insert(new Edge(4,3));

        System.out.println("Breadth First Search Start from vertex 1");
        myGraph.breadthFirstSearch(1);
        System.out.println("Depth First Search Start from vertex 0");
        DepthFirstSearch depthSearch= new DepthFirstSearch(myGraph);


/*
        //Create random Graph
        myGraph.createRandomGraph();
        System.out.println("Breadth First Search start from vertex 0:");
        myGraph.breadthFirstSearch(0);
        System.out.println("Depth First Search start from vertex 0:");
        DepthFirstSearch depthSearchRandomGraph = new DepthFirstSearch(myGraph);
*/

    }
}
