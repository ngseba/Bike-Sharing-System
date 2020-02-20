package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.StationService;

import java.util.Scanner;

public class AddRideUI {

    private RideService rideService = new RideService();
    private StationService stationService = new StationService();

    public void displayAddRideUI() throws BikeSharingTechnicalException {

        //from where?
        //diaplay stations
        //stationService.printOutAllStations();

        //choose station

        //with which bike?
        //display bikes in station that has been chosen

        //to where?
        //display stations
        //stationService.printOutAllStations();

        //choose station

        //create ride
        //move bike


    }
}