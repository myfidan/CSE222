import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTreeTest {
    @Test
    void prefixTree(){
        ExpressionTree myTree=new ExpressionTree("* + 6 3 / + 12 24 36");
        assertEquals(9,myTree.EvaluateTree());
    }

    @Test
    void postfixTree(){
        ExpressionTree myTree=new ExpressionTree("2 4 + 6 8 + 14 / *");
        assertEquals(6,myTree.EvaluateTree());
    }

    @Test
    void PrintTree(){
        ExpressionTree myTree=new ExpressionTree("2 4 + 6 8 + 14 / *");
        assertEquals("2 4 + 6 8 + 14 / * ",myTree.toString2());
    }
}