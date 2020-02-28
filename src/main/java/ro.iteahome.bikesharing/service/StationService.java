package ro.iteahome.bikesharing.service;


import ro.iteahome.bikesharing.dao.BikeDAO;
import ro.iteahome.bikesharing.dao.StationDAO;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingStationAlreadyExistsException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Occurrence;
import ro.iteahome.bikesharing.model.Station;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StationService {

    private StationDAO stationDAO = new StationDAO();
    private BikeDAO bikeDAO = new BikeDAO();
    HashMap <Integer,Station> cachedStations = new HashMap<>();


    public void cacheStations() throws BikeSharingTechnicalException {
        this.cachedStations = this.stationDAO.readAllStations();
    }

    public HashMap checkIfCachedStations() throws BikeSharingTechnicalException {
        if(this.cachedStations.size()!= 0)
            return this.cachedStations;
        this.cacheStations();
        return this.cachedStations;

    }

    public void addStation(Station newStation) throws BikeSharingException {

        for (Map.Entry<Integer, Station> entry : this.cachedStations.entrySet()) {
            Integer id = entry.getKey();
            Station station = entry.getValue();
            if (newStation.equals(station.getName()))
                throw new BikeSharingStationAlreadyExistsException();
        }
        stationDAO.writeStation(newStation);
        this.cacheStations();
    }




    public int generateStationId() throws BikeSharingException {
        if(this.checkIfCachedStations().size()!=0)
            return this.checkIfCachedStations().size()+1;
        else
            return 1;
    }

    public ArrayList<Bike> getBikeList(int stationId) {
        try {
            cachedStations.get(stationId).setAvailableBikes(bikeDAO.readBikeFromStation(stationId));
        }
        catch (BikeSharingTechnicalException e){
            e.printStackTrace();
            System.out.println("Cannot read bikes");
        }
        return cachedStations.get(stationId).getAvailableBikes();
    }


    public void moveBikeFromStartStationToDestinationStation(Bike bike, int startStationId, int destinationStationId) throws BikeSharingTechnicalException, IOException {
        if (startStationId != destinationStationId) {
            bikeDAO.removeOldPosition(bike,startStationId);
            bikeDAO.writeBike(bike, destinationStationId);
        }
    }

    public Station getStationById(int id) throws BikeSharingException {
        this.checkIfCachedStations();
        return this.cachedStations.get(id);
    }

    public int getNumberOfBikesByStation(int stationId)
    {
        ArrayList<Bike> bikeList = this.getBikeList(stationId);
        return bikeList.size();
    }

    public Station getStationWithGreatestNumberOfBrandBikes(String brand,BikeService bikeService) throws BikeSharingTechnicalException {
        Station greatestStation = new Station();
        int max = 0;
        for (Object value : this.checkIfCachedStations().values()) {
            Station station = (Station) value;
            if(max < bikeService.getNumberOfBikesByBrandFromBikeList(brand,this.getBikeList(station.getId()))){
                 max = bikeService.getNumberOfBikesByBrandFromBikeList(brand,this.getBikeList(station.getId()));
                 greatestStation = station;
            }
        }
        return greatestStation;
    }



}
