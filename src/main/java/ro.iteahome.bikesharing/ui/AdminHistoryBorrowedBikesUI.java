package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Query;
import ro.iteahome.bikesharing.model.Ride;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminHistoryBorrowedBikesUI {
    private RideService rideService;
    private UserService userService = new UserService();
    AdminHistoryBorrowedBikesUI(RideService rideService){
        this.rideService = rideService;
    }


    public void printHistoryOfBorrowedBikes() throws BikeSharingException {
        QueryService queryService = new QueryService();
        Query query = new Query();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Users :");
        ArrayList<User> userList = userService.getUserList();
        for(User user : userList){
            System.out.println(user);
        }
        int userId = scanner.nextInt();
        ArrayList<Ride> rideList = rideService.getBorrowedBikesHistory(userId);
        String message = "History of borrowed bikes for the user "+userService.getUserById(userId).getName();
        System.out.println(message);
        query.setMessage(message);
        for (Ride ride : rideList)
        {
            String queryResult = "Borrowed bike : \""+this.rideService.getBikeService().getBikeById(ride.getBikeId())+"\" from station : "+this.rideService.getStationService().getStationById(ride.getStartStationId()).getName()+" to the station : " +this.rideService.getStationService().getStationById(ride.getEndStationId()).getName();
            System.out.println(queryResult);
            query.addQueryResult(queryResult);
        }
        queryService.printQuery(query);
    }
}
