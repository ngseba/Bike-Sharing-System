package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Station;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.StationService;

import java.util.Scanner;

public class StationGreatestBrandBikesUI {
    private StationService stationService = new StationService();
    private BikeService bikeService = new BikeService();

    StationGreatestBrandBikesUI(StationService stationService,BikeService bikeService){
        this.stationService = stationService;
        this.bikeService = bikeService;
    }

    public void printStationWithGreatestNumberOfBrandBikes() throws BikeSharingTechnicalException {
        System.out.println("Insert brand :");
        Scanner scanner = new Scanner(System.in);
        String brand = scanner.nextLine();
        System.out.println("The station with the greatest number of "+brand+" bikes is :"+this.stationService.getStationWithGreatestNumberOfBrandBikes(brand,bikeService));
    }
}
