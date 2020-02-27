package ro.iteahome.bikesharing.ui;


import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.RideService;
import ro.iteahome.bikesharing.service.StationService;
import ro.iteahome.bikesharing.service.UserService;

import java.util.Scanner;

import static java.lang.System.exit;

public class AdminOptionsUi {
    private StationService stationService = new StationService();
    private BikeService bikeService = new BikeService();
    private RideService rideService = new RideService(this.bikeService);
    private UserService userService = new UserService();
    private AdminAddStationUi adminAddStationUi = new AdminAddStationUi(this.stationService);
    private AdminAddBikeUI adminAddBikeUI = new AdminAddBikeUI(this.stationService,this.bikeService);;
    private AdminHistoryBorrowedBikesUI adminHistoryBorrowedBikesUI = new AdminHistoryBorrowedBikesUI(this.stationService,this.bikeService,this.rideService,this.userService);
    private NumberOfBikesUI numberOfBikesUI = new NumberOfBikesUI(this.stationService,this.bikeService);
    private StationGreatestBrandBikesUI stationGreatestBrandBikesUI = new StationGreatestBrandBikesUI(this.stationService,this.bikeService);
    private UserBorrowedMostBikesUI userBorrowedMostBikesUI = new UserBorrowedMostBikesUI(this.rideService);

    public  void enteringAdminOptionsUI() {

        printMainMessageAndHandleAction("What do you want to do today? \n" + "1. Add new Station.\n" +
                "2. Add new Bike .\n" + "3. History of borrowed bikes per user.\n" + "4. User who borrowed the most bikes in the last 6 months\n" + "5. The most common day of the week when bikes are borrowed.\n" +
                "6. Popular stations per User.\n" + "7. Top 5 Station per number of borrowed bikes.\n" + "8. Check number of bikes\n" + "9. Station that has the greatest number of brand bikes\n"+ "B. Go back. \n" + "X. Exit session.");

    }

    public  void printMainMessageAndHandleAction(String message) {
        Scanner userOptions = new Scanner(System.in);
        String option = new String();
        while(!option.equals('x')){
            System.out.println(message);
            option = userOptions.nextLine();
            try {
            switch (option) {
                case "1":
                    this.adminAddStationUi.adminAddStation();
                    break;
                case "2":
                    this.adminAddBikeUI.adminAddBike();
                    break;
                case "3":
                    this.adminHistoryBorrowedBikesUI.printHistoryOfBorrowedBikes();
                    break;
                case "4":
                    this.userBorrowedMostBikesUI.printUserWhoBorrowedMostBikes();
                    break;
                case "5":
                    System.out.println(this.rideService.getMostCommonDay());
                    break;
                case "6":
                    //popular stations per user
                    break;
                case "7":
                    //7. Top 5 Station per number of borrowed bikes
                    break;
                case "8":
                    this.numberOfBikesUI.printNumberOfBikes();
                    break;
                case "9":
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
                    printMainMessageAndHandleAction("What do you want to do today? \n" + "1. Add new Station.\n" +
                            "2. Add new Bike .\n" + "3. History of borrowed bikes per user.\n" + "4. User who borrowed the most bikes in the last 6 months\n" + "5. The most common day of the week when bikes are borrowed.\n" +
                            "6. Popular stations per User.\n" + "7. Top 5 Station per number of borrowed bikes.\n" + "8. Check number of bikes\n " + "9. Station that has the greatest number of brand bikes\n "+ "B. Go back. \n" + "X. Exit session.");
                    return;

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        }


    }
}