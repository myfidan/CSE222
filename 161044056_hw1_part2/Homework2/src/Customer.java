/**
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-23
 */
public class Customer extends User {
    private int TrackingNumber;

    /**
     * 5 parameter Constructer for Customer
     * @param Name param for name
     * @param Surname param for surname
     * @param PhoneNumber param for PhoneNumber
     * @param Email param for Email
     * @param TrackingNumber param for TrackingNumber
     */
    public Customer(String Name,String Surname,String PhoneNumber,String Email,int TrackingNumber){
        super(Name,Surname,PhoneNumber,Email);
        this.TrackingNumber=TrackingNumber;
        this.setInSystem(false);
    }

    /**
     * No parameter Constrocter for Customer
     */
    public Customer(){
        super("unknown","unknown","unknown","unknown");
        TrackingNumber=0;
    }

    /**
     * Override LoginSystem
     * With this method Customer can enter the system
     * if Customers try to do something in system befor login
     * an exception will be throw then an error message printed and program finish
     */
    @Override
    public void LoginSystem(){
        this.setInSystem(true);
    }

    /**
     * With this method Customer Can Tracking PackAge
     * @param myCargo param ShipmentSent
     */
    public void TrackingPackage(ShipmentSent myCargo)throws ArithmeticException{
        if(this.getInSystem()==false) throw new ArithmeticException();
        if (this.getTrackingNumber()==myCargo.getPackageID()){
            System.out.println("This Package Sender Information:");
            System.out.println("Sender Name:"+myCargo.getSender().getName()+" Sender Surname:"+myCargo.getSender().getSurname());
            System.out.println("This Package Receiver Information:");
            System.out.println("Receiver Name:"+myCargo.getReceiver().getName()+" Receiver Surname:"+myCargo.getReceiver().getSurname());
            System.out.println("Package Current Status:"+myCargo.getInformation());
        }
        else{
            System.out.println("Sorry This Cargo doesn't Belong to you");
        }
    }

    /**
     * Getter for TrackingNumber
     * @return TrackingNumber
     */
    public int getTrackingNumber() {
        return TrackingNumber;
    }

    /**
     * Setter for Tracking Number
     * @param trackingNumber param For Tracking Number
     */
    public void setTrackingNumber(int trackingNumber) {
        TrackingNumber = trackingNumber;
    }

    /**
     * override toString
     * return Customer attribute string
     * @return String
     */
    @Override
    public String toString(){
        return "Name:"+this.getName()+" Surname:"+this.getSurname()+" PhoneNumber:"+this.getPhoneNumber()+" Email:"+this.getEmail()
                +" TrackingNumber:"+this.getTrackingNumber();
    }
}
