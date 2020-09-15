package fidan;


import java.util.*;

public class TwoDimensionList extends AbstractGraph {

    public List<Node> rowHead;
    public List<Node> colmHead;




    public TwoDimensionList(int numV, boolean directed) {
        super(numV, directed);
        rowHead = new LinkedList<>();
        colmHead = new LinkedList<>();
        for(int i=0; i<numV; i++){
            rowHead.add(new Node(-1,i));
            colmHead.add(new Node(i,-1));
        }
    }



    @Override
    public void insert(Edge e) {

            Node newEdge = new Node(e.getSource(),e.getDest());
            Node temp = rowHead.get(e.getDest());
            while(temp.cnext != null && temp.edge.getSource()< newEdge.edge.getSource()){
                temp = temp.cnext;
            }
            if(temp.cnext == null){
                if(temp.edge.getSource()!=-1){
                    if(temp.edge.getSource()<newEdge.edge.getSource()){
                        newEdge.cnext=temp.cnext;
                        newEdge.cprev=temp;
                        temp.cnext=newEdge;
                    }
                    else{
                        newEdge.cnext=temp;
                        newEdge.cprev=temp.cprev;
                        temp.cprev.cnext=newEdge;
                        temp.cprev=newEdge;
                    }
                }
                else{
                    newEdge.cnext=null;
                    newEdge.cprev=temp;
                    temp.cnext=newEdge;
                }
            }
            else{
                newEdge.cnext=temp;
                newEdge.cprev=temp.cprev;
                temp.cprev.cnext=newEdge;
                temp.cprev=newEdge;
            }

            Node temp2= colmHead.get(e.getSource());
            while(temp2.rnext != null && temp2.edge.getDest()< newEdge.edge.getDest()){
                temp2 = temp2.rnext;
            }
            if(temp2.rnext == null){
                if(temp2.edge.getDest()!=-1){
                    if(temp2.edge.getDest()<newEdge.edge.getDest()){
                        newEdge.rnext=temp2.rnext;
                        newEdge.rprev=temp2;
                        temp2.rnext=newEdge;
                    }
                    else{
                        newEdge.rnext=temp2;
                        newEdge.rprev=temp2.rprev;
                        temp2.rprev.rnext=newEdge;
                        temp2.rprev=newEdge;
                    }

                }
                else{
                    newEdge.rnext=null;
                    newEdge.rprev=temp2;
                    temp2.rnext=newEdge;
                }
            }
            else{
                newEdge.rnext=temp2;
                newEdge.rprev=temp2.rprev;
                temp2.rprev.rnext=newEdge;
                temp2.rprev=newEdge;
            }

        if(!isDirected()){

            int dest=e.getDest();
            int source = e.getSource();
            Edge unDirectedEdge= new Edge(dest,source);


            Node newEdge2 = new Node(unDirectedEdge.getSource(),unDirectedEdge.getDest());
            Node temp3 = rowHead.get(unDirectedEdge.getDest());
            while(temp3.cnext != null && temp3.edge.getSource()< newEdge2.edge.getSource()){
                temp3 = temp3.cnext;
            }
            if(temp3.cnext == null){
                if(temp3.edge.getSource()!=-1){
                    if(temp3.edge.getSource()<newEdge2.edge.getSource()){
                        newEdge2.cnext=temp3.cnext;
                        newEdge2.cprev=temp3;
                        temp3.cnext=newEdge2;
                    }
                    else{
                        newEdge2.cnext=temp3;
                        newEdge2.cprev=temp3.cprev;
                        temp3.cprev.cnext=newEdge2;
                        temp3.cprev=newEdge2;
                    }
                }
                else{
                    newEdge2.cnext=null;
                    newEdge2.cprev=temp3;
                    temp3.cnext=newEdge2;
                }
            }
            else{
                newEdge2.cnext=temp3;
                newEdge2.cprev=temp3.cprev;
                temp3.cprev.cnext=newEdge2;
                temp3.cprev=newEdge2;
            }

            Node temp4= colmHead.get(unDirectedEdge.getSource());
            while(temp4.rnext != null && temp4.edge.getDest()< newEdge2.edge.getDest()){
                temp4 = temp4.rnext;
            }
            if(temp4.rnext == null){
                if(temp4.edge.getDest()!=-1){
                    if(temp4.edge.getDest()<newEdge2.edge.getDest()){
                        newEdge2.rnext=temp4.rnext;
                        newEdge2.rprev=temp4;
                        temp4.rnext=newEdge2;
                    }
                    else{
                        newEdge2.rnext=temp4;
                        newEdge2.rprev=temp4.rprev;
                        temp4.rprev.rnext=newEdge2;
                        temp4.rprev=newEdge2;
                    }

                }
                else{
                    newEdge2.rnext=null;
                    newEdge2.rprev=temp4;
                    temp4.rnext=newEdge2;
                }
            }
            else{
                newEdge2.rnext=temp4;
                newEdge2.rprev=temp4.rprev;
                temp4.rprev.rnext=newEdge2;
                temp4.rprev=newEdge2;
            }

        }
    }

    public void removeEdge(Edge e){

            Node temp = rowHead.get(e.getDest());
            while(temp.cnext != null){
                if(temp.edge.getSource()==e.getSource()) break;
                temp = temp.cnext;
            }
            if(temp.edge.getSource() == e.getSource() && temp.edge.getDest() == e.getDest()){
                if(temp.cnext == null){
                    temp.cprev.cnext = null;
                }
                else{
                    temp.cprev.cnext = temp.cnext;
                    temp.cnext.cprev = temp.cprev;
                }
            }
            Node temp2 = colmHead.get(e.getSource());
            while(temp2.rnext != null){
                if(temp2.edge.getSource()==e.getSource()) break;
                temp2 = temp2.rnext;
            }
            if(temp2.edge.getSource() == e.getSource() && temp2.edge.getDest() == e.getDest()){
                if(temp2.rnext == null){
                    temp2.rprev.rnext = null;
                }
                else{
                    temp2.rprev.rnext = temp2.rnext;
                    temp2.rnext.rprev = temp2.rprev;
                }
            }

        if(!isDirected()){
            int dest=e.getDest();
            int source = e.getSource();
            Edge unDirectedEdge= new Edge(dest,source);

            Node temp3 = rowHead.get(unDirectedEdge.getDest());
            while(temp3.cnext != null){
                if(temp3.edge.getSource()==unDirectedEdge.getSource()) break;
                temp3 = temp3.cnext;
            }
            if(temp3.edge.getSource() == unDirectedEdge.getSource() && temp3.edge.getDest() == unDirectedEdge.getDest()){
                if(temp3.cnext == null){
                    temp3.cprev.cnext = null;
                }
                else{
                    temp3.cprev.cnext = temp3.cnext;
                    temp3.cnext.cprev = temp3.cprev;
                }
            }
            Node temp4 = colmHead.get(unDirectedEdge.getSource());
            while(temp4.rnext != null){
                if(temp4.edge.getSource()==unDirectedEdge.getSource()) break;
                temp4 = temp4.rnext;
            }
            if(temp4.edge.getSource() == unDirectedEdge.getSource() && temp4.edge.getDest() == unDirectedEdge.getDest()){
                if(temp4.rnext == null){
                    temp4.rprev.rnext = null;
                }
                else{
                    temp4.rprev.rnext = temp4.rnext;
                    temp4.rnext.rprev = temp4.rprev;
                }
            }
        }
    }


    public void addVertex(){
        rowHead.add(new Node(-1,getNumV()));
        colmHead.add(new Node(getNumV(),-1));
        numV++;
    }

    public void deleteVertex(int deletedVertex){
        Node temp = rowHead.get(deletedVertex);
        temp = temp.cnext;
        if(temp!=null){
            while(temp != null){
                Node temp2 = temp.cnext;
                removeEdge(temp.edge);
                temp = temp2;
            }
        }
        Node temp3 = colmHead.get(deletedVertex);
        temp3 = temp3.rnext;
        if(temp3!=null){
            while(temp3 != null){
                Node temp4 = temp3.rnext;
                removeEdge(temp3.edge);
                temp3 = temp4;
            }
        }
        rowHead.remove(deletedVertex);
        colmHead.remove(deletedVertex);
        //yeni vertex numaralarını kaydır yarın burdan devam
        for(int i=deletedVertex; i<rowHead.size(); i++){
            Node rowTemp = rowHead.get(i);
            while(rowTemp.cnext !=null){
                rowTemp.edge.setDest(i);
                rowTemp = rowTemp.cnext;
            }
            rowTemp.edge.setDest(i);
        }
        for(int i=deletedVertex; i<colmHead.size(); i++){
            Node colmTemp = colmHead.get(i);
            while(colmTemp.rnext !=null){
                colmTemp.edge.setSource(i);
                colmTemp = colmTemp.rnext;
            }
            colmTemp.edge.setSource(i);
        }
        numV--;
    }

    public int[] breadthFirstSearch(int start){
        Queue<Integer> theQueue = new LinkedList<>();
        int[] parent = new int[numV];
        for(int i=0; i<numV; i++){
            parent[i] = -1;
        }
        boolean[] identified = new boolean[numV];
        identified[start]=true;
        theQueue.offer(start);

        while(!theQueue.isEmpty()){
            int current = theQueue.remove();
            System.out.println(current);
            Node temp = colmHead.get(current);
            while(temp != null){
                if(temp.edge.getDest()!=-1){
                    if(!identified[temp.edge.getDest()]){
                        identified[temp.edge.getDest()]=true;
                        theQueue.offer(temp.edge.getDest());
                    }
                }
                temp = temp.rnext;
            }/*
            if(theQueue.isEmpty()){
                for(int i=0; i<identified.length; i++){
                    if(identified[i]==false){
                        theQueue.offer(i);
                        identified[i]=true;
                        break;
                    }
                }
            }
            */
        }


        return parent;
    }

    public void createRandomGraph(){
        Random rand = new Random();
        int randomEdgeNum;
        if(isDirected())
        {
            System.out.println("Directed Graph");
            randomEdgeNum = rand.nextInt(numV*numV);
        }
        else{
            System.out.println("unDirected Graph");
            randomEdgeNum = rand.nextInt((numV*numV)/2);
        }
        List<Edge> edgeArray = new ArrayList<>();
        System.out.println("Vertex number = "+numV);
        for(int i=0; i<randomEdgeNum; i++){
            int randSource = rand.nextInt(numV);
            int randDest = rand.nextInt(numV);
            if(isDirected()){
                Edge newEdge = new Edge(randSource,randDest);
                boolean flag=true;
                for(int j=0; j<edgeArray.size(); j++){
                    if(edgeArray.get(j).getSource()==newEdge.getSource() && edgeArray.get(j).getDest()==newEdge.getDest()){
                        flag = false;
                    }
                }
                if(flag){
                    edgeArray.add(newEdge);
                    insert(newEdge);
                    System.out.println(newEdge.getSource()+","+newEdge.getDest());
                }
            }
            else{
                Edge newEdge = new Edge(randSource,randDest);
                Edge newEdge2 = new Edge(randDest,randSource);
                boolean flag=true;
                for(int j=0; j<edgeArray.size(); j++){
                    if((edgeArray.get(j).getSource()==newEdge.getSource() && edgeArray.get(j).getDest()==newEdge.getDest()) ||
                            (edgeArray.get(j).getSource()==newEdge2.getSource() && edgeArray.get(j).getDest()==newEdge2.getDest())){
                        flag = false;
                    }
                }
                if(flag){
                    edgeArray.add(newEdge);
                    edgeArray.add(newEdge2);
                    insert(newEdge);
                    System.out.println(newEdge.getSource()+","+newEdge.getDest());
                }
            }
        }
    }

    @Override
    public boolean isEdge(int source, int dest) {
        if(source>colmHead.size()) return false;
        Node temp = colmHead.get(source);
        while(temp.rnext != null){
            if(temp.edge.getSource()==source && temp.edge.getDest()==dest) return true;
            temp = temp.rnext;
        }
        return false;
    }

    @Override
    public Edge getEdge(int source, int dest) {
        if(source>colmHead.size()) return null;
        Node temp = colmHead.get(source);
        while(temp.rnext != null){
            if(temp.edge.getSource()==source && temp.edge.getDest()==dest) return temp.edge;
            temp = temp.rnext;
        }
        return null;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return super.edgeIterator(source);
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<rowHead.size(); i++){
            Node temp= rowHead.get(i);
            while(temp.cnext!=null){
                temp=temp.cnext;
                result.append(temp.edge.getSource()+" "+temp.edge.getDest()+"\n");
            }
        }
        return result.toString();
    }
}
