package ro.iteahome.bikesharing.service;

import ro.iteahome.bikesharing.dao.BikeStationDAO;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.BikeStation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BikeStationService {

    private BikeStationDAO bikeStationDAO = new BikeStationDAO();


    public void moveBikeFromStartStationToDestinationStation(int bikeId, int startStationId, int destinationStationId) throws IOException, BikeSharingTechnicalException {

        //if startStation is different from destinationStation, we change the bike's station
        if (startStationId != destinationStationId) {

            BikeStation startPosition = new BikeStation(bikeId, startStationId);

            bikeStationDAO.removeOldPosition(startPosition);
            bikeStationDAO.writeBikeToStation(bikeId, destinationStationId);
        }
    }

    //Get a list of bike Ids - the Ids of the bikes in a certain station
    public List<Integer> getBikesOfStationByStationId(int stationId) throws BikeSharingTechnicalException {
        List<Integer> bikeIds = new ArrayList<Integer>();
        if (!bikeStationDAO.readAllBikeStation().isEmpty()) {
            for (BikeStation bikeStation : bikeStationDAO.readAllBikeStation()) {
                if (bikeStation.getStationId() == stationId)
                    bikeIds.add(bikeStation.getBikeId());
            }

        }
        return bikeIds;
    }

    //Print out a list of bike Ids - the Ids of the bikes in a certain station
    public void printOutBikesOfStationByStationId(int stationId) throws BikeSharingTechnicalException {
        List<Integer> bikeIds = getBikesOfStationByStationId(stationId);
        if (!bikeIds.isEmpty())
            for (int i  : bikeIds) {
                System.out.println(i + " ");
            }
    }

}
