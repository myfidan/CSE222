import java.util.ArrayList;

/**
 * This Class for my main Cargo System
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-23
 */
public class CargoSystem {
    private ArrayList<Branch> Branches=new ArrayList<Branch>();
    private ArrayList<Customer> Customers=new ArrayList<Customer>();
    private ArrayList<BranchEmployee> BranchEmp=new ArrayList<BranchEmployee>();
    private ArrayList<TransportationPersonnal> TPersonnal=new ArrayList<TransportationPersonnal>();

    /**
     * 0 parameter Constructer for Cargo System
     * @return Branch Arraylist
     */
    public ArrayList<Branch> getBranches() {
        return Branches;
    }

    /**
     * get BranchEmployee arraylist in System
     * @return BranchEmployee Arraylist
     */
    public ArrayList<BranchEmployee> getBranchEmp() {
        return BranchEmp;
    }

    /**
     * get Customer arraylist in system
     * @return Customer Arraylist
     */
    public ArrayList<Customer> getCustomers() {
        return Customers;
    }

    /**
     * get Tpersonnal arraylist in system
     * @return TPersonnal Arraylist
     */
    public ArrayList<TransportationPersonnal> getTPersonnal() {
        return TPersonnal;
    }

    /**
     * set branchemp arraylist
     * @param branchEmp parametre for set BranhcEmployee
     */
    public void setBranchEmp(ArrayList<BranchEmployee> branchEmp) {
        BranchEmp = branchEmp;
    }

    /**
     * set braches arraylist
     * @param branches parametre for set Branches
     */
    public void setBranches(ArrayList<Branch> branches) {
        Branches = branches;
    }

    /**
     * set customers arraylist
     * @param customers parameters for set customers
     */
    public void setCustomers(ArrayList<Customer> customers) {
        Customers = customers;
    }

    /**
     * set Tpersonnal arraylist
     * @param TPersonnal parameters for set Tpersonnal
     */
    public void setTPersonnal(ArrayList<TransportationPersonnal> TPersonnal) {
        this.TPersonnal = TPersonnal;
    }
}
