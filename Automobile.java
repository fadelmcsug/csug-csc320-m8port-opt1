import java.util.List;

public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Default constructor
    public Automobile() {
        this.make = "unknown";
        this.model = "unknown";
        this.color = "unknown";
        this.year = 0;
        this.mileage = 0;
    }

    // Parameterized constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // TODO Add a new vehicle method
    public String addVehicle(List<Automobile> list) {
        try {
    		list.add(this);
        	return "Vehicle added successfully.";
        } catch (Exception e) {
        	return "Failed to add vehicle.";
        }
    }

    // List vehicle information method
    public String[] listVehicle() {
        return new String[]{make, model, color, String.valueOf(year), String.valueOf(mileage)};
    }

    // Remove vehicle method
    public String removeVehicle(List<Automobile> list) {
    	try {
    		if (list.remove(this)) {
    			return "Vehicle removed successfully.";
    		} else {
    			return "Vehicle to remove not found.";
    		}
    	} catch (Exception e) {
    		return "Failed to remove vehicle.";
    	}
    }

    // Update vehicle attributes method
    public String updateVehicle(String make, String model, String color, int year, int mileage) {
    	try {
	        this.make = make;
	        this.model = model;
	        this.color = color;
	        this.year = year;
	        this.mileage = mileage;
    		return "Vehicle updated successfully.";
    	}
    	catch (Exception e) {
    		return "Failed to update vehicle.";
    	}
    }
}
