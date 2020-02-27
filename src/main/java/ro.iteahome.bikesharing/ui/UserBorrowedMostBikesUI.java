package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.service.RideService;

public class UserBorrowedMostBikesUI {
    RideService rideService;
    UserBorrowedMostBikesUI(RideService rideService)
    {
        this.rideService = rideService;
    }
    public void printUserWhoBorrowedMostBikes() throws BikeSharingException {
        System.out.println("The user "+this.rideService.getSortedListOfOccurrencesByUser().getName()+" borrowed the most bikes in the last 6 months.");
    }
}
