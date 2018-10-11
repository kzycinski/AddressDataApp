/**
 * @author Krystian Życiński
 */
package app;

import java.util.InputMismatchException;
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
        try {
            int buildingNumber = scanner.nextInt();
            try {
                AddressData addressData = new AddressDataBuilder()
                        .withCity(city)
                        .withPostalCode(postalCode)
                        .withBuildingNumber(buildingNumber)
                        .withStreet(street)
                        .build();
                System.out.println("AddressData object created successfully!");
                System.out.println(addressData);
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong building number.");
        }
    }
}
