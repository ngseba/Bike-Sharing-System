package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Query;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.QueryService;
import ro.iteahome.bikesharing.service.StationService;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfBikesUI {
    StationService stationService;
    BikeService bikeService;
    QueryService queryService = new QueryService();
    Query query = new Query();

    NumberOfBikesUI(StationService stationService,BikeService bikeService){this.stationService = stationService;this.bikeService = bikeService;}
    void printNumberOfBikes() throws BikeSharingException {
        System.out.println("Check number of bikes :");
        System.out.println("1.By station");
        System.out.println("2.By brand");
        System.out.println("3.By brand and station");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option){
            case 1:
                this.printNumberOfBikesByStation();
                break;
            case 2:
                this.printNumberOfBikesByBrand();
                break;
            case 3:
                this.printNumberOfBikesByStationAndBrand();
                break;
        }
    }

    void printNumberOfBikesByStation() throws BikeSharingException {
        System.out.println("Stations : ");
        this.stationService.checkIfCachedStations().forEach((id, station) -> System.out.println(station));
        Scanner scanner = new Scanner(System.in);
        int stationId = scanner.nextInt();
        String message = "Number of bikes by station :"+stationService.getStationById(stationId).getName();
        String queryResult =Integer.toString(this.stationService.getNumberOfBikesByStation(stationId));
        System.out.println(message);
        System.out.println(queryResult);
        this.query.setMessage(message);
        this.query.addQueryResult(queryResult);
        this.queryService.printQuery(query);
    }

    void printNumberOfBikesByBrand() throws BikeSharingTechnicalException {
        System.out.println("Insert brand name");
        Scanner scanner = new Scanner(System.in);
        String brand = scanner.nextLine();
        String message = "Number of bikes by brand :"+brand;
        String queryResult = Integer.toString(this.bikeService.getNumberOfBikesByBrand(brand));
        System.out.println(message);
        System.out.println(queryResult);
        this.query.setMessage(message);
        this.query.addQueryResult(queryResult);
        this.queryService.printQuery(this.query);
    }



    void printNumberOfBikesByStationAndBrand() throws BikeSharingException {
        System.out.println("Stations : ");
        this.stationService.checkIfCachedStations().forEach((id, station) -> System.out.println(station));
        Scanner scanner = new Scanner(System.in);
        int stationId = scanner.nextInt();
        ArrayList<Bike> bikeList = this.stationService.getBikeList(stationId);
        System.out.println("Insert brand name");
        scanner.nextLine();
        String brand = scanner.nextLine();
        String message = "Number of bikes by station :"+this.stationService.getStationById(stationId).getName()+" and by brand :"+brand+" :";
        String queryResult = Integer.toString(this.bikeService.getNumberOfBikesByBrandFromBikeList(brand,bikeList));
        System.out.println(message);
        System.out.println(queryResult);
        this.query.setMessage(message);
        this.query.addQueryResult(queryResult);
        this.queryService.printQuery(this.query);
    }

}
