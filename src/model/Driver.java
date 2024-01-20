package model;

public class Driver {
    String name;
    int age;
    String vehicleDetails;
    int[] currentLocation;
    boolean available;

    public Driver(String name, int age, String vehicleDetails, int[] currentLocation) {
        this.name = name;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.currentLocation = currentLocation;
        this.available = true;
    }

}
