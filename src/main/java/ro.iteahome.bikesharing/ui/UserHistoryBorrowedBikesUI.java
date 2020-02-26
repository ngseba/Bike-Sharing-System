package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Ride;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.StationService;

import java.util.ArrayList;
import java.util.Scanner;

public class UserHistoryBorrowedBikesUI {
    private StationService stationService;
    private BikeService bikeService;
    private RideService rideService;
    private User user;
    UserHistoryBorrowedBikesUI(StationService stationService,BikeService bikeService,RideService rideService,User user){
        this.stationService = stationService;
        this.bikeService = bikeService;
        this.rideService = rideService;
        this.user = user;
    }
    public void printHistoryOfBorrowedBikes() throws BikeSharingException {
        int userId = this.user.getId();
        ArrayList<Ride> rideList = rideService.getBorrowedBikesHistory(userId);
        System.out.println("History of borrowed bikes for the user "+user.getName());
        for (Ride ride : rideList)
        {
            System.out.println("Borrowed bike : \""+bikeService.getBikeById(ride.getBikeId())+"\" from station : "+stationService.getStationById(ride.getStartStationId()).getName()+" to the station : " +stationService.getStationById(ride.getEndStationId()).getName());
        }
    }
}
