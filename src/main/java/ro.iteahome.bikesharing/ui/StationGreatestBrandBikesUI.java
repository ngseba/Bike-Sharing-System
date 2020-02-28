package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Query;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.QueryService;
import ro.iteahome.bikesharing.service.StationService;

import java.util.Scanner;

public class StationGreatestBrandBikesUI {
    private StationService stationService;
    private BikeService bikeService;
    private QueryService queryService = new QueryService();
    private Query query = new Query();

    StationGreatestBrandBikesUI(StationService stationService,BikeService bikeService){
        this.stationService = stationService;
        this.bikeService = bikeService;
    }

    public void printStationWithGreatestNumberOfBrandBikes() throws BikeSharingTechnicalException {
        System.out.println("Insert brand :");
        Scanner scanner = new Scanner(System.in);
        String brand = scanner.nextLine();
        String message = "The station with the greatest number of "+brand+" bikes is :";
        String queryResult = this.stationService.getStationWithGreatestNumberOfBrandBikes(brand,bikeService).getName();
        System.out.println(message+queryResult);
        this.query.setMessage(message);
        this.query.addQueryResult(queryResult);
        this.queryService.printQuery(this.query);


    }
}
