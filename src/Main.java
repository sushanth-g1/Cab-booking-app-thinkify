import model.Ride;
import model.User;
import repository.DriverRepository;
import repository.RideRepository;
import repository.UserRepository;
import service.DriverService;
import service.RideService;
import service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        DriverRepository driverRepository = new DriverRepository();
        RideRepository rideRepository = new RideRepository();

        UserService userService = new UserService(userRepository);
        DriverService driverService = new DriverService(driverRepository);
        RideService rideService = new RideService(rideRepository);

        HashMap<String,List<Ride>> userRideMap = new HashMap<>();
        HashMap<String,User> userInfoMap = new HashMap<>();

        userService.addUser("Abhishek","M",23,new int[]{0,0},new int[]{20,1});
        userService.addUser("Inchara", "F", 23, new int[]{10, 0}, new int[]{15, 3});
        userService.addUser("Nandini", "F", 22, new int[]{15, 6}, new int[]{20, 4});

        List<User> usersList = userRepository.getUsers();
        for (User user : usersList){
            userInfoMap.put(user.getName(),user);
        }

        driverService.addDriver("Driver1",30,"Brezza",new int[]{10,1});
        driverService.addDriver("Driver2",  29, "Swift", new int[]{11, 10});
        driverService.addDriver("Driver3",  24, "Innova", new int[]{5, 3});

        rideRepository.rides.add(new Ride("Driver1", new int[]{10, 3}, new int[]{20, 3},true));
        rideRepository.rides.add(new Ride("Driver2", new int[]{10, 1}, new int[]{15, 3},true));
        rideRepository.rides.add(new Ride("Driver3",new int[]{5, 3}, new int[]{25, 5},true));


        List<Ride> availableRides = rideService.findRide("Abhishek",userInfoMap.get("Abhishek"));
        userRideMap.put("Abhishek",availableRides);
        printRides("Abhishek", availableRides);

        availableRides = rideService.findRide("Inchara",userInfoMap.get("Inchara"));
        userRideMap.put("Inchara",availableRides);
        printRides("Inchara", availableRides);

        availableRides = rideService.findRide("Nandini",userInfoMap.get("Nandini"));
        userRideMap.put("Nandini",availableRides);
        printRides("Nandini", availableRides);

        try {
            System.out.println(" in choosing ride ");
            rideService.chooseRide("Inchara","Driver1", userRideMap.get("Inchara"), userInfoMap.get("Inchara"));
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