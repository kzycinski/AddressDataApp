package App;

public class AddressData {
    private final int buildingNumber;
    private final String postalCode;
    private final String street;
    private final String city;

    public AddressData(int buildingNumber, String postalCode, String street, String city) {
        this.buildingNumber = buildingNumber;
        this.postalCode = postalCode;
        this.street = street;
        this.city = city;
    }

    public int getBuildingNumber() { return this.buildingNumber; }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() { return this.city; }
}
