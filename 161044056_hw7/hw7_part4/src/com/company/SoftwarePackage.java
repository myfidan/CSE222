package com.company;

public class SoftwarePackage implements Comparable<SoftwarePackage>{

    private String name;
    private int quantity;
    private double price;

    /**
     * Software constructor
     * @param name software name
     * @param quantity software quantity
     * @param price software price
     */
    public SoftwarePackage(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Compare to method for searchTree compare
     * @param o other software
     * @return 0 if softwares names equals, if my software name bigger than other software return positive
     * otherwise return negative value
     */
    @Override
    public int compareTo(SoftwarePackage o) {
        return name.compareTo(o.name);
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * setter for quantity
     * @param quantity quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * getter for price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter for price
     * @param price price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
