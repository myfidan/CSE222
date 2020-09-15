package fidan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {

    /**
     * Dijkstra's Shortest Path algorithm From the course book
     * pre: graph to be searched is a weighted directed graph with only positive weights
     * 		pred and dist are arrays of size V
     * @param graph The weighted graph to be searched
     * @param start The start vertex
     * @param pred Output array to contain the predecessors in the shortest path
     * @param dist Output array to contain the distance in the shortest path
     */
    public static void dijkstrasAlgorithm(Graph graph,
                                          int start,
                                          int[] pred,
                                          double[] dist){
        int numV = graph.getNumV();
        HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
        //Initialize V - S
        for(int i = 0; i < numV; i++){
            if(i != start)
                vMinusS.add(i);
        }
        // Initialize pred and dist
        for(int v : vMinusS){
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }
        //Main loop
        while(vMinusS.size() != 0){
            //Find the value u in V - S with the smallest dist[u]
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for(int v : vMinusS){
                if(dist[v] < minDist){
                    minDist = dist[v];
                    u = v;
                }
            }
            // Remove u from vMinusS
            vMinusS.remove(u);
            //Update the distances
            Iterator<Edge> edgeIter = graph.edgeIterator(u);
            while(edgeIter.hasNext()){
                Edge edge = edgeIter.next();
                int v = edge.getDest();
                if(vMinusS.contains(v)){
                    double weight = edge.getWeight();
                    if(dist[u] + weight < dist[v]){
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        File file = new File("graph.txt");
        FileReader freader = new FileReader(file);
        BufferedReader br = new BufferedReader(freader);
        int c = 0;
        List<List<Character>> txtArray = new ArrayList<>();
        txtArray.add(new ArrayList<>());
        int index=0;
        while((c = br.read()) != -1){
            char character = (char) c;
            if(character == '\n'){

                txtArray.add(new ArrayList<>());
                index++;
            }
            else{
                txtArray.get(index).add(character);
            }
        }
        int vertexNum = 0;
        List<Coordinat> coordinatArray = new ArrayList<>();
        for(int i=0; i<txtArray.size(); i++){
            for(int j=0; j<txtArray.get(i).size(); j++){
                if(i==0 && j==0){
                    coordinatArray.add(new Coordinat(i,j,vertexNum));
                    ++vertexNum;
                }
                else if(i==txtArray.size()-1 && j==txtArray.get(i).size()-1){
                    coordinatArray.add(new Coordinat(i,j,vertexNum));
                    ++vertexNum;
                }
                else if(txtArray.get(i).get(j) == '0'){
                    if(i != txtArray.size()-1 && j != txtArray.get(i).size()-1 && txtArray.get(i).get(j+1) == '0' && txtArray.get(i+1).get(j) == '0')   {
                        coordinatArray.add(new Coordinat(i,j,vertexNum));
                        ++vertexNum;
                    }
                    else if(i != txtArray.size()-1 && j != 0 && txtArray.get(i).get(j-1) == '0' && txtArray.get(i+1).get(j) == '0'){
                        coordinatArray.add(new Coordinat(i,j,vertexNum));
                        ++vertexNum;
                    }
                    else if(i != 0 && j != 0 && txtArray.get(i).get(j-1) == '0' && txtArray.get(i-1).get(j) == '0'){
                        coordinatArray.add(new Coordinat(i,j,vertexNum));
                        ++vertexNum;
                    }
                    else if(i != 0 && j != txtArray.get(i).size()-1 && txtArray.get(i).get(j+1) == '0' && txtArray.get(i-1).get(j) == '0'){
                        coordinatArray.add(new Coordinat(i,j,vertexNum));
                        ++vertexNum;
                    }
                }
            }
        }
        int edgeNum = 0;
        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<coordinatArray.size(); i++){
            int y = coordinatArray.get(i).getY();
            int x = coordinatArray.get(i).getX();
            //look right vertex
            int right=0;
            while(y<txtArray.get(x).size()-1){
                y++;
                right++;
                if(txtArray.get(x).get(y) == '1') break;
                boolean flag=false;
                for(int j=0; j<coordinatArray.size(); j++){
                    if(coordinatArray.get(j).getX()== x && coordinatArray.get(j).getY()==y){
                        edges.add(new Edge(i,coordinatArray.get(j).getCoordinatVertexNum(),right));
                        ++edgeNum;
                        flag=true;
                        break;
                    }
                }
                if(flag) break;
            }
            int y2 = coordinatArray.get(i).getY();
            int x2 = coordinatArray.get(i).getX();
            //look left vertex
            int left=0;
            while(y2>0){
                y2--;
                left++;
                if(txtArray.get(x2).get(y2) == '1') break;
                boolean flag=false;
                for(int j=0; j<coordinatArray.size(); j++){
                    if(coordinatArray.get(j).getX()== x2 && coordinatArray.get(j).getY()==y2){
                        edges.add(new Edge(i,coordinatArray.get(j).getCoordinatVertexNum(),left));
                        ++edgeNum;
                        flag=true;
                        break;
                    }
                }
                if(flag) break;
            }

            int y3 = coordinatArray.get(i).getY();
            int x3 = coordinatArray.get(i).getX();
            //look up vertex
            int up=0;
            while(x3>0){
                x3--;
                up++;
                if(txtArray.get(x3).get(y3) == '1') break;
                boolean flag=false;
                for(int j=0; j<coordinatArray.size(); j++){
                    if(coordinatArray.get(j).getX()== x3 && coordinatArray.get(j).getY()==y3){
                        edges.add(new Edge(i,coordinatArray.get(j).getCoordinatVertexNum(),up));
                        ++edgeNum;
                        flag=true;
                        break;
                    }
                }
                if(flag) break;
            }

            int y4 = coordinatArray.get(i).getY();
            int x4 = coordinatArray.get(i).getX();
            //look down vertex
            int down=0;
            while(x4<txtArray.size()-1){
                x4++;
                down++;
                if(txtArray.get(x4).get(y4) == '1') break;
                boolean flag=false;
                for(int j=0; j<coordinatArray.size(); j++){
                    if(coordinatArray.get(j).getX()== x4 && coordinatArray.get(j).getY()==y4){
                        edges.add(new Edge(i,coordinatArray.get(j).getCoordinatVertexNum(),down));
                        ++edgeNum;
                        flag=true;
                        break;
                    }
                }
                if(flag) break;
            }

        }
        System.out.println("Vertex size = "+vertexNum);
        System.out.println("Edge size = "+edgeNum);

        Graph myGraph;
        //Dense graph
        if(vertexNum*vertexNum/2<edgeNum){
            myGraph = new MatrixGraph(vertexNum,true);
        }//sparse graph
        else{
            myGraph = new ListGraph(vertexNum,true);
        }
        for(int i=0; i<edges.size(); i++){
            myGraph.insert(edges.get(i));
        }

        int[] pred=new int[vertexNum];
        double[] dist=new double[vertexNum];
        dijkstrasAlgorithm(myGraph,0,pred,dist);
        System.out.println("Node, Predecessor, and Distance:");
        for(int i = 0; i < pred.length; i++){
            System.out.println(i + ":\t" + pred[i] + "\t" + dist[i]);
        }
        System.out.println("\nFrom Upper-left(begin) to lower-right(finish) distant = "+dist[pred.length-1]);

    }
}
