package tests;

import app.AddressData;
import app.AddressDataBuilder;
import org.junit.Test;

/**
 * @author Krystian Życiński
 *
 * Tests for AddressDataBuilder class
 */

public class AddressDataBuilderTest {

    @Test(expected = NullPointerException.class)
    public void testCityNameIsNull() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withCity(null);
    }

    @Test(expected = NullPointerException.class)
    public void testStreetIsNull() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withStreet(null);
    }

    @Test(expected = NullPointerException.class)
    public void testPostalCodeIsNull() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withPostalCode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCityNameIsEmptyString() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withCity("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStreetNameIsEmptyString() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withStreet("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostalCodeIsEmptyString() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withPostalCode("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildingNumberIsZero() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withBuildingNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildingNumberIsNegative() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withBuildingNumber(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooLongPostalCode() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withPostalCode("12-3456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostalCodeWithoutPause() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withPostalCode("123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLettersInPostalCode() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withPostalCode("12-34a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCityNameStartsWithSmallLetter() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withCity("city");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingAnything() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingBuildingNumber() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withPostalCode("12-345")
                .withCity("City")
                .withStreet("Street")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingCity() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withPostalCode("12-345")
                .withBuildingNumber(10)
                .withStreet("Street")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingStreet() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withPostalCode("12-345")
                .withCity("City")
                .withBuildingNumber(10)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildWithoutSettingPostalCode() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withBuildingNumber(10)
                .withCity("City")
                .withStreet("Street")
                .build();
    }

    @Test
    public void testBuildWithCorrectData() {
        AddressDataBuilder addressDataBuilder = AddressData.builder();
        addressDataBuilder.withBuildingNumber(10)
                .withPostalCode("12-345")
                .withStreet("Street")
                .withCity("City")
                .build();
    }
}