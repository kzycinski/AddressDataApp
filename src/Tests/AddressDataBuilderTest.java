package Tests;


import App.AddressData;
import App.AddressDataBuilder;
import org.junit.Test;

public class AddressDataBuilderTest {
    AddressDataBuilder addressDataBuilder = new AddressDataBuilder();
    @Test(expected = IllegalArgumentException.class)
    public void testCityNameIsNull(){
        AddressData addressData = addressDataBuilder.buildAddressData(10, "12-34a", "Street", null);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testStreetIsNull(){
        AddressData addressData = addressDataBuilder.buildAddressData(10, "12-34a", null, "City");

    }
    @Test(expected = IllegalArgumentException.class)
    public void testPostalCodeIsNull(){
        AddressData addressData = addressDataBuilder.buildAddressData(10, null, "Street", "City");

    }
    @Test(expected = IllegalArgumentException.class)
    public void testBuildingNumberIsZero(){
        AddressData addressData = addressDataBuilder.buildAddressData(0, "12-34a", "Street", null);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testBuildingNumberIsNegative() {
        AddressData addressData = addressDataBuilder.buildAddressData(-10, "12-345", "Street", "City");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooLongPostalCode() {
        AddressData addressData = addressDataBuilder.buildAddressData(10, "12-3456", "Street", "City");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostalCodeWithoutPause() {
        AddressData addressData = addressDataBuilder.buildAddressData(10, "123456", "Street", "City");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLettersInPostalCode() {
        AddressData addressData = addressDataBuilder.buildAddressData(10, "12-34a", "Street", "City");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCityNameStartsWithSmallLetter(){
        AddressData addressData = addressDataBuilder.buildAddressData(10, "12-34a", "Street", "city");

    }

}
