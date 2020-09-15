/**
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-23
 */
public class BranchEmployee extends User {
    private int EmployeeID;
    private Branch WorkingBranch=new Branch();

    /**
     * 6 parameter Constructer
     * @param Name for this.name
     * @param Surname for this.surname
     * @param PhoneNumber for this.Phonenumber
     * @param Email for this.Email
     * @param Working_Branch for this.WorkingBranch
     * @param EmployeeID for this.EmployeeID
     */
    public BranchEmployee(String Name,String Surname,String PhoneNumber,String Email,Branch Working_Branch,int EmployeeID){
        super(Name,Surname,PhoneNumber,Email);
        this.EmployeeID=EmployeeID;
        this.WorkingBranch.setBranchID(Working_Branch.getBranchID());
        Address temp=new Address(Working_Branch.getAddressCountry(),Working_Branch.getAddressCity(),Working_Branch.getAddressStreetNo());
        this.WorkingBranch.setBranchAddress(temp);
        this.setInSystem(false);
        if(Working_Branch.getInSystem()==false){
            throw new IllegalArgumentException();
        }
    }

    /**
     * override loginSystem method
     * with this method BranchEmployee can enter system
     * if BranchEmployee try to do something in System without loginSystem
     * an exception will be throw and program finish with an error message
     */
    @Override
    public void LoginSystem(){
        this.setInSystem(true);
    }
    /**
     * 0 Parameter Constructer for BrnachEmployee
     */
    public BranchEmployee(){
        super("unknown","unknown","unknown","unknown");
        this.EmployeeID=0;
        this.WorkingBranch.setBranchID(0);
        Address temp=new Address("unknown","unknown",0);
        this.WorkingBranch.setBranchAddress(temp);
    }

    /**
     * With this method BranchEmployees can add Customers to the system
     * @param MySystem param for this.System
     * @param MyCustomer param for this.Customer
     */
    public void addCustomer(CargoSystem MySystem,Customer MyCustomer)throws ArithmeticException{
        if(this.getInSystem()==false) throw new ArithmeticException();
        MySystem.getCustomers().add(MyCustomer);
    }

    /**
     * With this method BranchEmployeescan remove Customers to the system
     * @param MySystem param for this.System
     * @param MyCustomer param for this.Customer
     */
    public void removeCustomer(CargoSystem MySystem,Customer MyCustomer)throws ArithmeticException{
        if(this.getInSystem()==false) throw new ArithmeticException();
        MyCustomer.setInSystem(false);
        MySystem.getCustomers().remove(MyCustomer);
    }

    /**
     * With this method BranchEmployees can Enter Information about Shipment sents
     * @param changeInfo param for Shipment.Info
     */
    public void enterInformation(ShipmentSent changeInfo)throws ArithmeticException{
        if(this.getInSystem()==false) throw new ArithmeticException();
        if(this.getWorkingBranch().getBranchID()==changeInfo.getPackageID()){
            changeInfo.setInformation("PackageInBranch");
        }
        else{
            changeInfo.setInformation("PackageOnTheRoad");
        }
    }

    /**
     * With this method BranchEmployees can remove Information about Shipments sent
     * @param changeInfo param for ShipmentSent
     */
    public void removeInformation(ShipmentSent changeInfo)throws ArithmeticException{
        if(this.getInSystem()==false) throw new ArithmeticException();
        changeInfo.setInformation("unknown");
    }

    /**
     * getter for WorkingBranch
     * @return WorkingBranch
     */
    public Branch getWorkingBranch() {
        return WorkingBranch;
    }

    /**
     * setter for WorkingBranch
     * @param workingBranch param for WorkingBranch
     */
    public void setWorkingBranch(Branch workingBranch) {
        this.WorkingBranch.setBranchID(workingBranch.getBranchID());
        Address temp=new Address(workingBranch.getAddressCountry(),workingBranch.getAddressCity(),workingBranch.getAddressStreetNo());
        this.WorkingBranch.setBranchAddress(temp);
    }

    /**
     * getter for EmployeeID
     * @return return EmployeeID
     */
    public int getEmployeeID() {
        return EmployeeID;
    }

    /**
     * setter for EmployeeID
     * @param employeeID param for EmployeeID
     */
    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    /**
     * toString method overrided for BranchEmployee class
     * @return String
     */
    @Override
    public String toString(){
        return "Name:"+this.getName()+" Surname:"+this.getSurname()+" PhoneNumber:"+this.getPhoneNumber()+" Email:"+this.getEmail()
                +" EmployeeID:"+this.getEmployeeID()+" WorkingPlace:"+this.getWorkingBranch().getAddressCountry()+"-"
                +this.getWorkingBranch().getAddressCountry()+"-"+this.getWorkingBranch().getAddressStreetNo();
    }
}
