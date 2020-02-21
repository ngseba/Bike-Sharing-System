//package ro.iteahome.bikesharing.ui;
//
//import ro.iteahome.bikesharing.dao.BikeStationDAO;
//import ro.iteahome.bikesharing.dao.StationDAO;
//import ro.iteahome.bikesharing.exception.BikeSharingException;
//import ro.iteahome.bikesharing.exception.BikeSharingStationDoesNotExistException;
//import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
//import ro.iteahome.bikesharing.model.Bike;
//import ro.iteahome.bikesharing.model.Station;
//import ro.iteahome.bikesharing.service.BikeService;
//
//import java.util.List;
//
//public class AdminAddBikeUI {
//
//     System.out.println("Bike Brand: ");
//    String brand = scanner.nextLine();
//
//        try {
//        BikeService bikeService = new BikeService();
//        int bikeId = bikeService.generateBikeId();
//        Bike bike = new Bike(bikeId, brand);
//        bikeService.addBike(bike);
//        System.out.println("Bike successfully added: " + bike.getId() + " " + bike.getBrand());
//        System.out.println("To which station do you want to assign the bike ? ");
//        StationDAO stationDAO = new StationDAO();
//        List<Station> stationList = stationDAO.readAllStations();
//        for (Station station : stationList)
//            System.out.println(station);
//        int stationId = scanner.nextInt();
//        BikeStationDAO bikeStationDAO = new BikeStationDAO();
//        bikeStationDAO.writeBikeToStation(stationId, bikeId);
//    } catch (
//    BikeSharingTechnicalException e) {
//        e.printStackTrace();
//    } catch (
//    BikeSharingException e) {
//        e.printStackTrace();
//        System.out.println("Could not add bike.");
//    }
//        try {
//        BikeStationDAO bikeStationDAO = new BikeStationDAO();
//        List<Station> stationList = bikeStationDAO.readBikeToStation();
//        for (Station station : stationList) {
//            System.out.println(station.getAvailableBikes().size());
//            for (Bike bike : station.getAvailableBikes()) {
//                System.out.println(bike);
//            }
//        }
//
//    } catch (BikeSharingTechnicalException | BikeSharingStationDoesNotExistException e) {
//        e.printStackTrace();
//    }
//
//
//}
