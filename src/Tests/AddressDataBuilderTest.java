/**
 * Tests for AddressDataBuilder class
 *
 * @author Krystian Życiński
 */
package tests;

import app.AddressDataBuilder;
import org.junit.Test;

public class AddressDataBuilderTest {
    private AddressDataBuilder addressDataBuilder = new AddressDataBuilder();

    @Test(expected = NullPointerException.class)
    public void testCityNameIsNull() {
        addressDataBuilder.setCity(null);
    }

    @Test(expected = NullPointerException.class)
    public void testStreetIsNull() {
        addressDataBuilder.setStreet(null);
    }

    @Test(expected = NullPointerException.class)
    public void testPostalCodeIsNull() {
        addressDataBuilder.setPostalCode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildingNumberIsZero() {
        addressDataBuilder.setBuildingNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildingNumberIsNegative() {
        addressDataBuilder.setBuildingNumber(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooLongPostalCode() {
        addressDataBuilder.setPostalCode("12-3456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostalCodeWithoutPause() {
        addressDataBuilder.setPostalCode("123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLettersInPostalCode() {
        addressDataBuilder.setPostalCode("12-34a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCityNameStartsWithSmallLetter() {
        addressDataBuilder.setCity("city");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCityNameIsEmptyString() {
        addressDataBuilder.setCity("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStreetNameIsEmptyString() {
        addressDataBuilder.setCity("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostalCodeIsEmptyString() {
        addressDataBuilder.setCity("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingAnything() {
        AddressDataBuilder tmp = new AddressDataBuilder();
        tmp.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingBuildingNumber() {
        AddressDataBuilder tmp = new AddressDataBuilder();
        tmp.setPostalCode("12-345")
                .setCity("City")
                .setStreet("Street")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingCity() {
        AddressDataBuilder tmp = new AddressDataBuilder();
        tmp.setPostalCode("12-345")
                .setBuildingNumber(10)
                .setStreet("Street")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingStreet() {
        AddressDataBuilder tmp = new AddressDataBuilder();
        tmp.setPostalCode("12-345")
                .setCity("City")
                .setBuildingNumber(10)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingPostalCode() {
        AddressDataBuilder tmp = new AddressDataBuilder();
        tmp.setBuildingNumber(10)
                .setCity("City")
                .setStreet("Street")
                .build();
    }

    @Test
    public void testBuildWithCorrectData() {
        AddressDataBuilder tmp = new AddressDataBuilder();
        tmp.setBuildingNumber(10)
                .setPostalCode("12-345")
                .setStreet("Street")
                .setCity("City")
                .build();
    }
}