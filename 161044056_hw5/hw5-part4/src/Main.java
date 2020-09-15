public class Main {

    public static void main(String[] args) {
        MaxHeap<AgeData> heap=new MaxHeap<>();
        heap.add(new AgeData(40));
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));
        heap.add(new AgeData(40));
        heap.add(new AgeData(50));
        heap.add(new AgeData(5));
        heap.add(new AgeData(40));
        heap.add(new AgeData(15));

        heap.remove(new AgeData((50)));
        heap.remove(new AgeData(40));

        System.out.println(heap);

        System.out.println(heap.find(new AgeData(10)));

        System.out.println(heap.youngerThan(16));

        System.out.println(heap.olderThan(14));
    }
}
