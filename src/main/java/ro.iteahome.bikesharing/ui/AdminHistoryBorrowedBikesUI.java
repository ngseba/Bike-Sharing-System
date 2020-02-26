package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Ride;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.StationService;
import ro.iteahome.bikesharing.service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminHistoryBorrowedBikesUI {
    private StationService stationService;
    private BikeService bikeService;
    private RideService rideService;
    private UserService userService;
    AdminHistoryBorrowedBikesUI(StationService stationService,BikeService bikeService,RideService rideService,UserService userService){
        this.stationService = stationService;
        this.bikeService = bikeService;
        this.rideService = rideService;
        this.userService = userService;
    }

    public void printHistoryOfBorrowedBikes() throws BikeSharingException {
        System.out.println("Users :");
        ArrayList<User> userList = userService.getUserList();
        for(User user : userList){
            System.out.println(user);
        }
        Scanner scanner = new Scanner(System.in);
        int userId = scanner.nextInt();
        ArrayList<Ride> rideList = rideService.getBorrowedBikesHistory(userId);
        System.out.println("History of borrowed bikes for the user "+userService.getUserById(userId).getName());
        for (Ride ride : rideList)
        {
            System.out.println("Borrowed bike : \""+bikeService.getBikeById(ride.getBikeId())+"\" from station : "+stationService.getStationById(ride.getStartStationId()).getName()+" to the station : " +stationService.getStationById(ride.getEndStationId()).getName());
        }
    }
}
