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
     */
    public ArrayList<Branch> getBranches() {
        return Branches;
    }

    public ArrayList<BranchEmployee> getBranchEmp() {
        return BranchEmp;
    }

    public ArrayList<Customer> getCustomers() {
        return Customers;
    }

    public ArrayList<TransportationPersonnal> getTPersonnal() {
        return TPersonnal;
    }

    public void setBranchEmp(ArrayList<BranchEmployee> branchEmp) {
        BranchEmp = branchEmp;
    }

    public void setBranches(ArrayList<Branch> branches) {
        Branches = branches;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        Customers = customers;
    }

    public void setTPersonnal(ArrayList<TransportationPersonnal> TPersonnal) {
        this.TPersonnal = TPersonnal;
    }
}
