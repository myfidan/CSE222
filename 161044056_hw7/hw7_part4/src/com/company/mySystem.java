package com.company;

public class mySystem {
    //system pass
    private String pass="123@pass";
    //my structure for hold software products it implements searchtree interface
    private SearchTree<SoftwarePackage> softwares=new myStructure<>();

    /**
     * Getter for sotwares
     * @return softwares in system
     */
    public SearchTree<SoftwarePackage> getSoftwares() {
        return softwares;
    }

    /**
     * setter for softwares
     * @param softwares my softwares in system
     */
    public void setSoftwares(myStructure<SoftwarePackage> softwares) {
        this.softwares = softwares;
    }

    /**
     * getter for password
     * @return password
     */
    public String getPass() {
        return pass;
    }

    /**
     * setter for password
     * @param pass password
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}
