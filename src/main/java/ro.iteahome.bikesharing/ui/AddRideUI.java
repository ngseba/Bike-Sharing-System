package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Ride;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.BikeStationService;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.StationService;

import java.io.IOException;
import java.util.Scanner;

public class AddRideUI {

    private StationService stationService = new StationService();
    private BikeService bikeService = new BikeService();
    private RideService rideService = new RideService();
    private BikeStationService bikeStationService = new BikeStationService();

    public void displayAddRideUI() throws BikeSharingException, IOException {

        Scanner scanner = new Scanner(System.in);

        //from where?
        System.out.println("You are about to take a ride. Select the start station: ");

        //display stations
        stationService.printOutAllStations();

        String startStationId = scanner.nextLine();

        //with which bike?
        System.out.println("These are the available bikes. Choose one! ");

        //display bikes in station that has been chosen
        bikeService.printOutBikesOfStation(Integer.parseInt(startStationId));

        String bikeId = scanner.nextLine();

        //to where?
        System.out.println("Which station are you riding to? ");

        //display stations
        stationService.printOutAllStations();

        String endStationId = scanner.nextLine();

        //User id - has to be passed from the UI above!!!
        int userId = 1;

        //add the ride to the rides file
        Ride ride = new Ride(rideService.generateRideId(), userId, Integer.parseInt(bikeId), Integer.parseInt(startStationId), Integer.parseInt(endStationId));
        rideService.addRide(ride);

        //move the place of the bike; change the entry in bikeStations file
        bikeStationService.moveBikeFromStartStationToDestinationStation(Integer.parseInt(bikeId), Integer.parseInt(startStationId), Integer.parseInt(endStationId));
    }
}