/**
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-23
 */
public abstract class User {
    private String Name;
    private String Surname;
    private String PhoneNumber;
    private String Email;

    /**
     * 4 parameter constructer
     * @param Name param for name
     * @param Surname param for surname
     * @param PhoneNumber param for phoneNumber
     * @param Email param for Email
     */
    public User(String Name,String Surname,String PhoneNumber,String Email){
        this.Name=Name;
        this.Surname=Surname;
        this.PhoneNumber=PhoneNumber;
        this.Email=Email;
    }

    /**
     * getter for Name
     * @return Name
     */
    public String getName() {
        return Name;
    }

    /**
     * getter for Email
     * @return Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * getter for PhoneNumber
     * @return PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * getter for Surname
     * @return Surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * setter for Email
     * @param email param for Email
     */
    public void setEmail(String email) {
        this.Email = email;
    }

    /**
     * setter for Name
     * @param name param for Name
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * setter for PhoneNumber
     * @param phoneNumber param for PhoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    /**
     * setter for Surname
     * @param surname param for Surname
     */
    public void setSurname(String surname) {
        this.Surname = surname;
    }
}
