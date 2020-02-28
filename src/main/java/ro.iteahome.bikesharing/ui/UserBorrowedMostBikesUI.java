package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Occurrence;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.UserService;

public class UserBorrowedMostBikesUI {
    RideService rideService;
    UserService userService;
    UserBorrowedMostBikesUI(UserService userService,RideService rideService)
    {
        this.userService = userService;
        this.rideService = rideService;

    }
    public void printUserWhoBorrowedMostBikes() throws BikeSharingException {
        Occurrence occurrence = this.rideService.getSortedListOfOccurrencesByUser();
        User user = this.userService.getUserById(occurrence.getId());
        int nrBikes = occurrence.getNumberOfOccurences();
        System.out.println("The user "+user.getName()+" borrowed the most bikes ("+nrBikes+") in the last 6 months.");
    }
}
