/**
 * @author Krystian Życiński
 */
package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert city: ");
        String city = scanner.nextLine();
        System.out.println("Insert postal code: ");
        String postalCode = scanner.nextLine();
        System.out.println("Insert street: ");
        String street = scanner.nextLine();
        System.out.println("Insert building number: ");
        int buildingNumber = scanner.nextInt();
        try {
            AddressData tmp = new AddressDataBuilder()
                    .setCity(city)
                    .setPostalCode(postalCode)
                    .setBuildingNumber(buildingNumber)
                    .setStreet(street)
                    .build();
            System.out.println("AddressData object created successfully!");
            System.out.println("City: " + tmp.getCity() +
                    "\nPostal Code: " + tmp.getPostalCode() +
                    "\nStreet: " + tmp.getStreet() +
                    "\nBuilding number: " + tmp.getBuildingNumber());

        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Huh?");
        }
    }
}
