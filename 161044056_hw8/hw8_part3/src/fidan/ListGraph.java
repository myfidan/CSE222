package fidan;

import java.util.*;

/**
 * An implementation of a graph that uses an array of lists to represent the edges
 * @author Jacob / Koffman & Wolfgang
 *
 */
public class ListGraph extends AbstractGraph {
    //Data Fields
    /**
     * An array of Lists to contain the edges that originate with each vertex
     */
    private List<Edge>[] edges;

    /**
     * Construct a graph with the specified number of vertices and directionality
     * @param numV The number of vertices
     * @param directed The directionality flag
     */
    @SuppressWarnings("unchecked")
    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new List[numV];
        for(int i = 0; i < numV; i++){
            edges[i] = new LinkedList<Edge>();
        }
    }

    public boolean isEdge(int source, int dest){
        return edges[source].contains(new Edge(source, dest));
    }

    public void insert(Edge edge){
        edges[edge.getSource()].add(edge);
        if(!isDirected()){
            edges[edge.getDest()].add(new Edge(edge.getDest(),
                    edge.getSource(),
                    edge.getWeight()));
        }
    }

    public Iterator<Edge> edgeIterator(int source){
        return edges[source].iterator();
    }

    public Edge getEdge(int source, int dest){
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
        for(Edge edge : edges[source]){
            if(edge.equals(target))
                return edge; //Desired edge found; return it
        }
        //Assert: All edges for source checked.
        return target; //Desired edge not found.
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int end = edges.length;
        for(int i=0; i < end; i++){
            sb.append("Node " + i + "-->\n");
            for(Edge e : edges[i]){
                sb.append("\tnode: " + e.getDest() + ", weight: " + e.getWeight() + "\n");
            }
        }
        return sb.toString();
    }

}