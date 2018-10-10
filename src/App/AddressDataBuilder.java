/**
 *Builder class for AddressData.
 *
 *@author Krystian Życiński
 */

package app;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public class AddressDataBuilder {
    private OptionalInt buildingNumber = OptionalInt.empty();
    private Optional<String> postalCode = Optional.empty();
    private Optional<String> street = Optional.empty();
    private Optional<String> city = Optional.empty();

    public AddressData build() {
        return new AddressData(
                buildingNumber.orElseThrow(() -> new IllegalArgumentException("No building number set.")),
                postalCode.orElseThrow(() -> new IllegalArgumentException("No postal code set.")),
                street.orElseThrow(() -> new IllegalArgumentException("No street name set.")),
                city.orElseThrow(() -> new IllegalArgumentException("No city name set."))
        );
    }

    public AddressDataBuilder setBuildingNumber(int buildingNumber) {
        if (buildingNumber <= 0)
            throw new IllegalArgumentException("Wrong building number: " + buildingNumber);

        this.buildingNumber = OptionalInt.of(buildingNumber);

        return this;
    }

    public AddressDataBuilder setPostalCode(String postalCode) {
        Objects.requireNonNull(postalCode, "Postal code is null");

        if (postalCode.length() != 6)
            throw new IllegalArgumentException("Wrong postal code length");

        else if (!postalCode.matches("^[0-9]{2}-[0-9]{3}"))
            throw new IllegalArgumentException("Wrong postal code format: " + postalCode);

        this.postalCode = Optional.of(postalCode);

        return this;
    }

    public AddressDataBuilder setCity(String city) {
        Objects.requireNonNull(city, "City is null");

        if (city.equals(""))
            throw new IllegalArgumentException("City name is empty");

        else if (!Character.isUpperCase(city.codePointAt(0)))
            throw new IllegalArgumentException("Wrong city name: " + city);

        this.city = Optional.of(city);

        return this;
    }

    public AddressDataBuilder setStreet(String street) {
        Objects.requireNonNull(street, "Street is null");

        if (street.equals(""))
            throw new IllegalArgumentException("Street name is empty");

        this.street = Optional.of(street);

        return this;
    }
}
