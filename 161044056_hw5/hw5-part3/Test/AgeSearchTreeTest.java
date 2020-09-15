import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeSearchTreeTest {

    @Test
    void add() {
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(10));
        assertEquals("10-2\n5-1\nnull\nnull\n20-1\nnull\nnull\n",ageTree.toString());
    }

    @Test
    void addSameElementTwice(){
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(10));
        assertEquals("10-2\nnull\nnull\n",ageTree.toString());
    }

    @Test
    void remove1() {
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.remove(new AgeData(5));
        assertEquals("10-1\nnull\n20-1\nnull\nnull\n",ageTree.toString());
    }
    @Test
    void remove2(){
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(10));
        ageTree.remove(new AgeData(10));
        assertEquals("10-1\nnull\nnull\n",ageTree.toString());
    }


    @Test
    void youngerThan(){
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        assertEquals(3,ageTree.youngerThan(17));
    }
    @Test
    void olderThan(){
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        assertEquals(4,ageTree.olderThan(3));
    }
}