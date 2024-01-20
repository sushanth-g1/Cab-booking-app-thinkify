package service;

import exception.RideException;
import model.Ride;
import repository.RideRepository;

import java.util.List;

public class RideService {
    RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    //    public List<Ride> findRide(String username,int[] userLocation,int[] userDestination){
//        return rideRepository.findRide(userLocation,userDestination);
//    }
    public List<Ride> findRide(String username, int[] userLocation, int[] userDestination) {
        List<Ride> availableRides = rideRepository.findRide(userLocation, userDestination);

        if (availableRides.isEmpty()) {
            System.out.println("No rides available for " + username);
        } else {
            System.out.println("Rides available for " + username + ":");
            for (Ride ride : availableRides) {
                System.out.println("Driver: " + ride.driverName + " [Available]");
                ride.available = false;
            }
        }

        return availableRides;
    }

    public synchronized void chooseRide(String username, String driverName) throws RideException {
        for (Ride ride : rideRepository.rides) {
            if (ride.driverName.equals(driverName) && ride.available) {
                ride.available = false;
                System.out.println(username + " is riding with " + driverName);
                return;
            }
        }
        throw new RideException( "Ride not available or already chosen");
    }

}
