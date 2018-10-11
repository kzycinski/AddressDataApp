/**
 * @author Krystian Życiński
 */
package app;

/**
 * AddressData class, needs to be a storage for city, postal code, street and building number
 * Building number has to be greater than 0
 * City name has to start with capital letter
 * Postal code has to be in XX-XXX format
 * Every field has to be initialized
 */

public class AddressData {
    private final int buildingNumber;
    private final String postalCode;
    private final String street;
    private final String city;

    AddressData(int buildingNumber, String postalCode, String street, String city) {
        this.buildingNumber = buildingNumber;
        this.postalCode = postalCode;
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString() {
        return ("City: " + this.getCity() +
                "\nPostal Code: " + this.getPostalCode() +
                "\nStreet: " + this.getStreet() +
                "\nBuilding number: " + this.getBuildingNumber());
    }

    public int getBuildingNumber() {
        return this.buildingNumber;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }
}