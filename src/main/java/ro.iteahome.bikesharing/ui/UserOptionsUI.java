package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.StationService;
import ro.iteahome.bikesharing.ui.validator.UserProfileUI;

import java.util.Scanner;

import static java.lang.System.exit;

public class UserOptionsUI {
    private StationService stationService = new StationService();
    private BikeService bikeService = new BikeService();
    private RideService rideService = new RideService(this.stationService,this.bikeService);
    private NumberOfBikesUI numberOfBikesUI = new NumberOfBikesUI(this.stationService,this.bikeService);
    private StationGreatestBrandBikesUI stationGreatestBrandBikesUI = new StationGreatestBrandBikesUI(this.stationService,this.bikeService);
    private TopStationsUI topStationsUI = new TopStationsUI(this.rideService);
    private UserHistoryBorrowedBikesUI userHistoryBorrowedBikesUI;
    private UserProfileUI userProfileUI;
    private AddRideUI addRideUI;
    private User user;

    public UserOptionsUI(User user) {
        this.user = user;
    }

    public  void enteringUserOptionsUI() {
        printMainMessageAndHandleAction(" What do you want to do today? \n" + "1. Ride.\n" + "2. View User Profile.\n" +
                "3. View Ride History.\n" + "4. Top 5 Station per number of borrowed bikes.\n" + "5. Check number of bikes.\n" +
                "6. Station that has the greatest number of brand bikes. \n" + "B. Go back. \n" + "X. Exit session.");
    }

    public  void printMainMessageAndHandleAction(String message) {
        Scanner scanner = new Scanner(System.in);
        String option = new String();
        while(!option.equals('x')){
            System.out.println(message);
            option = scanner.nextLine();
            try {
                switch (option) {
                    case "1":
                        this.addRideUI = new AddRideUI(this.stationService,this.bikeService,this.rideService,this.user);
                        this.addRideUI.displayAddRideUI();
                        break;
                    case "2":
                        this.userProfileUI = new UserProfileUI(this.user);
                        this.userProfileUI.printUserProfile();
                        break;
                    case "3":
                        this.userHistoryBorrowedBikesUI = new UserHistoryBorrowedBikesUI(this.stationService,this.bikeService,this.rideService,this.user);
                        this.userHistoryBorrowedBikesUI.printHistoryOfBorrowedBikes();
                        break;
                    case "4":
                        this.topStationsUI.printTop5Stations();
                        break;
                    case "5":
                        this.numberOfBikesUI.printNumberOfBikes();
                        break;
                    case "6":
                        this.stationGreatestBrandBikesUI.printStationWithGreatestNumberOfBrandBikes();
                        break;
                    case "b":
                    case "B":
                        MainUI mainUI = new MainUI();
                        mainUI.enteringUI();
                    case "x":
                    case "X":
                        System.out.println("You have terminated your session. Thank you and see you soon!");
                        exit(0);

                        break;


                    default:
                        printMainMessageAndHandleAction(" What do you want to do today? \n" + "1. Ride.\n" + "2. View User Profile.\n" +
                                "3. View Ride History.\n" + "4. Top 5 Station per number of borrowed bikes.\n" + "5. Check number of bikes.\n" +"6. Station that has the greatest number of brand bikes\n" + "B. Go back. \n" + "X. Exit session.");
                        return;

                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }


    }
}
