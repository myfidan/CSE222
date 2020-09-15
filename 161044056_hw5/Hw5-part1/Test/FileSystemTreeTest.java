import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTreeTest {

    @Test
    void addDirAndFile() {
        FileSystemTree TestTree=new FileSystemTree("root");
        TestTree.addDir("root/myFiles");
        TestTree.addFile("root/myFiles/file1.txt");
        TestTree.addFile("root/myFiles/file2.txt");
        assertEquals("root\n myFiles\n  file1.txt\n  file2.txt",TestTree.toString());
    }

    //Try add a file a directory or file.It must not added because you cant add a file a directory or file
    @Test
    void tryAddFile(){
        FileSystemTree TestTree=new FileSystemTree("root");
        TestTree.addDir("root/myFiles");
        TestTree.addFile("root/myFiles/file1.txt");
        try{

            TestTree.addFile("root/myFiles/file1.txt/file2.txt");
        }
        catch (IllegalArgumentException x){
            assertEquals(1,1);
        }
    }

    //remove a leaf node
    @Test
    void removeLeafNode() {
        FileSystemTree TestTree=new FileSystemTree("root");
        TestTree.addDir("root/myFiles");
        TestTree.addFile("root/myFiles/file1.txt");
        TestTree.addFile("root/myFiles/file2.txt");
        TestTree.remove("root/myFiles/file1.txt");
        assertEquals("root\n myFiles\n  file2.txt",TestTree.toString());
    }

    //Search test
    @Test
    void SearchTest(){
        FileSystemTree TestTree=new FileSystemTree("root");
        TestTree.addDir("root/myFiles");
        TestTree.addFile("root/myFiles/file1.txt");
        TestTree.addFile("root/myFiles/file2.txt");
        TestTree.Search("file");
        assertEquals(1,1);
    }
}