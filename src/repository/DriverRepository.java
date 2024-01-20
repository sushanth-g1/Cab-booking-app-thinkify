package repository;

import model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    List<Driver> drivers = new ArrayList<>();

    public void addDrivers(String name, int age, String vehicleDetails, int[] currentLocation){
        drivers.add(new Driver(name,age,vehicleDetails,currentLocation));
    }


}
