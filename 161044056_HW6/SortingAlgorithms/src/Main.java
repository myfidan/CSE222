import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static <T extends Comparable<T>> void SelectionSort(T[] arr){

        for(int i=0; i<arr.length-1; i++){
            T min=arr[i];
            int minIndex=i;
            for(int j=i+1; j<arr.length; j++){
                if(min.compareTo(arr[j])>0){
                    min=arr[j];
                    minIndex=j;
                }
            }
            T temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }

    public static <T extends Comparable<T>> void BubbleSort(T[] arr){

        int i=1;
        boolean exchange=false;
        do {
            exchange=false;
            for(int j=0; j<arr.length-i; j++){
                int result = arr[j].compareTo(arr[j+1]);
                if(result>0){
                    T temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    exchange=true;
                }
            }
            i++;
        }while(exchange);
    }

    public static <T extends Comparable<T>> void InsertionSort(T[] arr){
        for(int i=1; i<arr.length; i++){
            int j=i-1;
            T temp=arr[i];
            while(j>=0 && arr[j].compareTo(temp)>0){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }

    public static <T extends Comparable<T>> void ShellSort(T arr[])
    {
        int n = arr.length;

        int gap= n/2;
        while(gap > 0)
        {

            for (int i = gap; i < n; i += 1)
            {

                T temp = arr[i];

                int j;
                for (j = i; j >= gap && temp.compareTo(arr[j-gap])<0; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp;
            }
            if(gap == 2){
                gap = 1;
            }
            else{
                gap=(int)(gap/2.2);
            }
        }
    }

    public static <T extends Comparable<T>> void merge(T[] output,T[] leftInput,T[] rightInput){
        int i=0;//index for leftInput
        int j=0;//Index for rightInput
        int k=0;//index for output

        while(i<leftInput.length && j<rightInput.length){
            //find the smaller and insert it into the output
            if(leftInput[i].compareTo(rightInput[j])<0){
                output[k]=leftInput[i];
                k++;
                i++;
            }
            else{
                output[k]=rightInput[j];
                k++;
                j++;
            }
        }
        //one of the sequence has more items to comp
        while(i<leftInput.length){
            output[k]=leftInput[i];
            k++;
            i++;
        }
        while(j<rightInput.length){
            output[k]=rightInput[j];
            k++;
            j++;
        }
    }

    public static <T extends Comparable<T>> void MergeRecursive(T[] table) {
        // A table with one element is sorted already.
        if (table.length > 1) {
            // Split table into halves.
            int halfSize = table.length / 2;
            T[] leftTable = (T[]) new Comparable[halfSize];
            T[] rightTable = (T[]) new Comparable[table.length - halfSize];
            System.arraycopy(table, 0, leftTable, 0, halfSize);
            System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);
            // Sort the halves.
            MergeRecursive(leftTable);
            MergeRecursive(rightTable);
            // Merge the halves.
            merge(table, leftTable, rightTable);
        }
    }

    public static <T extends Comparable<T>> void HeapSort(T[] arr){
        BuildHeap(arr);
        ShrinkHeap(arr);
    }

    public static <T extends Comparable<T>> void BuildHeap(T[] arr){
        int n=1;
        while(n<arr.length){
            int child=n;
            int parent=(child-1)/2;
            while(parent >= 0 && arr[parent].compareTo(arr[child])<0){

                T temp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=temp;
                child=parent;
                parent=(child-1)/2;
            }

            n++;
        }
    }

    public static <T extends Comparable<T>> void ShrinkHeap(T[] arr){
        int n=arr.length;

        while(n>0){
            n--;

            T temp=arr[n];
            arr[n]=arr[0];
            arr[0]=temp;

            int parent=0;
            while(true){
                int lchild=parent*2+1;
                int rchild=parent*2+2;
                if(lchild>=n) break;
                int maxChild=lchild;
                if(rchild<n && arr[lchild].compareTo(arr[rchild])<0){
                    maxChild=rchild;
                }

                if(arr[maxChild].compareTo(arr[parent])>0){
                    T temp2=arr[parent];
                    arr[parent]=arr[maxChild];
                    arr[maxChild]=temp2;
                    parent=maxChild;

                }
                else{
                    break;
                }
            }

        }
    }


    public static <T extends Comparable<T>> void QuickSort(T[] arr){
        RecursiveQuickSort(arr,0,arr.length-1);
    }

    public static <T extends Comparable<T>> void RecursiveQuickSort(T[] arr,int first,int last){
        if(first<last){
            int pivIndex=partition(arr,first,last);

            RecursiveQuickSort(arr,first,pivIndex-1);
            RecursiveQuickSort(arr,pivIndex+1,last);
        }

    }

    public static <T extends Comparable<T>> int partition(T[] arr,int first,int last){
        T pivot=arr[first];
        int up=first;
        int down=last;
        do{
            while(arr[up].compareTo(pivot)<=0 && up<last){
                up++;
            }
            while(arr[down].compareTo(pivot)>0){
                down--;
            }
            if(up<down){
                T temp=arr[up];
                arr[up]=arr[down];
                arr[down]=temp;
            }
        }while(up<down);
        T temp2=arr[first];
        arr[first]=arr[down];
        arr[down]=temp2;
        return down;
    }




    public static <T extends Comparable<T>> void mergeList(List<T> output,List<T> leftInput,List<T> rightInput){
        int i=0;//index for leftInput
        int j=0;//Index for rightInput
        int k=0;//index for output

        while(i<leftInput.size() && j<rightInput.size()){
            //find the smaller and insert it into the output
            if(leftInput.get(i).compareTo(rightInput.get(j))<0){
                output.set(k,leftInput.get(i));
                k++;
                i++;
            }
            else{
                output.set(k,rightInput.get(j));
                k++;
                j++;
            }
        }
        //one of the sequence has more items to comp
        while(i<leftInput.size()){
            output.set(k,leftInput.get(i));
            k++;
            i++;
        }
        while(j<rightInput.size()){
            output.set(k,rightInput.get(j));
            k++;
            j++;
        }
    }

    public static <T extends Comparable<T>> void MergeRecursiveList(List<T> table) {
        // A table with one element is sorted already.
        if (table.size() > 1) {
            // Split table into halves.
            int halfSize = table.size() / 2;
            List<T> leftTable = new LinkedList<>();
            List<T> rightTable = new LinkedList<>();
            for(int i=0; i<halfSize; i++){
                leftTable.add(table.get(i));
            }
            for(int j=halfSize; j<table.size(); j++){
                rightTable.add(table.get(j));
            }
            // Sort the halves.
            MergeRecursiveList(leftTable);
            MergeRecursiveList(rightTable);
            // Merge the halves.
            mergeList(table, leftTable, rightTable);
        }
    }




    public static <T extends Comparable<T>> void QuickSortLinkedList(List<T> list){
        RecursiveQuickSortLinkedList(list,0,list.size()-1);
    }

    private static <T extends Comparable<T>> void RecursiveQuickSortLinkedList(List<T> list,int first,int last){
        if(first<last){
            int pivIndex = partitionList(list,first,last);

            RecursiveQuickSortLinkedList(list,first,pivIndex-1);
            RecursiveQuickSortLinkedList(list,pivIndex+1,last);
        }
    }

    private static <T extends Comparable<T>> int partitionList(List<T> list,int first,int last){
        T pivot=list.get(first);
        int up=first;
        int down=last;
        do{
            while(list.get(up).compareTo(pivot)<=0 && up<last){
                up++;
            }
            while(list.get(down).compareTo(pivot)>0){
                down--;
            }
            if(up<down){
                T temp=list.get(up);
                list.set(up,list.get(down));
                list.set(down,temp);
            }
        }while(up<down);
        T temp2=list.get(first);
        list.set(first,list.get(down));
        list.set(down,temp2);
        return down;
    }

    public static void main(String[] args) {

        Integer[] arr1=new Integer[10000];
        Integer[] arr2=new Integer[10000];
        Integer[] arr3=new Integer[10000];
        Integer[] arr4=new Integer[10000];
        Integer[] arr5=new Integer[10000];
        Integer[] arr6=new Integer[10000];
        Integer[] arr7=new Integer[10000];
        Integer[] arr8=new Integer[10000];
        Integer[] arr9=new Integer[10000];
        Integer[] arr10=new Integer[10000];
        Integer[] arr11=new Integer[10000];
        Integer[] arr12=new Integer[10000];
        Integer[] arr13=new Integer[10000];
        Integer[] arr14=new Integer[10000];
        Integer[] arr15=new Integer[10000];
        Integer[] arr16=new Integer[10000];
        Integer[] arr17=new Integer[10000];
        Integer[] arr18=new Integer[10000];
        Integer[] arr19=new Integer[10000];
        Integer[] arr20=new Integer[10000];

        Integer[] arr21=new Integer[40000];
        Integer[] arr22=new Integer[40000];
        Integer[] arr23=new Integer[40000];
        Integer[] arr24=new Integer[40000];
        Integer[] arr25=new Integer[40000];
        Integer[] arr26=new Integer[40000];
        Integer[] arr27=new Integer[40000];
        Integer[] arr28=new Integer[40000];
        Integer[] arr29=new Integer[40000];
        Integer[] arr30=new Integer[40000];
        Integer[] arr31=new Integer[40000];
        Integer[] arr32=new Integer[40000];
        Integer[] arr33=new Integer[40000];
        Integer[] arr34=new Integer[40000];
        Integer[] arr35=new Integer[40000];
        Integer[] arr36=new Integer[40000];
        Integer[] arr37=new Integer[40000];
        Integer[] arr38=new Integer[40000];
        Integer[] arr39=new Integer[40000];
        Integer[] arr40=new Integer[40000];

        Integer[] arr41=new Integer[100000];
        Integer[] arr42=new Integer[100000];
        Integer[] arr43=new Integer[100000];
        Integer[] arr44=new Integer[100000];
        Integer[] arr45=new Integer[100000];
        Integer[] arr46=new Integer[100000];
        Integer[] arr47=new Integer[100000];
        Integer[] arr48=new Integer[100000];
        Integer[] arr49=new Integer[100000];
        Integer[] arr50=new Integer[100000];
        Integer[] arr51=new Integer[100000];
        Integer[] arr52=new Integer[100000];
        Integer[] arr53=new Integer[100000];
        Integer[] arr54=new Integer[100000];
        Integer[] arr55=new Integer[100000];
        Integer[] arr56=new Integer[100000];
        Integer[] arr57=new Integer[100000];
        Integer[] arr58=new Integer[100000];
        Integer[] arr59=new Integer[100000];
        Integer[] arr60=new Integer[100000];

        Integer[] arr61=new Integer[150000];
        Integer[] arr62=new Integer[150000];
        Integer[] arr63=new Integer[150000];
        Integer[] arr64=new Integer[150000];
        Integer[] arr65=new Integer[150000];
        Integer[] arr66=new Integer[150000];
        Integer[] arr67=new Integer[150000];
        Integer[] arr68=new Integer[150000];
        Integer[] arr69=new Integer[150000];
        Integer[] arr70=new Integer[150000];
        Integer[] arr71=new Integer[150000];
        Integer[] arr72=new Integer[150000];
        Integer[] arr73=new Integer[150000];
        Integer[] arr74=new Integer[150000];
        Integer[] arr75=new Integer[150000];
        Integer[] arr76=new Integer[150000];
        Integer[] arr77=new Integer[150000];
        Integer[] arr78=new Integer[150000];
        Integer[] arr79=new Integer[150000];
        Integer[] arr80=new Integer[150000];

        Integer[] arr81=new Integer[180000];
        Integer[] arr82=new Integer[180000];
        Integer[] arr83=new Integer[180000];
        Integer[] arr84=new Integer[180000];
        Integer[] arr85=new Integer[180000];
        Integer[] arr86=new Integer[180000];
        Integer[] arr87=new Integer[180000];
        Integer[] arr88=new Integer[180000];
        Integer[] arr89=new Integer[180000];
        Integer[] arr90=new Integer[180000];
        Integer[] arr91=new Integer[180000];
        Integer[] arr92=new Integer[180000];
        Integer[] arr93=new Integer[180000];
        Integer[] arr94=new Integer[180000];
        Integer[] arr95=new Integer[180000];
        Integer[] arr96=new Integer[180000];
        Integer[] arr97=new Integer[180000];
        Integer[] arr98=new Integer[180000];
        Integer[] arr99=new Integer[180000];
        Integer[] arr100=new Integer[180000];


        Integer[] sortedarr1=new Integer[10000];
        Integer[] sortedarr2=new Integer[40000];
        Integer[] sortedarr3=new Integer[100000];
        Integer[] sortedarr4=new Integer[150000];
        Integer[] sortedarr5=new Integer[180000];

        Random rand = new Random();
/*
        for(int i=0; i<180000; i++){
            sortedarr5[i]=rand.nextInt(200000);

        }
        final long start = System.nanoTime();
        //here enter sorting algorithm you want to test time
        InsertionSort(sortedarr5);


        final long end = System.nanoTime();
        System.out.println("Took: " + (end - start)/ 1000000  + " miliseconds");
*/


        LinkedList<Integer> list1=new LinkedList<>();
        LinkedList<Integer> list2=new LinkedList<>();
        LinkedList<Integer> list3=new LinkedList<>();
        LinkedList<Integer> list4=new LinkedList<>();
        LinkedList<Integer> list5=new LinkedList<>();
        LinkedList<Integer> list6=new LinkedList<>();
        LinkedList<Integer> list7=new LinkedList<>();
        LinkedList<Integer> list8=new LinkedList<>();
        LinkedList<Integer> list9=new LinkedList<>();
        LinkedList<Integer> list10=new LinkedList<>();
        LinkedList<Integer> list11=new LinkedList<>();
        LinkedList<Integer> list12=new LinkedList<>();
        LinkedList<Integer> list13=new LinkedList<>();
        LinkedList<Integer> list14=new LinkedList<>();
        LinkedList<Integer> list15=new LinkedList<>();
        LinkedList<Integer> list16=new LinkedList<>();
        LinkedList<Integer> list17=new LinkedList<>();
        LinkedList<Integer> list18=new LinkedList<>();
        LinkedList<Integer> list19=new LinkedList<>();
        LinkedList<Integer> list20=new LinkedList<>();

        LinkedList<Integer> sortedlist1=new LinkedList<>();
        LinkedList<Integer> sortedlist2=new LinkedList<>();
        LinkedList<Integer> sortedlist3=new LinkedList<>();
        LinkedList<Integer> sortedlist4=new LinkedList<>();
        LinkedList<Integer> sortedlist5=new LinkedList<>();

        for(int i=100000; i>-1; i--){
            sortedlist3.addFirst(i);

        }
        System.out.println("here");
        final long start = System.nanoTime();
        QuickSortLinkedList(sortedlist3);


        final long end = System.nanoTime();
        System.out.println("Took: " + (end - start)/ 1000000 + " miliseconds");



        //SelectionSort(array);
        //BubbleSort(array);
        //InsertionSort(array);
        //ShellSort(array);
        //MergeRecursive(array);
        //HeapSort(array);
        //QuickSort(array);
        //QuickSortLinkedList(array2);
        //MergeRecursiveList(array2);

    }
}
