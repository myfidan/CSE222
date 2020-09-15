package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    try{
	        mySystem system=new mySystem();
            Administator admin1= new Administator("Yasir","Fidan");
            User user1= new User("Hikmet","Turan");
            //admin enter system with password 123@pass
            admin1.enterSystem(system,"123@pass");
            //Adobe Photoshop 6.0, Adobe Photoshop 6.2, Norton 4.5, Norton 5.5, Adobe Flash 3.3, Adobe Flash 4.0.
            SoftwarePackage software1=new SoftwarePackage("Adobe Photoshop 6.0",5,14.5);
            SoftwarePackage software2=new SoftwarePackage("Adobe Photoshop 6.2",10,18);
            SoftwarePackage software3=new SoftwarePackage("Norton 4.5",3,9.99);
            SoftwarePackage software4=new SoftwarePackage("Norton 5.5",15,5);
            SoftwarePackage software5=new SoftwarePackage("Adobe Flash 3.3",20,22.5);
            SoftwarePackage software6=new SoftwarePackage("Adobe Flash 4.0",16,28.75);

            //Admin add softwares to the system
            admin1.add(system,software1);
            admin1.add(system,software2);
            admin1.add(system,software3);
            admin1.add(system,software4);
            admin1.add(system,software5);
            admin1.add(system,software6);

            Scanner input = new Scanner(System.in);
            Scanner text = new Scanner(System.in);
            boolean whileFlag=true;
            while(whileFlag){
                System.out.println("**********************************");
                System.out.println("Choose operation:");
                System.out.println("1-Add software");
                System.out.println("2-Delete software");
                System.out.println("3-Increase quantity of a software");
                System.out.println("4-Decrease quantity of a software");
                System.out.println("5-Search a software by name");
                System.out.println("6-Exit");
                System.out.println("**********************************");

                int choose=input.nextInt();

                switch (choose){
                    case 1://sisteme bir yazilim ekler
                        System.out.println("Adding software to the system.");
                        System.out.print("Enter software name:");
                        String softName = text.nextLine();
                        System.out.print("Enter software quantity:");
                        int quantity = input.nextInt();
                        System.out.print("Enter software price:");
                        int price = input.nextInt();
                        SoftwarePackage newSoftProduct = new SoftwarePackage(softName,quantity,price);
                        admin1.add(system,newSoftProduct);
                        break;
                    case 2://sistemden bir yazilim siler
                        System.out.println("Deleting software from the system.");
                        System.out.println("Enter software name you want to delete:");
                        String softNameDelete = text.nextLine();
                        admin1.delete(system,admin1.search(system,softNameDelete));
                        break;
                    case 3://mevcut bit yazilimin quantitysini arttırır
                        System.out.println("Increasing software quantity.");
                        System.out.println("Enter software name:");
                        String softNameQuantity = text.nextLine();
                        System.out.println("Enter software Quantity you want to add:");
                        int softwareQuantity = input.nextInt();
                        admin1.addQuantity(system,softNameQuantity,softwareQuantity);
                        break;
                    case 4://mevcut bir yazilimin quantitysini azaltır
                        System.out.println("Decreasing software quantity.");
                        System.out.println("Enter software name");
                        String softNameQuantityDelete = text.nextLine();
                        System.out.println("Enter quantity you want to delete");
                        int softwareQuantityDelete = input.nextInt();
                        admin1.deleteQuantity(system,softNameQuantityDelete,softwareQuantityDelete);
                        break;
                    case 5://sistemde bir yazilim arar ve bilgileri ekrana basar
                        System.out.println("Search software.");
                        System.out.println("Enter software name you want to search:");
                        String softwareSearch = text.nextLine();
                        System.out.println(softwareSearch);
                        SoftwarePackage softwareRef = user1.search(system,softwareSearch);
                        if(softwareRef != null){
                            System.out.println("Software Founded:");
                            System.out.println("Software name: "+softwareRef.getName());
                            System.out.println("Software quantity: "+softwareRef.getQuantity());
                            System.out.println("Software price: "+softwareRef.getPrice());
                        }
                        else{
                            System.out.println("There is no software called "+softwareSearch+" in system.");
                        }
                        break;
                    case 6://menuden cikar ve program, sonlandirir
                        whileFlag=false;
                        break;
                    default:
                        System.out.println("Input error,try again");
                }
            }


        }catch (IllegalArgumentException x){
            System.out.println("Exception catched program terminated.");
        }

    }
}
