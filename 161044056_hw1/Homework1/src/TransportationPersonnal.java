/**
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-23
 */
public class TransportationPersonnal extends User {
    private int TPersonnalID;

    /**
     * 5 parameter Constructer for TransportationPersonnal
     * @param Name param for name
     * @param Surname param for surname
     * @param PhoneNumber param for Phonenumber
     * @param Email param for Email
     * @param TPersonnalID param for TpersonnalID
     */
    public TransportationPersonnal(String Name,String Surname,String PhoneNumber,String Email,int TPersonnalID){
        super(Name,Surname,PhoneNumber,Email);
        this.TPersonnalID=TPersonnalID;
    }

    /**
     * No parameter Constructer for TransportationPersonnal
     */
    public TransportationPersonnal(){
        super("unknown","unknown","unknown","unknown");
        this.TPersonnalID=0;
    }

    /**
     * With This method Transportation Personnel can update Package Information
     * @param MyPackage parameter for MyPackage
     */
    public void deliverPackage(ShipmentSent MyPackage){
        MyPackage.setInformation("PackageDelivired");
    }

    /**
     * getter for TpersonnalID
     * @return TpersonnalID
     */
    public int getTPersonnalID() {
        return TPersonnalID;
    }

    /**
     * setter for TpersonnalID
     * @param TPersonnalID para mfor TpersonnalID
     */
    public void setTPersonnalID(int TPersonnalID) {
        this.TPersonnalID = TPersonnalID;
    }

    /**
     *overriding toString method for TransportationPersonnal Class
     * @return String
     */
    public String toString(){
        return "Name:"+this.getName()+" Surname:"+this.getSurname()+" Email:"+this.getEmail()+" PhoneNumber:"+this.getPhoneNumber()
                +" TPersonnalID:"+this.getTPersonnalID();
    }
}
