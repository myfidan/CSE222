package fidan;


public class DepthFirstSearch {

    //Data Fields
    /**
     * A reference to the graph being searched
     */
    private TwoDimensionList graph;
    /**
     * Array of parents in the depth-first search tree
     */
    private int[] parent;
    /**
     * Flag to indicate whether this vertex has been visited
     */
    private boolean[] visited;
    /**
     * The array that contains each vertex in discovery order
     */
    private int[] discoveryOrder;
    /**
     * The array that contains each vertex in finish order
     */
    private int[] finishOrder;
    /**
     * The index that indicates the discovery order
     */
    private int discoverIndex = 0;
    /**
     * The index that indicates the finish order
     */
    private int finishIndex = 0;

    public DepthFirstSearch(TwoDimensionList graph){
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = -1; //Declare array parent and initialize its elements to -1
        }

        for(int i = 0; i < n; i++){
            if(!visited[i])
                depthFirstSearch(i);
        }
    }

    public void depthFirstSearch(int current) {
        /* Mark the current vertex visited */
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;
        /* Examine each vertex adjacent to the current vertex */
        //Iterator<Edge> itr = graph.edgeIterator(current);
        Node temp = graph.colmHead.get(current);
        while(temp.rnext != null){
            temp = temp.rnext;
            int neighbor = temp.edge.getDest();
            /* Process a neighbor that has not been visited */
            if(!visited[neighbor]){
                /* Insert (current, neighbor) into the depth-first search tree */
                parent[neighbor] = current;
                /* Recursively apply the algorithm starting at neighbor */
                depthFirstSearch(neighbor);
            }
        }
        /* Mark current index finished */
        System.out.println(current);
        finishOrder[finishIndex++] = current;
    }
}
