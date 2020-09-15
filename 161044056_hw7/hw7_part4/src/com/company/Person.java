package com.company;

public class Person {
    private String name;
    private String surname;

    /**
     * Person constructor
     * @param name String name
     * @param surname String surname
     */
    public Person(String name,String surname){
        this.name=name;
        this.surname=surname;
    }

    /**
     * Search method
     * Admin and user can use this method
     * @param system mySystem
     * @param softwareName software name that will be added
     * @return
     */
    public SoftwarePackage search(mySystem system,String softwareName){
        SoftwarePackage searchByName=new SoftwarePackage(softwareName,-1,-1);
        if(system.getSoftwares().find(searchByName)!=null){
            return system.getSoftwares().find(searchByName);
        }
        else{
            return null;
        }
    }

    /**
     * getter name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name set name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get surname
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * setter for surname
     * @param surname surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
