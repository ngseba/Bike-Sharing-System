package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Occurrence;
import ro.iteahome.bikesharing.model.Query;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.QueryService;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.UserService;

public class UserBorrowedMostBikesUI {
    RideService rideService;
    UserService userService = new UserService();
    QueryService queryService = new QueryService();
    Query query = new Query();
    UserBorrowedMostBikesUI(RideService rideService)
    {
        this.rideService = rideService;
    }
    public void printUserWhoBorrowedMostBikes() throws BikeSharingException {
        Occurrence occurrence = this.rideService.getSortedListOfOccurrencesByUser();
        User user = this.userService.getUserById(occurrence.getId());
        int nrBikes = occurrence.getNumberOfOccurences();
        String message = "The user who borrowed the most bikes in the last 6 months :";
        String queryResult = user.getName()+" - borrowed "+nrBikes+" bikes.";
        System.out.println(message);
        System.out.println(queryResult);
        this.query.setMessage(message);
        this.query.addQueryResult(queryResult);
        this.queryService.printQuery(this.query);
    }
}
