package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingStationAlreadyExistsException;
import ro.iteahome.bikesharing.model.Station;
import ro.iteahome.bikesharing.service.StationService;

import java.util.Scanner;

public class AdminAddStationUi {
    StationService stationService;
    AdminAddStationUi(StationService stationService){
        this.stationService = stationService;
    }
    public  void adminAddStation() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Station Name: ");
        String name = scanner.nextLine();

        try {
            int id = this.stationService.generateStationId();
            Station station = new Station(id, name);
            this.stationService.addStation(station);
            System.out.println("Station successfully added: " + station.getId() + " " + station.getName());
        } catch (
                BikeSharingStationAlreadyExistsException e) {
            e.printStackTrace();
            System.out.println("Station already exists");
        } catch (
                BikeSharingException e) {
            e.printStackTrace();
        }

    }
}
