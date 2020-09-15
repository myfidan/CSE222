public class Main {

    public static void main(String[] args) {
        //Error Handling
        //if a user try to call a method without login the system
        //an Exeption will throw and program finish with error message
        try {

            CargoSystem MyCargoSystem = new CargoSystem();
            //Polymorphism
            //UserInterface referance point Administrator,BranchEmployee,TransportationPersonnal and Customer object
            Administrator Admin1 = new Administrator("Yasir", "Fidan", "5539883345", "yasirfidan@windowslive.com", 1100, "admin1", "adminpass1");
            UserInterface MyUser = Admin1;

            System.out.println("Admin Created:");
            //UserInterface referance using Administrator toString method because its overrided
            System.out.println(MyUser);

            //MyUser UserInterface called method that implement in Administrators class because
            //MyUser UserInterface referance points to the Administrator object that called Admin1
            //LoginSystem overriden for Adminstrator class
            MyUser.LoginSystem();

            Branch Branch1 = new Branch(1, "Turkey", "Kocaeli", 110);
            Branch Branch2 = new Branch(1200, "Germany", "Berlin", 32);
            Branch Branch3 = new Branch(1000, "England", "London", 11);
            //Admin1 Add Branch1 To the System
            System.out.println("\nAfter Branch1,Branch2 and Branch3 added System has these Branches:");

            Admin1.addBranchToSystem(MyCargoSystem, Branch1);
            Admin1.addBranchToSystem(MyCargoSystem, Branch2);
            Admin1.addBranchToSystem(MyCargoSystem, Branch3);

            for (int i = 0; i < MyCargoSystem.getBranches().size(); i++) {
                System.out.println(MyCargoSystem.getBranches().get(i));
            }
            System.out.println("\nAfter Branch2 removed, System has these Branches:");
            Admin1.removeBranchToSystem(MyCargoSystem, Branch2);

            for (int i = 0; i < MyCargoSystem.getBranches().size(); i++) {
                System.out.println(MyCargoSystem.getBranches().get(i));
            }

            System.out.println();


            BranchEmployee BranchEmp1 = new BranchEmployee("Mehmet", "Yıldız", "5453321674", "mehmet@gmail.com", Branch1, 1);
            BranchEmployee BranchEmp2 = new BranchEmployee("Ali", "Demir", "5256769843", "alidemir1997@gmail.com", Branch1, 2);
            BranchEmployee BranchEmp3 = new BranchEmployee("Mustafa", "Celik", "2124565476", "musticelik@hotmail.com", Branch3, 5);
            //UserInterface referances points to the BranchEmployees
            UserInterface MyBranchEmp1 = BranchEmp1;
            UserInterface MyBranchEmp2 = BranchEmp2;
            UserInterface MyBranchEmp3 = BranchEmp3;

            System.out.println("\nBranchEmp1, BranchEmp2 and BranchEmp3 added to the System:");
            Admin1.addBranchEmpToSystem(MyCargoSystem, BranchEmp1);
            Admin1.addBranchEmpToSystem(MyCargoSystem, BranchEmp2);
            Admin1.addBranchEmpToSystem(MyCargoSystem, BranchEmp3);

            //With using UserInterface referances call overrided LoginSystem method
            //But BranchEmployee.LoginSystem() method will be called
            //Becuase UserInterface points to the BranchEmployee object
            MyBranchEmp1.LoginSystem();
            MyBranchEmp2.LoginSystem();
            MyBranchEmp3.LoginSystem();

            for (int i = 0; i < MyCargoSystem.getBranchEmp().size(); i++) {
                System.out.println(MyCargoSystem.getBranchEmp().get(i));
            }
            System.out.println();
            System.out.println("\nAfter BranchEmp1 removed, System has these BranchEmployees");
            Admin1.removeBranchEmpToSystem(MyCargoSystem, BranchEmp1);

            for (int i = 0; i < MyCargoSystem.getBranchEmp().size(); i++) {
                System.out.println(MyCargoSystem.getBranchEmp().get(i));
            }

            System.out.println();
            TransportationPersonnal Tpersonnal1 = new TransportationPersonnal("Ayse nur", "sahin", "7840322", "aysenur@windowslive.com", 1,Branch1);
            TransportationPersonnal Tpersonnal2 = new TransportationPersonnal("Elif", "ozcelik", "5673323", "elifozcelik@gtu.edu.tr", 3,Branch3);
            //UserInterface referance points to the Tpersonnal1 objects
            UserInterface MyTPersonnal1 = Tpersonnal1;
            UserInterface MyTpersonnal2 = Tpersonnal2;
            //With UserInterface referance called overrided LoginSystem method
            //But this LoginSystem method is TransportationPersonnal.LoginSystem()
            //because UserInterface referance points to the TransportationPersonnals
            MyTPersonnal1.LoginSystem();
            MyTpersonnal2.LoginSystem();

            Admin1.addTrasportationPersonnelToSystem(MyCargoSystem, Tpersonnal1);
            Admin1.addTrasportationPersonnelToSystem(MyCargoSystem, Tpersonnal2);

            System.out.println("\nAdmin add Tpersonnal1 and Tpersonnal2 to the System");
            System.out.println("System has these Transportation Personnel:");
            for (int i = 0; i < MyCargoSystem.getTPersonnal().size(); i++) {
                System.out.println(MyCargoSystem.getTPersonnal().get(i));
            }
            System.out.println();

            Admin1.removeTrasportationPersonnelToSystem(MyCargoSystem, Tpersonnal2);
            System.out.println("\nAdmin remove Tpersonnal2 to the system");
            System.out.println("System has these Transportation Personnel:");
            for (int i = 0; i < MyCargoSystem.getTPersonnal().size(); i++) {
                System.out.println(MyCargoSystem.getTPersonnal().get(i));
            }
            System.out.println();

            Customer customer1 = new Customer("Yavuz", "Aslan", "8653321", "yaslan@hotmail.com", 112);
            Customer customer2 = new Customer("Muhammed", "Uzun", "7671239", "muzun78@ytu.edu.tr", 115);
            Customer customer3 = new Customer("Berke", "Savas", "9086723", "berkesavas@gmail.com", 200);
            //UserInterface referance points to Customer objects
            UserInterface MyCustomer1 = customer1;
            UserInterface MyCustomer2 = customer2;
            UserInterface MyCustomer3 = customer3;
            //with using UserInterface referance call overriden LoginSystem
            //This LoginSystem method call to the customer.LoginSystem()
            //Because MyCustomer UserInterface points to the customer object
            MyCustomer1.LoginSystem();
            MyCustomer2.LoginSystem();
            MyCustomer3.LoginSystem();

            BranchEmp3.addCustomer(MyCargoSystem, customer1);
            BranchEmp2.addCustomer(MyCargoSystem, customer2);
            BranchEmp2.addCustomer(MyCargoSystem, customer3);
            System.out.println("\nBranchEmployee add system customer1, customer2 and customer3");
            System.out.println("System has these Customers:");
            for (int i = 0; i < MyCargoSystem.getCustomers().size(); i++) {
                System.out.println(MyCargoSystem.getCustomers().get(i));
            }
            System.out.println();

            BranchEmp3.removeCustomer(MyCargoSystem, customer2);
            System.out.println("BranchEmployee remove customer2 from the system");
            System.out.println("My system has these customers:");
            for (int i = 0; i < MyCargoSystem.getCustomers().size(); i++) {
                System.out.println(MyCargoSystem.getCustomers().get(i));
            }

            ShipmentSent package1 = new ShipmentSent(112, "unknown", customer1, customer3);
            ShipmentSent package2 = new ShipmentSent(115, "unknown", customer3, customer1);
            ShipmentSent package3 = new ShipmentSent(3, "Yolda", customer1, customer3);
            //packages added to branches
            Branch1.getCargoPackage().add(package1);
            Branch1.getCargoPackage().add(package2);
            Branch2.getCargoPackage().add(package3);

            System.out.println("\nPackage1, Package2 and Package3 created");
            System.out.println("First Packages Info");
            System.out.println("Package1 Info:" + package1.getInformation());
            System.out.println("Package2 Info:" + package2.getInformation());
            System.out.println("Package3 Info:" + package3.getInformation());

            //BranchEmployee enter and remove information about ShipmentSents
            BranchEmp2.enterInformation(package1);
            BranchEmp2.enterInformation(package2);
            BranchEmp3.removeInformation(package3);

            System.out.println("\nAfter BranchEmployees chance the Informations of Packages:");
            System.out.println("Package1 Info:" + package1.getInformation());
            System.out.println("Package2 Info:" + package2.getInformation());
            System.out.println("Package3 Info:" + package3.getInformation() + "\n");

            System.out.println("After Tpersonnal1 deliver the package ");
            //Tpersonnal deliver Package and change the package info to "delivered"
            Tpersonnal1.deliverPackage(package2);
            System.out.println("Package2 Info:" + package2.getInformation() + "\n");

            System.out.println("Customer1 try to check package1 with his Tracking Number:");
            //Customer1 check package with tracking number
            customer1.TrackingPackage(package1);
        }
        catch(ArithmeticException x){
            System.out.println("\nERROR:For calling methods user must login to the System.");
            System.out.println("Exception Catched!");
        }
        catch (IllegalArgumentException y){
            System.out.println("\nERROR: You try to give BranchEmployee or Transportation personnel a Branch that doesn't belong to the in System");
            System.out.println("Exception Catched!");
        }
    }
}
