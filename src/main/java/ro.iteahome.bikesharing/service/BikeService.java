package ro.iteahome.bikesharing.service;


import ro.iteahome.bikesharing.dao.BikeDAO;
import ro.iteahome.bikesharing.exception.BikeSharingBikeDoesNotExistException;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Bike;

public class BikeService {

    private BikeDAO bikeDAO = new BikeDAO();



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



}
