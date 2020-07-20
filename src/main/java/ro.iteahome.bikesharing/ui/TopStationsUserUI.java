package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Occurrence;
import ro.iteahome.bikesharing.model.Query;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.QueryService;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.UserService;
import sun.nio.cs.US_ASCII;

import java.util.List;
import java.util.Scanner;

public class TopStationsUserUI {
    RideService rideService;
    QueryService queryService = new QueryService();
    Query query = new Query();
    TopStationsUserUI(RideService rideService){
        this.rideService = rideService;
    }

    void printTopStationsPerUser() throws BikeSharingException {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a user from the list :");
        List<User> userList = userService.getUserList();
        for(User user:userList){
            System.out.println(user);
        }
        int userId = scanner.nextInt();
        List<Occurrence> occurrenceList = this.rideService.getSortedListOfOccurencesByStartStation(this.rideService.getAllRidesByUserId(userId));
        int nrStations = occurrenceList.size()<3?occurrenceList.size():3;
        String message = "Top 3 stations for the user: "+userService.getUserById(userId).getName();
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
