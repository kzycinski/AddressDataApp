/**
 * @author Krystian Życiński
 */
package tests;

import app.AddressDataBuilder;
import org.junit.Test;

/**
 *   Tests for AddressDataBuilder class
 */

public class AddressDataBuilderTest {
    private AddressDataBuilder addressDataBuilder = new AddressDataBuilder();

    @Test(expected = NullPointerException.class)
    public void testCityNameIsNull() {
        addressDataBuilder.withCity(null);
    }

    @Test(expected = NullPointerException.class)
    public void testStreetIsNull() {
        addressDataBuilder.withStreet(null);
    }

    @Test(expected = NullPointerException.class)
    public void testPostalCodeIsNull() {
        addressDataBuilder.withPostalCode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildingNumberIsZero() {
        addressDataBuilder.withBuildingNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildingNumberIsNegative() {
        addressDataBuilder.withBuildingNumber(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooLongPostalCode() {
        addressDataBuilder.withPostalCode("12-3456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostalCodeWithoutPause() {
        addressDataBuilder.withPostalCode("123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLettersInPostalCode() {
        addressDataBuilder.withPostalCode("12-34a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCityNameStartsWithSmallLetter() {
        addressDataBuilder.withCity("city");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCityNameIsEmptyString() {
        addressDataBuilder.withCity("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStreetNameIsEmptyString() {
        addressDataBuilder.withStreet("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostalCodeIsEmptyString() {
        addressDataBuilder.withPostalCode("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingAnything() {
        AddressDataBuilder addressDataBuilder = new AddressDataBuilder();
        addressDataBuilder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingBuildingNumber() {
        AddressDataBuilder addressDataBuilder = new AddressDataBuilder();
        addressDataBuilder.withPostalCode("12-345")
                .withCity("City")
                .withStreet("Street")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingCity() {
        AddressDataBuilder addressDataBuilder = new AddressDataBuilder();
        addressDataBuilder.withPostalCode("12-345")
                .withBuildingNumber(10)
                .withStreet("Street")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingStreet() {
        AddressDataBuilder addressDataBuilder = new AddressDataBuilder();
        addressDataBuilder.withPostalCode("12-345")
                .withCity("City")
                .withBuildingNumber(10)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingPostalCode() {
        AddressDataBuilder addressDataBuilder = new AddressDataBuilder();
        addressDataBuilder.withBuildingNumber(10)
                .withCity("City")
                .withStreet("Street")
                .build();
    }

    @Test
    public void testBuildWithCorrectData() {
        AddressDataBuilder addressDataBuilder = new AddressDataBuilder();
        addressDataBuilder.withBuildingNumber(10)
                .withPostalCode("12-345")
                .withStreet("Street")
                .withCity("City")
                .build();
    }
}