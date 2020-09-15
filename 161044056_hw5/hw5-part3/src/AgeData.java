public class AgeData implements Comparable<AgeData>{
    private int age;
    private int number_age;

    /**
     * one parameter Constructer
     * @param age age
     */
    public AgeData(int age){
        this.age=age;
        this.number_age=1;
    }

    /**
     * Override Comparato method for compara AgeData objects in my tree
     * @param o AgeData object
     * @return return 0 if compared items equal,-1 if o object bigger or 1 if o object smaller
     */
    @Override
    public int compareTo(AgeData o) {
        if(this.age==o.age){
            return 0;
        }
        else if(this.age<o.age){
            return -1;
        }
        else{
            return 1;
        }

    }

    /**
     * return age
     * @return age
     */
    public int getAge(){
        return age;
    }

    /**
     * return number_age
     * @return number_age
     */
    public int getNumber_age(){
        return number_age;
    }

    /**
     * Increment number age by 1
     */
    public void incrementNumber_age(){
        number_age++;
    }

    /**
     * Decrement number age by 1
     */
    public void decrementNumber_age(){
        number_age--;
    }
}
