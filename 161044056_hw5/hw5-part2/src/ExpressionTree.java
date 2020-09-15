import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionTree extends BinaryTree{

    private static boolean prefix;
    /**
     * contructer for initialize ExpressionTree
     * @param init String for initialize tree
     */
    public ExpressionTree(String init){
        //determine string is a prefix or postfix
        if(Character.isDigit(init.charAt(0))){
            prefix=false;
        }
        else{
            prefix=true;
        }

        Scanner scan_string=new Scanner(init);
        scan_string.useDelimiter(" ");
        scan_string.tokens();

        BinaryTree<String> Tree;
        Tree=readBinaryTree(scan_string);//call readBinaryTree in constructer and construct my tree
        root=Tree.root;

    }

    /**
     * Print the Expression Tree
     * Using postOrderTraverse method in it
     * @return String
     */
    public String toString2(){
        StringBuilder result = new StringBuilder();
        postOrderTraverse(root, 1, result);
        return result.toString();
    }

    /**
     * Traverse tree in postOrder
     * @param node root
     * @param depth depth num
     * @param sb StringBuilder that hold values
     */
    private void postOrderTraverse(Node<String> node, int depth,
                                  StringBuilder sb) {

        if (node == null) {
            return;

        } else {

            postOrderTraverse(node.left, depth + 1, sb);
            postOrderTraverse(node.right, depth + 1, sb);
            sb.append(node.data+" ");
        }
    }

    /**
     * Evaluate prefix or postfix expression Tree
     * @return value
     */
    public int EvaluateTree(){
        Node<String> tempRoot = root;
        return EvaluateTreeWraped(tempRoot);
    }

    /**
     * A recursive wrapper function for Evaluate Tree
     * @param root
     * @return value
     */
    private int EvaluateTreeWraped(Node<String> root){
        if(root==null) return 0;//if root empty

        if(root.left==null && root.right==null){ //if leaf node
            return Integer.parseInt(root.data);
        }

        int left_v=EvaluateTreeWraped(root.left);
        int right_v=EvaluateTreeWraped(root.right);

        if(root.data.equals("*")){
            return left_v*right_v;
        }
        if(root.data.equals("/")){
            return left_v/right_v;
        }
        if(root.data.equals("+")){
            return left_v+right_v;
        }
        else{
            return left_v-right_v;
        }


    }

    /**
     * Construct Tree
     * @param scan input
     * @return return BinaryTree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan){
        //if scan is prefix
        List<Node<String> > tempList=new ArrayList<>();
        BinaryTree<String> myTree=new BinaryTree<>();
        if(prefix){//if scan prefix
            StringBuilder result=new StringBuilder();
            while(scan.hasNext())
            {
                result.append(scan.next()+" ");
            }
            String[] tokens=result.toString().split(" ");
            for(int i=tokens.length-1; i>=0; i--){
                if(Character.isDigit(tokens[i].charAt(0))){
                    Node<String> temp=new Node<>(tokens[i]);
                    tempList.add(temp);
                }
                else{
                    Node<String> temp=new Node<>(tokens[i]);
                    temp.left=tempList.remove(tempList.size()-1);
                    temp.right=tempList.remove(tempList.size()-1);
                    tempList.add(temp);
                }
            }
            Node<String> tut= tempList.remove(tempList.size()-1);
            myTree.root=tut;
            return new BinaryTree<String>(tut.data,myTree.getLeftSubtree(),myTree.getRightSubtree());
        }
        else{//if scan is postfix
            while(scan.hasNext()){
                String data=scan.next();
                if(Character.isDigit(data.charAt(0))){//operand
                    Node<String> temp=new Node<>(data);
                    tempList.add(temp);
                }
                else{//operator
                    Node<String> temp=new Node<>(data);
                    temp.right=tempList.remove(tempList.size()-1);
                    temp.left=tempList.remove(tempList.size()-1);
                    tempList.add(temp);
                }

            }
            Node<String> tut= tempList.remove(tempList.size()-1);
            myTree.root=tut;
            return new BinaryTree<String>(tut.data,myTree.getLeftSubtree(),myTree.getRightSubtree());
        }
    }
}
