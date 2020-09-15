/**
 * Branch Addresslerini tutmak icin kullandıgım class
 * @author MuhammedYasirFidan
 * @version 1.0.0
 * @since 2020-2-22
 */
public class Address {
    private String Country;
    private String City;
    private int StreetNo;

    /**
     * 3 parameter constructor
     * @param Country parameter for this.country
     * @param City  parameter for this.city
     * @param StreetNo parameter for this.StreetNo
     */
    public Address(String Country,String City,int StreetNo){
        this.Country=Country;
        this.City=City;
        this.StreetNo=StreetNo;
    }

    /**
     * No parameter Constructer
     */
    public Address(){
        this.Country="unknown";
        this.City="unknown";
        this.StreetNo=0;
    }

    /**
     * 3 parameter setter for Address object
     * @param Country parameter for this.Country
     * @param City  parameter for this.city
     * @param StreetNo  parameter for this.StreetNo
     */
    public void setAddress(String Country,String City,int StreetNo){
        this.Country=Country;
        this.City=City;
        this.StreetNo=StreetNo;
    }

    /**
     * Getter for Street No
     * @return StreetNo
     */
    public int getStreetNo() {
        return StreetNo;
    }

    /**
     * Getter for City
     * @return City
     */
    public String getCity() {
        return City;
    }

    /**
     * Getter for Country
     * @return Country
     */
    public String getCountry() {
        return Country;
    }
}
