public class Main {

    public static void main(String[] args) {
        AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(10));

        System.out.println(ageTree);
        System.out.println(ageTree.youngerThan(20));
        System.out.println(ageTree.olderThan(10));
        System.out.println(ageTree.find(new AgeData(10)));


    }
}
