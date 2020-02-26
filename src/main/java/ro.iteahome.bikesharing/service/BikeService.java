package ro.iteahome.bikesharing.service;


import ro.iteahome.bikesharing.dao.BikeDAO;
import ro.iteahome.bikesharing.exception.BikeSharingBikeDoesNotExistException;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BikeService {

    private BikeDAO bikeDAO = new BikeDAO();
    private HashMap<Integer,Bike> cachedBikes = new HashMap<Integer, Bike>();

    public void cacheBikes() throws BikeSharingTechnicalException {
        this.cachedBikes = this.bikeDAO.readAllBikes();
    }

    public HashMap checkIfCachedBikes() throws BikeSharingTechnicalException {
        if(this.cachedBikes.size()!= 0)
            return this.cachedBikes;
        this.cacheBikes();
        return this.cachedBikes;

    }

    public HashMap<Integer,Bike> getCachedBikes() throws BikeSharingTechnicalException {
        return this.cachedBikes;
    }

    public void addBike(Bike newBike,int stationId) throws BikeSharingException {
        bikeDAO.writeBike(newBike,stationId);
        this.cacheBikes();
    }

    public int generateBikeId() throws BikeSharingException {
        if(this.checkIfCachedBikes().size()!=0)
            return this.checkIfCachedBikes().size()+1;
        else
            return 1;
    }

    public Bike getBikeById(int id) throws BikeSharingException {
            this.checkIfCachedBikes();
            return this.cachedBikes.get(id);
    }

    public int getNumberOfBikesByBrand(String brand) throws BikeSharingTechnicalException {
        int counter = 0;
        for (Object value : this.checkIfCachedBikes().values()) {
            Bike bike = (Bike) value;
            if(bike.getBrand().equals(brand)){
                counter++;
            }
        }
        return counter;
    }

    public int getNumberOfBikesByBrandFromBikeList(String brand,ArrayList<Bike> bikeList){
        int counter = 0;
        for(Bike bike : bikeList)
            if(bike.getBrand().equals(brand))
                counter++;
        return counter;

    }


}
