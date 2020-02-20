package ro.iteahome.bikesharing.service;

import ro.iteahome.bikesharing.dao.BikeStationDAO;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike_Station;

import java.io.IOException;

public class BikeStationService {

    private BikeStationDAO bikeStationDAO = new BikeStationDAO();


    public void moveBikeFromStartStationToDestinationStation(int bikeId, int startStationId, int destinationStationId) throws IOException, BikeSharingTechnicalException {

        //if startStation is different from destinationStation, we change the bike's station
        if (startStationId != destinationStationId) {

            Bike_Station startPosition = new Bike_Station(bikeId, startStationId);

            bikeStationDAO.removeOldPosition(startPosition);
            bikeStationDAO.writeBikeToStation(bikeId, destinationStationId);
        }
    }


}
