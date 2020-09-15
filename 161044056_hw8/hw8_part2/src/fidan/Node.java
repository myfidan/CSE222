package fidan;

public class Node{
    public Edge edge;
    public Node rprev;
    public Node rnext;
    public Node cprev;
    public Node cnext;

    public Node(){
        edge=new Edge(0,0);
        rprev=null;
        rnext=null;
        cprev=null;
        cnext=null;
    }

    public Node(int source,int destination){
        edge=new Edge(source,destination);
        rprev=null;
        rnext=null;
        cprev=null;
        cnext=null;
    }

    public Node(int source,int destination,double weight){
        edge=new Edge(source,destination,weight);
        rprev=null;
        rnext=null;
        cprev=null;
        cnext=null;
    }

}
