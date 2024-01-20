package service;

import repository.DriverRepository;

public class DriverService {
    DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }
    public void addDriver(String name,int age,String vehicleDetails,int[] currentLocation){
        driverRepository.addDrivers(name,age,vehicleDetails,currentLocation);
    }
}
