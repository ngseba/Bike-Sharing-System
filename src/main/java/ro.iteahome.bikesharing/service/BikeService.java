package ro.iteahome.bikesharing.service;


import ro.iteahome.bikesharing.dao.BikeDAO;
import ro.iteahome.bikesharing.dao.BikeStationDAO;
import ro.iteahome.bikesharing.dao.StationDAO;
import ro.iteahome.bikesharing.exception.BikeSharingBikeDoesNotExistException;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;

public class BikeService {

    private BikeDAO bikeDAO = new BikeDAO();
    private BikeStationService bikeStationService = new BikeStationService();


    public void addBike(Bike newBike) throws BikeSharingException {
        bikeDAO.writeBike(newBike);
    }

    public int generateBikeId() throws BikeSharingException {
        if (!bikeDAO.readAllBikes().isEmpty()) {
            for (Bike bike : bikeDAO.readAllBikes()) {
                System.out.println(bike);
            }
            return bikeDAO.readAllBikes().size() + 1;
        }
        return 1;
    }

    public Bike getBikeById(int id) throws BikeSharingException {
        if (!bikeDAO.readAllBikes().isEmpty()) {
            for (Bike bike : bikeDAO.readAllBikes()) {
                if (bike.getId() == id)
                    return bike;
            }
        }
        throw new BikeSharingBikeDoesNotExistException();
    }

    public void printOutBikesOfStation(int stationId) throws BikeSharingException {
        if (!bikeDAO.readAllBikes().isEmpty()) {
            for (int i : bikeStationService.getBikesOfStationByStationId(stationId)) {
                Bike bike = getBikeById(i);
                System.out.println(bike.getId() + " " + bike.getBrand());
            }
        }

    }
}
