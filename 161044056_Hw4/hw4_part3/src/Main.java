import java.util.Stack;

public class Main {

    public static void elfish(String word,int count_e,int count_l,int count_f){
        if(word==null || word.equals("")){
            if(count_e==1 && count_l==1 && count_f==1){
                System.out.println("Elfish word");
            }
            else{
                System.out.println("Not Elfish word");
            }
            return;
        }
        else if(word.charAt(0)=='e'){
            count_e=1;
        }
        else if(word.charAt(0)=='l'){
            count_l=1;
        }
        else if(word.charAt(0)=='f'){
            count_f=1;
        }

        elfish(word.substring(1),count_e,count_l,count_f);

    }

    public static void PrintReverseString(String s,StringBuilder result){
        if(s.length()==0){
            System.out.println(result.reverse().toString());
            return;
        }
        if(s.charAt(s.length()-1)!=' '){
            result.append(s.charAt(s.length()-1));
        }
        else{
            System.out.println(result.reverse().toString());
            result=new StringBuilder();
        }
        PrintReverseString(s.substring(0,s.length()-1),result);
    }

    public static void EvaluatePostfix(String s, Stack<Integer> myStack){
        char temp=s.charAt(0);
        if(Character.isDigit(temp)){
            myStack.push(temp-'0');
        }
        else{
            int operand1=myStack.pop();
            int operand2=myStack.pop();
            int pushvalue;
            if(s.charAt(0)=='+'){
                pushvalue=operand2+operand1;
                myStack.push(pushvalue);
            }
            else if(s.charAt(0)=='-'){
                pushvalue=operand2-operand1;
                myStack.push(pushvalue);
            }
            else if(s.charAt(0)=='*'){
                pushvalue=operand2*operand1;
                myStack.push(pushvalue);
            }
            else if(s.charAt(0)=='/'){
                pushvalue=operand2/operand1;
                myStack.push(pushvalue);
            }
        }
        if(s.length()==1){
            System.out.println(myStack.pop());
            return;
        }

        EvaluatePostfix(s.substring(1),myStack);
    }

    public static void EvaluatePrefix(String s,Stack<Integer> myStack){
        if(Character.isDigit(s.charAt(s.length()-1))){
            myStack.push(s.charAt(s.length()-1)-'0');
        }
        else{
            int operand1;
            int operand2;
            if(s.charAt(s.length()-1)=='+'){
                operand1=myStack.pop();
                operand2=myStack.pop();
                myStack.push(operand2+operand1);
            }
            else if(s.charAt(s.length()-1)=='-'){
                operand1=myStack.pop();
                operand2=myStack.pop();
                myStack.push(operand2-operand1);
            }
            else if(s.charAt(s.length()-1)=='*'){
                operand1=myStack.pop();
                operand2=myStack.pop();
                myStack.push(operand2*operand1);
            }
            else if(s.charAt(s.length()-1)=='/'){
                operand1=myStack.pop();
                operand2=myStack.pop();
                myStack.push(operand2/operand1);
            }
        }
        if(s.length()==1){
            System.out.println(myStack.pop());
            return;
        }

        EvaluatePrefix(s.substring(0,s.length()-1),myStack);
    }

    public static void SelectionSort(int[] arr,int minIndex,int index,int min,int holdMinIndex){


        if(arr[minIndex]<min){
            min=arr[minIndex];
            holdMinIndex=minIndex;
        }
        if(arr.length-1==minIndex){


                arr[holdMinIndex]=arr[index];
                arr[index]=min;
            System.out.println(arr[index]);
                index++;
                minIndex=index;
                min=arr[index];
                holdMinIndex=index;

        }
        if(index==arr.length-1){
            System.out.println(arr[index]);
            return;
        }
        //System.out.println(index+minIndex+1);
        SelectionSort(arr,minIndex+1,index,min,holdMinIndex);

    }
    //way=0 sag way=1 alt way=2 sol way=3 üst
    public static void PrintArrayElements(int[][] arr,int m,int n,int y,int x,int way,int counter,int counter2){
        System.out.print(arr[y][x]+" ");


        if(y==n-1 && way==1){
            way=2;
           // n--;
            m++;
        }
        else if(counter==y && way==3){
            if(counter==n/2){
                System.out.print(arr[--y][x]+" ");
                return;
            }
            counter++;
            way=0;
            n--;
        }
        else if(x==counter2 && way==2){
            if(counter2==m/2){
                if(n%2==0)
                System.out.print(arr[--y][x]+" ");
                return;
            }
            counter2++;
            way=3;
            m--;
        }

        else if(x==m-1 && way==0){
            way=1;
            m--;
        }



        if(way==0){
            PrintArrayElements(arr,m,n,y,x+1,way,counter,counter2);
        }
        else if(way==1){
            PrintArrayElements(arr,m,n,y+1,x,way,counter,counter2);
        }
        else if(way==2){
            PrintArrayElements(arr,m,n,y,x-1,way,counter,counter2);
        }
        else{
            PrintArrayElements(arr,m,n,y-1,x,way,counter,counter2);
        }

    }

    public static void main(String[] args) {
        System.out.println("***String Reverse Method***");
        StringBuilder result=new StringBuilder();
        PrintReverseString("this function writes the sentence in reverse",result);
        System.out.println("***EvaluatePostfix Method***");
        Stack<Integer> myStack=new Stack<>();
        EvaluatePostfix("231*+9-",myStack);

        System.out.println("***EvaluatePrefix Method***");
        EvaluatePrefix("+9*26",myStack);


        System.out.println();
        System.out.println("***Selection Sort Method***");
        int[] arr=new int[10];
        arr[0]=6;
        arr[1]=3;
        arr[2]=7;
        arr[3]=9;
        arr[4]=2;
        arr[5]=0;
        arr[6]=4;
        arr[7]=1;
        arr[8]=8;
        arr[9]=5;
        SelectionSort(arr,1,0,arr[0],0);

        System.out.println();
        System.out.println("***Print 2D array Method***");
        int[][] PrintArr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        int arr_m=4;
        int arr_n=5;

        PrintArrayElements(PrintArr,arr_m,arr_n,0,0,0,1,0);
        System.out.println();
        System.out.println("***Elfish Word Method***");
        elfish("tasteful",0,0,0);
    }
}
