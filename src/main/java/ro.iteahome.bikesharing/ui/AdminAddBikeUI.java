package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.dao.BikeDAO;
import ro.iteahome.bikesharing.dao.StationDAO;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingStationDoesNotExistException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Station;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.StationService;


import java.util.List;
import java.util.Scanner;

public class AdminAddBikeUI {
    private StationService stationService;
    private BikeService bikeService;
    AdminAddBikeUI(StationService stationService,BikeService bikeService)
    {
        this.stationService = stationService;
        this.bikeService = bikeService;

    }

    public  void adminAddBike() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bike Brand: ");
        String brand = scanner.nextLine();

        try {
            int bikeId = this.bikeService.generateBikeId();
            Bike bike = new Bike(bikeId, brand);
            System.out.println("Bike successfully added: " + bike.getId() + " " + bike.getBrand());
            System.out.println("Which station would you like to assign this bike to? ");
            System.out.println("Stations : ");
            this.stationService.checkIfCachedStations().forEach((id, station) -> System.out.println(station));
            int stationId = scanner.nextInt();
            this.bikeService.addBike(bike,stationId);
            System.out.println("Bike succesfully added");
            this.stationService.cacheStations();
        } catch (
                BikeSharingTechnicalException e) {
            e.printStackTrace();
        } catch (
                BikeSharingException e) {
            e.printStackTrace();
            System.out.println("Could not add bike.");
        }

    }
}
