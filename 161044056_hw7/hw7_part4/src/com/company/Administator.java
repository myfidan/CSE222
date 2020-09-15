package com.company;

public class Administator extends Person{

    private boolean inSystem=false;

    /**
     * Constructer
     * @param name name
     * @param surname surname
     */
    public Administator(String name, String surname){
        super(name,surname);
    }

    /**
     * check admin in system or not
     * @return isSystem
     */
    public boolean isInSystem() {
        return inSystem;
    }

    /**
     * setter for isInSystem
     * @param inSystem isInSystem
     */
    public void setInSystem(boolean inSystem) {
        this.inSystem = inSystem;
    }

    /**
     * Method for enter system
     * @param system my system
     * @param pass password
     */
    public void enterSystem(mySystem system,String pass){
        if(pass.equals(system.getPass())){
            inSystem=true;
        }
        else{
            inSystem=false;
        }
    }

    /**
     * Add software to the system
     * @param system system
     * @param software software
     * @throws IllegalArgumentException if admin is not in system throw
     */
    public void add(mySystem system,SoftwarePackage software)throws IllegalArgumentException{
        if(inSystem){
            system.getSoftwares().add(software);
        }
        else{
            System.out.println("Error when adding software : Admin isn't in system");
            throw new IllegalArgumentException();
        }
    }

    /**
     * add quantity to a software
     * @param system my system
     * @param softwareName software name
     * @param productQuantity added quantity
     * @throws IllegalArgumentException if admin is not in system throw
     */
    public void addQuantity(mySystem system,String softwareName,int productQuantity)throws IllegalArgumentException{
        if(inSystem){
            if(search(system,softwareName)!=null){
                update(system,softwareName,productQuantity,true);
            }
            else{
                System.out.println("Can't find software..");
            }
        }
        else{
            System.out.println("Error when adding Quantity: Admin isn't in system");
            throw new IllegalArgumentException();
        }
    }

    /**
     * delete a software in system
     * @param system my system
     * @param software software that will be deleted
     * @throws IllegalArgumentException throw excaption if admin is not in system
     */
    public void delete(mySystem system,SoftwarePackage software)throws IllegalArgumentException{
        if(inSystem){
            if(software !=null){
                system.getSoftwares().delete(software);
            }
            else{
                System.out.println("Can't find software..");
            }
        }
        else{
            System.out.println("Error when deleting software: Admin isn't in system");
            throw new IllegalArgumentException();
        }
    }

    /**
     * delete quantity of a software
     * @param system system
     * @param softwareName software name
     * @param productQuantity product that will deleted
     * @throws IllegalArgumentException throw excaption if admin is not in system
     */
    public void deleteQuantity(mySystem system,String softwareName,int productQuantity)throws IllegalArgumentException{
        if(inSystem){
            if(search(system,softwareName)!=null){
                update(system,softwareName,productQuantity,false);
            }
            else{
                System.out.println("Can't find software..");
            }
        }
        else{
            System.out.println("Error when deleting Quantity: Admin isn't in system");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Update method for update quantity of softwares I use this method in delete and add quantity methods
     * @param system system
     * @param softwareName software name
     * @param productQuantity produtct that will added or deleted
     * @param addQuantity true if quantity added, false if quantity deleted
     * @throws IllegalArgumentException throw excaption if admin is not in system
     */
    public void update(mySystem system,String softwareName,int productQuantity,boolean addQuantity)throws IllegalArgumentException{
        if(inSystem){
            if(addQuantity){
                SoftwarePackage searchByName=new SoftwarePackage(softwareName,-1,-1);
                system.getSoftwares().find(searchByName).setQuantity(system.getSoftwares().find(searchByName).getQuantity()+productQuantity);
            }
            else{
                SoftwarePackage searchByName=new SoftwarePackage(softwareName,-1,-1);
                system.getSoftwares().find(searchByName).setQuantity(system.getSoftwares().find(searchByName).getQuantity()-productQuantity);
                if(system.getSoftwares().find(searchByName).getQuantity()<=0){
                    delete(system,system.getSoftwares().find(searchByName));
                }
            }
        }
        else{
            System.out.println("Error when updating: Admin isn't in system");
            throw new IllegalArgumentException();
        }
    }
}
