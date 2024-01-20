package service;

import exception.RideException;
import model.Ride;
import model.User;
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
    public List<Ride> findRide(String username,User user) {

        List<Ride> availableRides = rideRepository.findRide(user.getUserSource(), user.getUserDestination());

        if (availableRides.isEmpty()) {
            System.out.println("No rides available for " + username);
        } else {
            System.out.println("Rides available for " + username + ":");
            for (Ride ride : availableRides) {
                System.out.println("Driver: " + ride.driverName + " [Available]");
//                ride.available = false;
            }
        }

        return availableRides;
    }

    public synchronized void chooseRide(String username, String driverName, List<Ride> availableRides, User user) throws RideException {
        if (availableRides.isEmpty()) {
            System.out.println("No rides available for " + username);
            return;
        }
        for (Ride ride : availableRides) {
            if (ride.driverName.equals(driverName) && ride.available) {
                Ride nearestRide = getNearestRide(user.getUserSource(), availableRides);
                if (nearestRide != null) {
                    nearestRide.available = false;
                    System.out.println(username + " is riding with the nearest driver: " + nearestRide.driverName);
                } else {
                    throw new RideException("Error choosing the nearest ride.");
                }
//                ride.available = false;
//                System.out.println(username + " is riding with " + driverName);
                return;
            }
        }
        throw new RideException( "Ride not available or already chosen");
    }

    private Ride getNearestRide(int[] userlocation,List<Ride> rides){
        System.out.println(userlocation);
        Ride nearestRide = null;
        double minDistance = Double.MAX_VALUE;
        for (Ride ride : rides){
            double distance = Math.sqrt(Math.pow(ride.source[0]-userlocation[0],2)+Math.pow(ride.source[1]-userlocation[1],2));
            if(distance<minDistance){
                minDistance = distance;
                nearestRide = ride;
            }
        }
        return nearestRide;
    }

}
