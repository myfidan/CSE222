/**
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-23
 */
public class TransportationPersonnal extends User {
    private int TPersonnalID;
    private Branch workingPlace;

    /**
     * 5 parameter Constructer for TransportationPersonnal
     * @param Name param for name
     * @param Surname param for surname
     * @param PhoneNumber param for Phonenumber
     * @param Email param for Email
     * @param TPersonnalID param for TpersonnalID
     * @param x parameter for workingBranch Tpersonnal
     */
    public TransportationPersonnal(String Name,String Surname,String PhoneNumber,String Email,int TPersonnalID,Branch x){
        super(Name,Surname,PhoneNumber,Email);
        this.TPersonnalID=TPersonnalID;
        this.workingPlace=x;
        this.setInSystem(false);
        if(x.getInSystem()==false){
            throw new IllegalArgumentException();
        }
    }

    /**
     * No parameter Constructer for TransportationPersonnal
     */
    public TransportationPersonnal(){
        super("unknown","unknown","unknown","unknown");
        this.TPersonnalID=0;
    }

    /**
     * Override LoginSystem
     * With this method Transportation Personnal can enter the system
     * if Transportation Personnal try to do something in system befor login
     * an exception will be throw then an error message printed and program finish
     */
    @Override
    public void LoginSystem(){
        this.setInSystem(true);
    }

    /**
     * With This method Transportation Personnel can update Package Information
     * @param MyPackage parameter for MyPackage
     */
    public void deliverPackage(ShipmentSent MyPackage)throws ArithmeticException{
        if(this.getInSystem()==false) throw new ArithmeticException();
        int checkPackageInBranch=0;
        for(int i=0; i<this.workingPlace.getCargoPackage().size(); i++){
            if(this.workingPlace.getCargoPackage().get(i)==MyPackage) checkPackageInBranch=1;
        }
        if(checkPackageInBranch==0){
            System.out.println("Transportation Personnal couldn't change packageInfo because this package doesnt belong " +
                    "the branch that Transportation personnal work");
        }
        else{
            MyPackage.setInformation("PackageDelivired");
        }
    }

    /**
     * getter for TpersonnalID
     * @return TpersonnalID
     */
    public int getTPersonnalID() {
        return TPersonnalID;
    }

    public Branch getWorkingPlace() {
        return workingPlace;
    }

    /**
     * setter for TpersonnalID
     * @param TPersonnalID para mfor TpersonnalID
     */
    public void setTPersonnalID(int TPersonnalID) {
        this.TPersonnalID = TPersonnalID;
    }

    public void setWorkingPlace(Branch workingPlace) {
        this.workingPlace = workingPlace;
    }

    /**
     *overriding toString method for TransportationPersonnal Class
     * @return String
     */
    @Override
    public String toString(){
        return "Name:"+this.getName()+" Surname:"+this.getSurname()+" Email:"+this.getEmail()+" PhoneNumber:"+this.getPhoneNumber()
                +" TPersonnalID:"+this.getTPersonnalID()+" WorkingBranch:"+this.getWorkingPlace();
    }
}
