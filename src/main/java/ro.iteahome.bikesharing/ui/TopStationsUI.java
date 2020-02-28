package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Occurrence;
import ro.iteahome.bikesharing.service.RideService;

import java.util.List;

public class TopStationsUI {
    RideService rideService;
    TopStationsUI(RideService rideService){
        this.rideService = rideService;
    }

    void printTop5Stations() throws BikeSharingException {
        List<Occurrence> occurrenceList = this.rideService.getSortedListOfOccurencesByStartStation(this.rideService.getAllRides());
        int nrStations = occurrenceList.size()<5?occurrenceList.size():5;
        for(int i=0;i<nrStations;i++){
            System.out.println(i+1+". "+this.rideService.getStationService().getStationById(occurrenceList.get(i).getId()).getName()+" - "+occurrenceList.get(i).getNumberOfOccurences()+" borrowed bikes");
        }
    }
}
