//package ro.iteahome.bikesharing.ui;
//
//import ro.iteahome.bikesharing.exception.BikeSharingException;
//import ro.iteahome.bikesharing.exception.BikeSharingStationAlreadyExistsException;
//import ro.iteahome.bikesharing.model.Station;
//import ro.iteahome.bikesharing.service.StationService;
//
//import java.util.Scanner;
//
//public class AdminAddStationUi {
//
//    Scanner scanner = new Scanner(System.in);
//        System.out.println("Station Name: ");
//    String name = scanner.nextLine();
//
//        try {
//        StationService stationService = new StationService();
//        int id = stationService.generateStationId();
//        Station station = new Station(id, name);
//        stationService.addStation(station);
//        System.out.println("Station successfully added: " + station.getId() + " " + station.getName());
//    } catch (
//    BikeSharingStationAlreadyExistsException e) {
//        e.printStackTrace();
//        System.out.println("Station already exists");
//    } catch (
//    BikeSharingException e) {
//        e.printStackTrace();
//    }
//
//}
