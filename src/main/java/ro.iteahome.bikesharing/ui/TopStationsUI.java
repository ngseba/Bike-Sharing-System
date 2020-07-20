package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Occurrence;
import ro.iteahome.bikesharing.model.Query;
import ro.iteahome.bikesharing.service.QueryService;
import ro.iteahome.bikesharing.service.RideService;

import java.util.List;

public class TopStationsUI {
    RideService rideService;
    QueryService queryService = new QueryService();
    Query query = new Query();
    TopStationsUI(RideService rideService){
        this.rideService = rideService;
    }

    void printTop5Stations() throws BikeSharingException {
        List<Occurrence> occurrenceList = this.rideService.getSortedListOfOccurencesByStartStation(this.rideService.getAllRides());
        int nrStations = occurrenceList.size()<5?occurrenceList.size():5;
        String message = "Top 5 Station per number of borrowed bikes :";
        System.out.println(message);
        this.query.setMessage(message);
        for(int i=0;i<nrStations;i++){
            String queryResult = i+1+". "+this.rideService.getStationService().getStationById(occurrenceList.get(i).getId()).getName()+" - "+occurrenceList.get(i).getNumberOfOccurences()+" borrowed bikes";
            System.out.println(queryResult);
            this.query.addQueryResult(queryResult);
        }
        this.queryService.printQuery(this.query);
    }
}
