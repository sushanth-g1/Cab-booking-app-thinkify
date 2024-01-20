import model.Ride;
import repository.DriverRepository;
import repository.RideRepository;
import repository.UserRepository;
import service.DriverService;
import service.RideService;
import service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        DriverRepository driverRepository = new DriverRepository();
        RideRepository rideRepository = new RideRepository();

        UserService userService = new UserService(userRepository);
        DriverService driverService = new DriverService(driverRepository);
        RideService rideService = new RideService(rideRepository);

        userService.addUser("Abhishek","M",23);
        userService.addUser("Rahul", "M", 29);
        userService.addUser("Nandini", "F", 22);


        driverService.addDriver("Driver1",30,"Brezza",new int[]{10,1});
        driverService.addDriver("Driver2",  29, "Swift", new int[]{11, 10});
        driverService.addDriver("Driver3",  24, "Innova", new int[]{5, 3});

        rideRepository.rides.add(new Ride("Driver1", new int[]{10, 1}, new int[]{20, 3},true));
        rideRepository.rides.add(new Ride("Driver2", new int[]{11, 10}, new int[]{15, 3},true));
        rideRepository.rides.add(new Ride("Driver3",new int[]{5, 3}, new int[]{25, 5},true));


        List<Ride> availableRides = rideService.findRide("Abhishek",new int[]{0,0},new int[]{20,1});
        printRides("Abhishek", availableRides);

        availableRides = rideService.findRide("Rahul", new int[]{10, 0}, new int[]{15, 3});
        printRides("Rahul", availableRides);

        availableRides = rideService.findRide("Nandini", new int[]{15, 6}, new int[]{20, 4});
        printRides("Nandini", availableRides);

        try {
            rideService.chooseRide("Abhishek","Driver1");
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void printRides(String username,List<Ride> rides){
        if(rides.isEmpty()){
            System.out.println("No rides available for "+username);
        }else {
            System.out.println("Rides available for "+username+" : ");
            for (Ride ride : rides){
                System.out.println("Driver : "+ride.driverName);
            }
        }
    }
}