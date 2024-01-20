package repository;

import model.Ride;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RideRepository {
    public List<Ride> rides = new ArrayList<>();
    public List<Ride> findRide(int[] userLocation,int[] userDestination){
        List<Ride> availableRides = new CopyOnWriteArrayList<>();
        for (Ride ride :rides){
            System.out.println(" ************************** ");
            if(ride.available && isInRange(ride.source, userLocation) && isInRange(ride.destination, userDestination)){
                availableRides.add(ride);
            }
        }
        return availableRides;
    }

    private boolean isInRange(int[] point1,int[] point2){
        double distance = Math.sqrt(Math.pow(point1[0]-point2[0],2)+Math.pow(point1[1]-point2[1],2));
        return distance <= 5;
    }
}
