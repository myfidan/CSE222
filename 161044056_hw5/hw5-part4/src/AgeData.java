public class AgeData implements Comparable<AgeData>{
    private int age;
    private int number_age;

    /**
     * 1 parameter constructer
     * @param age
     */
    public AgeData(int age){
        this.age=age;
        this.number_age=1;
    }

    /**
     * Override compareTo method for compare AgeData object
     * @param o AgeData object
     * @return return 0 if object equals,-1 if other bigger or 1 if other object smaller
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
     * return Age
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
     * Incremen number_age by 1
     */
    public void incrementNumber_age(){
        number_age++;
    }

    /**
     * Decrease number_age by 1
     */
    public void decrementNumber_age(){
        number_age--;
    }

    /**
     * set number age
     * @param num
     */
    public void setNumber_age(int num){
        number_age=num;
    }

    /**
     * Set age
     * @param num
     */
    public void setAge(int num){
        age=num;
    }

    /**
     * Override toString method
     * @return String for print
     */
    @Override
    public String toString() {
        return age+"-"+number_age;
    }
}
