package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Ride;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.StationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddRideUI {
    private StationService stationService;
    private BikeService bikeService;
    private RideService rideService;
    private User user;

    AddRideUI(StationService stationService,BikeService bikeService,RideService rideService,User user){
        this.stationService = stationService;
        this.bikeService = bikeService;
        this.rideService = rideService;
        this.user = user;
    }

    public  void displayAddRideUI() throws BikeSharingException, IOException {
        Scanner scanner = new Scanner(System.in);


        //from where?
        System.out.println("You are about to take a ride. Select the start station: ");

        //display stations
        this.stationService.checkIfCachedStations().forEach((id, station) -> System.out.println(station));
        int startStationId=scanner.nextInt();

        //with which bike?
        System.out.println("These are the available bikes. Choose one! ");

        //display bikes in station that has been chosen

        ArrayList<Bike> bikeList = this.stationService.getBikeList(startStationId);
        for (Bike bike : bikeList)
            System.out.println(bike);
        int  bikeId = scanner.nextInt();

        //to where?
        System.out.println("Which station are you riding to? ");

        //display stations
        this.stationService.checkIfCachedStations().forEach((id, station) -> System.out.println(station));

        int endStationId = scanner.nextInt();

        //User id - has to be passed from the UI above!!!
        int userId = this.user.getId();

        //add the ride to the rides file
        Ride ride = new Ride(rideService.generateRideId(), userId, bikeId, startStationId,endStationId);
        rideService.addRide(ride);

        //move the place of the bike; change the entry in bikeStations file
        bikeService.cacheBikes();
        stationService.moveBikeFromStartStationToDestinationStation(bikeService.getBikeById(bikeId), startStationId, endStationId);
    }
}