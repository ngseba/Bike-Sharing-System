package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.StationService;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfBikesUI {
    StationService stationService;
    BikeService bikeService;

    NumberOfBikesUI(StationService stationService,BikeService bikeService){this.stationService = stationService;this.bikeService = bikeService;}
    void printNumberOfBikes() throws BikeSharingTechnicalException {
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

    void printNumberOfBikesByStation() throws BikeSharingTechnicalException {
        System.out.println("Stations : ");
        this.stationService.checkIfCachedStations().forEach((id, station) -> System.out.println(station));
        Scanner scanner = new Scanner(System.in);
        int stationId = scanner.nextInt();
        System.out.println(this.stationService.getNumberOfBikesByStation(stationId));
    }

    void printNumberOfBikesByBrand() throws BikeSharingTechnicalException {
        System.out.println("Insert brand name");
        Scanner scanner = new Scanner(System.in);
        String brand = scanner.nextLine();
        System.out.println(brand);
        System.out.println(this.bikeService.getNumberOfBikesByBrand(brand));
    }



    void printNumberOfBikesByStationAndBrand() throws BikeSharingTechnicalException {
        System.out.println("Stations : ");
        this.stationService.checkIfCachedStations().forEach((id, station) -> System.out.println(station));
        Scanner scanner = new Scanner(System.in);
        int stationId = scanner.nextInt();
        ArrayList<Bike> bikeList = this.stationService.getBikeList(stationId);
        System.out.println("Insert brand name");
        scanner.nextLine();
        String brand = scanner.nextLine();
        System.out.println(this.bikeService.getNumberOfBikesByBrandFromBikeList(brand,bikeList));
    }

}
