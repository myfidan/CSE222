public class Main {

    public static void main(String[] args) {
        try{
            FileSystemTree myFileSystem = new FileSystemTree("root");
            myFileSystem.addDir("root/first_directory");
            myFileSystem.addDir("root/second_directory");
            myFileSystem.addDir("root/second_directory/third_directory");
            myFileSystem.addDir("root/second_directory/third_directory/fourth_directory");
            myFileSystem.addFile("root/first_directory/new_file.txt");
            myFileSystem.addDir("root/second_directory/new_dictionary");
            myFileSystem.addFile("root/second_directory/third_directory/new2file.txt");

            //myFileSystem.remove("root/second_directory/third_directory");

            myFileSystem.Search("new");

            System.out.println(myFileSystem); //I override toString method sout call PrintFileSystem method
        }
        catch(IllegalArgumentException x){
            System.out.println("Error:Probably you try to add a file or directory to a file node.");
        }
    }
}
