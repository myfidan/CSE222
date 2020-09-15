import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSystemTree{
    FileNode root;

    /**
     * FileNode class for my tree structure
     */
    protected static class FileNode{
        protected String name;
        protected List<FileNode> children=new ArrayList<>();
        protected boolean Isdirectory;// 1 if node is a directory 0 if node is a file
        protected FileNode prev;//for access parent of a child node like a double linklist
    }

    /**
     * For create constructor
     * @param rootDirectory root directory
     */
    public FileSystemTree(String rootDirectory){
        FileNode temp=new FileNode();
        temp.name=rootDirectory;
        temp.Isdirectory=true;//its a directory
        temp.prev=null;
        root=temp;
    }

    /**
     *Tokenize given path and add last token(directory) to corresponding path
     * @param path Adding path
     */
    public void addDir(String path){
        String[] tokens = path.split("/");

        if(tokens.length==2){//There is only root
            FileNode addThis=new FileNode();
            addThis.name=tokens[tokens.length-1];
            addThis.Isdirectory=true;
            addThis.prev=root;
            root.children.add(addThis);
        }
        else{
            FileNode temp=root;
            boolean flag=false;

            for(int i=1; i<tokens.length-1; i++){
                for(int j=0; j<temp.children.size(); j++){
                    if(tokens[i].equals(temp.children.get(j).name)){
                        temp=temp.children.get(j);
                        //check previous node is a directory or file? if its a file cant add new node a file
                        if(temp.Isdirectory){
                            flag=true;
                        }
                        else{
                            flag=false;
                        }
                        break;
                    }
                }
            }
            if(flag){
                FileNode addThis=new FileNode();
                addThis.name=tokens[tokens.length-1];
                addThis.Isdirectory=true;
                addThis.prev=temp;
                temp.children.add(addThis);
                //System.out.println(addThis.name);
            }
            else{
                //System.out.println("Error");
            }
        }


    }

    /**
     * Tokenize given path and add last token(File) to corresponding path
     * @param path Given path
     * @throws IllegalArgumentException if you try add a file to a file node it throws an illegalArgumentExeption
     */
    public void addFile(String path) throws IllegalArgumentException{
        String[] tokens = path.split("/");

        if(tokens.length==2){//There is only root
            FileNode addThis=new FileNode();
            addThis.name=tokens[tokens.length-1];
            addThis.Isdirectory=false;
            addThis.prev=root;
            root.children.add(addThis);
        }
        else{
            FileNode temp=root;
            boolean flag=false;

            for(int i=1; i<tokens.length-1; i++){
                for(int j=0; j<temp.children.size(); j++){
                    if(tokens[i].equals(temp.children.get(j).name)){
                        temp=temp.children.get(j);
                        //check previous node is a directory or file? if its a file cant add new node a file
                        if(temp.Isdirectory){
                            flag=true;
                        }
                        else{
                            flag=false;
                        }
                        break;
                    }
                }
            }
            if(flag){
                FileNode addThis=new FileNode();
                addThis.name=tokens[tokens.length-1];
                addThis.Isdirectory=false;
                addThis.prev=temp;
                temp.children.add(addThis);
            }
            else{
                throw new IllegalArgumentException();
            }
        }

    }

    /**
     * My remove method its delete given path node
     * if this node has some child nodes it print this child nodes and ask user to wheather it is sure
     * delete or not (if user enter 1 it delete these node so its children too)
     * if given path has not some child nodes than it is remove this node directly without asking user.
     * @param path given string for deleted node path
     */
    public void remove(String path){
        String[] tokens = path.split("/");
        StringBuilder result=new StringBuilder();
        removeWrapper(root,tokens[tokens.length-1],result,0);
        String[] tokens2=result.toString().split("-");
        if(tokens2.length>1){
            System.out.println("If you Delete "+tokens2[0]+" you will delete these nodes:");
            for(int i=0; i<tokens2.length; i++){
                System.out.println(tokens2[i]);
            }
            System.out.println("If you Accept to delete operation enter 1,if you not enter 0:");
            int choose;
            Scanner input= new Scanner(System.in);
            choose=input.nextInt();

            if(choose==1){
                removeNode(root,tokens2[0]);
            }
        }
        else if(tokens2.length==1){
            System.out.println(tokens2[0]+" Deleted");
            removeNode(root,tokens2[0]);

        }
        else{
            System.out.println("Cant found this path..");
        }


    }

    /**
     * Helper method for my remove method
     * This method find if there are more nodes that connect to the node which will delete
     * @param root root node of my structure
     * @param path path of deleted node
     * @param result list of strings that hold deleted nodes connections
     * @param flag flag for check
     */
    public void removeWrapper(FileNode root,String path,StringBuilder result,int flag){
        if(root==null){
            return;
        }
        if(root.name.equals(path)){
            flag=1;
        }
        if(flag==1){
            result.append(root.name+"-");
        }

        for(int i=0; i<root.children.size(); i++){
            removeWrapper(root.children.get(i),path,result,flag);
        }

    }

    /**
     * My second helper method for remove method this method remove given string
     * @param root root of the strutcture
     * @param find deleted node name
     */
    public void removeNode(FileNode root,String find){

        if(root.name.equals(find)){
            for(int i=0; i<root.prev.children.size(); i++){
                if(root.prev.children.get(i).name.equals(find)){
                    root.prev.children.remove(i);
                    break;
                }
            }
            root.prev=null;
            return;
        }

        for(int i=0; i<root.children.size(); i++){
            removeNode(root.children.get(i),find);
        }

    }

    /**
     * Search given string into structure and print all paths for founded string
     * @param find String that we will search
     */
    public void Search(String find){
        StringBuilder result=new StringBuilder();
        //result.append(root.name+"/");
        searchWrapped(root,find,result,0);
    }

    /**
     * my wrapper recursive function for search
     * @param root root Node
     * @param find Searcing string
     * @param result StringBuilder that hold paths for given string path
     * @param index
     */
    public void searchWrapped(FileNode root,String find,StringBuilder result,int index){
        //System.out.println(result.toString());
        for(int i=0; i<root.children.size(); i++){
            //result.append(root.children.get(i).name);

            searchWrapped(root.children.get(i),find,result,index);
            if(root.children.get(i).name.contains(find)){
                List<String> printSearchPath=new ArrayList<>();
                FileNode temp=root.children.get(i);
                if(root.children.get(i).Isdirectory){
                    System.out.print("dir - ");
                }
                else{
                    System.out.print("file - ");
                }
                while(temp!=null){
                    printSearchPath.add(temp.name);
                    temp=temp.prev;
                }
                for(int k=printSearchPath.size()-1; k>-1; k--){
                    System.out.print(printSearchPath.get(k));
                    if(k!=0) System.out.print("/");
                }
                System.out.println();
            }
        }


    }

    /**
     * Print all Tree with their depth so you can understand which nodes is child of which node
     * @param root
     * @param result
     * @param depth
     * @return
     */
    public String printFileSystem(FileNode root,StringBuilder result,int depth){
        if(root==null){
            return "";
        }
        for(int i=0; i<depth; i++){
            result.append(" ");
        }
        result.append(root.name);


        for(int i=0; i<root.children.size(); i++){
            result.append("\n");
            printFileSystem(root.children.get(i),result,depth+1);

        }


        return result.toString();

    }

    /**
     * override toString method that call printFileSystem
     * @return String for printing my tree
     */
    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        return printFileSystem(root,result,0);
    }
}
