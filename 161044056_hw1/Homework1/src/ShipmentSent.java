/**
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-23
 */
public class ShipmentSent {
    private int PackageID;
    private String Information;
    private Customer Sender=new Customer();
    private Customer Receiver=new Customer();

    /**
     * 4 parameter Constructer for ShipmentSent
     * @param ID param for ID
     * @param Info param for Info
     * @param sent param for Sent
     * @param recive param for Recive
     */
    public ShipmentSent(int ID,String Info,Customer sent,Customer recive){
        PackageID=ID;
        Information=Info;
        Sender=sent;
        Receiver=recive;

    }

    /**
     * No parameter Constructer
     */
    public ShipmentSent(){
        PackageID=0;
        Information="unknown";
        Customer temp1=new Customer();
        Customer temp2=new Customer();
        Sender=temp1;
        Receiver=temp2;
    }

    /**
     * getter for PackageID
     * @return PackageID
     */
    public int getPackageID() {
        return PackageID;
    }

    /**
     * getter for Information
     * @return Information
     */
    public String getInformation() {
        return Information;
    }

    /**
     * getter for Receiver Customer
     * @return Receiver
     */
    public Customer getReceiver() {
        return Receiver;
    }

    /**
     * Getter For Sender Customer
     * @return Sender
     */
    public Customer getSender() {
        return Sender;
    }

    /**
     * setter for package Information
     * @param information param for Information
     */
    public void setInformation(String information) {
        Information = information;
    }

    /**
     * setter for PackageID
     * @param packageID param for PackageID
     */
    public void setPackageID(int packageID) {
        PackageID = packageID;
    }


}
