public class Main {

    public static void main(String[] args) {
        ExpressionTree myTree=new ExpressionTree("* + 6 3 / + 12 24 36");//prefix expression
        //ExpressionTree myTree=new ExpressionTree("2 4 + 6 8 + 14 / *");//postfix expression

        System.out.println(myTree.toString2());
        System.out.println(myTree.EvaluateTree());
    }
}
