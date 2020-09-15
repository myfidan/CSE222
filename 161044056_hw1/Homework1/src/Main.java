public class Main {

    public static void main(String[] args) {
        CargoSystem MyCargoSystem=new CargoSystem();
        //Create an Admin and print its informations
        Administrator Admin1=new Administrator("Yasir","Fidan","5539883345","yasirfidan@windowslive.com",1100,"admin1","adminpass1");
        System.out.println("Admin Created:");
        System.out.println(Admin1);

        Branch Branch1=new Branch(1,"Turkey","Kocaeli",110);
        Branch Branch2=new Branch(1200,"Germany","Berlin",32);
        Branch Branch3=new Branch(1000,"England","London",11);
        //Admin1 Add Branch1 To the System
        System.out.println("\nAfter Branch1 added System has these Branches:");

        Admin1.addBranchToSystem(MyCargoSystem,Branch1);
        Admin1.addBranchToSystem(MyCargoSystem,Branch2);
        Admin1.addBranchToSystem(MyCargoSystem,Branch3);

        for(int i=0; i<MyCargoSystem.getBranches().size(); i++){
            System.out.println(MyCargoSystem.getBranches().get(i).getBranchID());
        }
        System.out.println();
        Admin1.removeBranchToSystem(MyCargoSystem,Branch2);

        for(int i=0; i<MyCargoSystem.getBranches().size(); i++){
            System.out.println(MyCargoSystem.getBranches().get(i).getBranchID());
        }

        System.out.println();

        BranchEmployee BranchEmp1=new BranchEmployee("Mehmet","Yıldız","5453321674","mehmet@gmail.com",Branch1,1);
        BranchEmployee BranchEmp2=new BranchEmployee("Ali","Demir","5256769843","alidemir1997@gmail.com",Branch1,2);
        BranchEmployee BranchEmp3=new BranchEmployee("Mustafa","Celik","2124565476","musticelik@hotmail.com",Branch3,5);

        Admin1.addBranchEmpToSystem(MyCargoSystem,BranchEmp1);
        Admin1.addBranchEmpToSystem(MyCargoSystem,BranchEmp2);
        Admin1.addBranchEmpToSystem(MyCargoSystem,BranchEmp3);

        for(int i=0; i<MyCargoSystem.getBranchEmp().size(); i++){
            System.out.println(MyCargoSystem.getBranchEmp().get(i).getEmployeeID());
        }
        System.out.println();
        Admin1.removeBranchEmpToSystem(MyCargoSystem,BranchEmp1);

        for(int i=0; i<MyCargoSystem.getBranchEmp().size(); i++){
            System.out.println(MyCargoSystem.getBranchEmp().get(i).getEmployeeID());
        }

        System.out.println();
        TransportationPersonnal Tpersonnal1=new TransportationPersonnal("Ayse nur","sahin","7840322","aysenur@windowslive.com",1);
        TransportationPersonnal Tpersonnal2=new TransportationPersonnal("Elif","ozcelik","5673323","elifozcelik@gtu.edu.tr",3);

        Admin1.addTrasportationPersonnelToSystem(MyCargoSystem,Tpersonnal1);
        Admin1.addTrasportationPersonnelToSystem(MyCargoSystem,Tpersonnal2);

        for(int i=0; i<MyCargoSystem.getTPersonnal().size(); i++){
            System.out.println(MyCargoSystem.getTPersonnal().get(i).getTPersonnalID());
        }
        System.out.println();

        Admin1.removeTrasportationPersonnelToSystem(MyCargoSystem,Tpersonnal2);

        for(int i=0; i<MyCargoSystem.getTPersonnal().size(); i++){
            System.out.println(MyCargoSystem.getTPersonnal().get(i).getTPersonnalID());
        }
        System.out.println();

        Customer customer1=new Customer("Yavuz","Aslan","8653321","yaslan@hotmail.com",112);
        Customer customer2=new Customer("Muhammed","Uzun","7671239","muzun78@ytu.edu.tr",115);
        Customer customer3=new Customer("Berke","Savas","9086723","berkesavas@gmail.com",200);

        BranchEmp1.addCustomer(MyCargoSystem,customer1);
        BranchEmp2.addCustomer(MyCargoSystem,customer2);
        BranchEmp1.addCustomer(MyCargoSystem,customer3);

        for(int i=0; i<MyCargoSystem.getCustomers().size(); i++){
            System.out.println(MyCargoSystem.getCustomers().get(i).getName());
        }
        System.out.println();

        BranchEmp1.removeCustomer(MyCargoSystem,customer2);

        for(int i=0; i<MyCargoSystem.getCustomers().size(); i++){
            System.out.println(MyCargoSystem.getCustomers().get(i).getName());
        }

        ShipmentSent package1=new ShipmentSent(112,"unknown",customer1,customer3);
        ShipmentSent package2=new ShipmentSent(115,"unknown",customer3,customer1);
        ShipmentSent package3=new ShipmentSent(3,"Yolda",customer1,customer3);

        System.out.println("\nFirst Packages Info");
        System.out.println("Package1 Info:"+package1.getInformation());
        System.out.println("Package2 Info:"+package2.getInformation());
        System.out.println("Package3 Info:"+package3.getInformation());

        //BranchEmployee enter and remove information about ShipmentSents
        BranchEmp1.enterInformation(package1);
        BranchEmp2.enterInformation(package2);
        BranchEmp3.removeInformation(package3);

        System.out.println("\nAfter BranchEmployees chance the Informations of Packages:");
        System.out.println("Package1 Info:"+package1.getInformation());
        System.out.println("Package2 Info:"+package2.getInformation());
        System.out.println("Package3 Info:"+package3.getInformation()+"\n");

        System.out.println("After Tpersonnal1 deliver the package ");
        //Tpersonnal deliver Package and change the package info to "delivered"
        Tpersonnal1.deliverPackage(package2);
        System.out.println("Package2 Info:"+package2.getInformation()+"\n");

        System.out.println("Customer1 try to check package1 with his Tracking Number:");
        //Customer1 check package with tracking number
        customer1.TrackingPackage(package1);

    }
}
