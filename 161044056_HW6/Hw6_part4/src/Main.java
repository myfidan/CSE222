public class Main {

    public static void main(String[] args) {
    /*    KWHashMap<String,String> myMap = new HashTableOpen<>();

        myMap.put("Ali","cinar");
        myMap.put("Yasir","Fidan");
        myMap.put("Murat","Ergul");
        myMap.put("Enes","Aslan");
        myMap.put("Tarik","Fidan");
        myMap.remove("Tarik");
        System.out.println(myMap.get("Murat"));
        System.out.println(myMap.isEmpty());
        System.out.println(myMap.size());

        KWHashMap<String,String> myChain= new HashtableChain<>();
        myChain.put("1","dog");
        myChain.put("2","cat");
        myChain.put("3","bird");
        myChain.put("4","kangruu");
        myChain.put("5","human");
        myChain.put("6","fox");
        myChain.put("7","cat");

        System.out.println(myChain.get("7"));
    */
        KWHashMap<Integer,Integer> map = new DoubleHashingTable<>();

        long startTime = System.currentTimeMillis();

        for(int i=0; i<1000; i++){
            Integer randomInt=(int)(30000*Math.random());
            map.put(1,randomInt);
        }

        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));

        startTime = System.nanoTime();
        map.get(441);
        //map.remove(788);
        endTime = System.nanoTime();

        System.out.println((endTime - startTime));
    }
}
