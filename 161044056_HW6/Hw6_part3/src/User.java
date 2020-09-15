public class User extends Person {

    public User(String name,String surname){
        super(name,surname);
    }


    @Override
    public String toString() {
        return "User info\nName: "+this.Name+"\nSurname: "+this.Surname+"\n";
    }
}
