package App;

public class AddressDataBuilder {

    public AddressData buildAddressData(int buildingNumber, String postalCode, String street, String city) {
        if (!validateBuildingNumber(buildingNumber))
            throw new IllegalArgumentException("Building number has to be greater than 0!\n");

        if (!validatePostalCode(postalCode))
            throw new IllegalArgumentException("Wrong postal code format!\n " +
                    "Correct format: XX-XXX\n");

        if (!validateCity(city))
            throw new IllegalArgumentException("Wrong city format!\n" +
                    "First character has to be capital letter\n");

        return new AddressData(buildingNumber, postalCode, street, city);
    }

    private boolean validateBuildingNumber(int buildingNumber) {
        return buildingNumber > 0;
    }

    private boolean validateCity(String city) {
        if (city == null || city.equals(""))
            return false;

        return Character.isUpperCase(city.codePointAt(0));
    }

    private boolean validatePostalCode(String postalCode) {
        if (postalCode == null || postalCode.length() != 6)
            return false;
        return postalCode.matches("^[0-9]{2}-[0-9]{3}");
    }
}
