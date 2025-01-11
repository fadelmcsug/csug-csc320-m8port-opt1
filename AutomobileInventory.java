import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomobileInventory {
    public static void main(String[] args) {
        List<Automobile> automobileInventory = new ArrayList<Automobile>();
        
        Automobile car = new Automobile("Toyota", "Corolla", "Red", 2020, 15000);
        
        // List vehicle information
        System.out.println(automobileInfoAsLines(car.listVehicle()));

        // Remove vehicle. there's nothing to remove in the inventory list
        System.out.println(car.removeVehicle(automobileInventory));

        // Add a new vehicle
        Automobile car1 = new Automobile("Honda", "Accord", "Green", 2016, 120000);
        System.out.println(car1.addVehicle(automobileInventory));
        System.out.println(automobileInfoAsLines(car1.listVehicle()));
        
        // Update vehicle
        System.out.println(car.updateVehicle("Ford", "Mustang", "Black", 2022, 5000));
        System.out.println(automobileInfoAsLines(car.listVehicle()));

        // Ask user if they want to print the information to a file
        Scanner scnr = new Scanner(System.in);
        String response = "";
        boolean validResponse = false;
        System.out.println("Do you want to print the information to a file? (Y/N)");
        
        while (!validResponse) {
        	response = scnr.nextLine();
        	boolean responseYes = response.equalsIgnoreCase("Y");
        	boolean responseNo = response.equalsIgnoreCase("N");        	
        	validResponse = responseYes || responseNo;
        	if (responseYes) {
                try (FileWriter writer = new FileWriter(".\\Autos.txt")) {
                	for (Automobile a : automobileInventory) {
                		writer.write(automobileInfoAsLines(a.listVehicle()));
                		writer.write("\n");
                	}
                    System.out.println("Information printed to file.");
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file.");
                }
            } else if (responseNo) {
                System.out.println("File will not be printed.");
            } else {
            	System.out.println("Invalid option. Please enter 'Y' or 'N'.");
            }
        }
        
        scnr.close();
    }
    
    public static String automobileInfoAsLines(String[] info) {
    	String returnString = "";
    	for (String i : info) {
    		returnString += i + "\n";
    	}
		return returnString;
    }
}
