/**
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-22
 */
public class Administrator extends User  {
    private int PersonalID;
    private String Username;
    private String Password;

    /**
     * 7 parameter Constructer for Administrator Class
     * @param Name param for this.name
     * @param Surname param for this.surname
     * @param PhoneNumber param for this.PhoneNumber
     * @param Email param for this.Email
     * @param PersonalID param for this.personalID
     * @param Username param for this.username
     * @param Password param for this.password
     */
    public Administrator(String Name,String Surname,String PhoneNumber,String Email,int PersonalID,String Username,String Password){
        super(Name,Surname,PhoneNumber,Email);
        this.PersonalID=PersonalID;
        this.Username=Username;
        this.Password=Password;
    }

    /**
     * With this method Admins can add Branches to the System
     * @param MySystem param for this.System
     * @param MyBranch param for this.branch
     */
    public void addBranchToSystem(CargoSystem MySystem,Branch MyBranch){
        MySystem.getBranches().add(MyBranch);
    }


    /**
     * With this method Admins can remove Branches to the System
     * @param MySystem param for this.system
     * @param MyBranch param for this.branch
     */
    public void removeBranchToSystem(CargoSystem MySystem,Branch MyBranch){
        MySystem.getBranches().remove(MyBranch);
    }

    /**
     * With this method Admins can add BranchEmployees to the system
     * @param MySystem param for this.system
     * @param MyBranchEmp param for this.branchEmp
     */
    public void addBranchEmpToSystem(CargoSystem MySystem,BranchEmployee MyBranchEmp){
       MySystem.getBranchEmp().add(MyBranchEmp);
    }

    /**
     * With this method Admins can remove BranchEmployees to the system
     * @param MySystem param for this.System
     * @param MyBranchEmp param for this.BranchEmp
     */
    public void removeBranchEmpToSystem(CargoSystem MySystem,BranchEmployee MyBranchEmp){
       MySystem.getBranchEmp().remove(MyBranchEmp);
    }

    /**
     * With this method Admins can add TransportationPersonnel To the system
     * @param MySystem param for this.System
     * @param MyTP param for this.TransportationPersonnel
     */
    public void addTrasportationPersonnelToSystem(CargoSystem MySystem,TransportationPersonnal MyTP){
        MySystem.getTPersonnal().add(MyTP);
    }

    /**
     * With this method Admins can remove Transportation To the System
     * @param MySystem param for this.System
     * @param MyTP param for this.TransportationPersonnel
     */
    public void removeTrasportationPersonnelToSystem(CargoSystem MySystem,TransportationPersonnal MyTP){
        MySystem.getTPersonnal().remove(MyTP);
    }

    /**
     * Getter for PersonnalID
     * @return PersonalID
     */
    public int getPersonalID(){
        return PersonalID;
    }

    /**
     * Getter for Username
     * @return Username
     */
    public String getUsername(){
        return Username;
    }

    /**
     * Getter for Password
     * @return Password
     */
    public String getPassword(){
        return Password;
    }

    /**
     * Setter for PersonnalID
     * @param PersonalID setter personalID
     */
    public void setPersonalID(int PersonalID){
        this.PersonalID=PersonalID;
    }

    /**
     * Setter for Username
     * @param Username setter Username
     */
    public void setUsername(String Username){
        this.Username=Username;
    }

    /**
     * Setter For Password
     * @param Password setter password
     */
    public void setPassword(String Password){
        this.Password=Password;
    }

    /**
     * toString method overriding for Admin class
     * @return String
     */
    public String toString(){
        return "Name:"+this.getName()+" Surname:"+this.getSurname()+" PhoneNumber:"+this.getPhoneNumber()+" Email:"
        +this.getEmail()+" Username:"+Username+" Password:"+Password+" PersonalID:"+PersonalID;
    }

}
