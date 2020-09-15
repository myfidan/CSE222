import java.util.ArrayList;

/**
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-23
 */
public class Branch {
    private int BranchID;
    private Address BranchAddress;
    private ArrayList<ShipmentSent> CargoPackage=new ArrayList<ShipmentSent>();

    /**
     * 4 parameter constructor for
     * @param BranchID param for this.BranchID
     * @param _Country param for this.County
     * @param _City param for this.City
     * @param _StreetNo param for this.StreetNo
     */
    public Branch(int BranchID,String _Country,String _City,int _StreetNo){
        this.BranchID=BranchID;
        Address address=new Address(_Country,_City,_StreetNo);
        BranchAddress=address;

    }

    /**
     * No parameter Constructer
     */
    public Branch(){
        this.BranchID=0;
        BranchAddress=new Address();
    }

    /**
     * setter for BranchID
     * @param branchID param for BranchID
     */
    public void setBranchID(int branchID) {
        BranchID = branchID;
    }

    /**
     * Setter for Branch Address
     * @param tempAddress param for Address
     */
    public void setBranchAddress(Address tempAddress){
        BranchAddress=tempAddress;
    }

    /**
     * getter for BranchID
     * @return return BranchID
     */
    public int getBranchID() {
        return BranchID;
    }

    /**
     * getter for BranchAddress
     * @return return BranchAddress
     */
    public String getAddressCountry(){
        return BranchAddress.getCountry();
    }

    /**
     * getter for AddressCity
     * @return return for City
     */
    public String getAddressCity(){
        return BranchAddress.getCity();
    }

    /**
     * getter for Address.StreetNo
     * @return return for StreetNo
     */
    public int getAddressStreetNo(){
        return BranchAddress.getStreetNo();
    }

    /**
     * This method getter For Packages that belongs Branch
     * @return return CargoPackage Array
     */
    public ArrayList<ShipmentSent> getCargoPackage() {
        return CargoPackage;
    }
}
