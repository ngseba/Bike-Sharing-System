package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.model.Occurrence;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.UserService;
import sun.nio.cs.US_ASCII;

import java.util.List;
import java.util.Scanner;

public class TopStationsUserUI {
    RideService rideService;
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
        System.out.println("Top 3 stations for the user: "+userService.getUserById(userId).getName());
        for(int i=0;i<nrStations;i++){
            System.out.println(i+1+". "+this.rideService.getStationService().getStationById(occurrenceList.get(i).getId()).getName()+" - "+occurrenceList.get(i).getNumberOfOccurences()+" borrowed bikes");
        }
    }
}
